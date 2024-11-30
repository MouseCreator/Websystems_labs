package mouse.uviv.productsapp;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableCaching
public class ProductsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsAppApplication.class, args);
	}

	@Bean
	@Profile({"map_cache", "default"})
	public CacheManager concurrentMap() {
		SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

		simpleCacheManager.setCaches(List.of(new ConcurrentMapCache("products")));
		return simpleCacheManager;
	}

	@Bean
	@Profile("caffeine_cache")
	public CacheManager caffeineCache() {
		SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
		Cache<Object, Object> caffeine = Caffeine.newBuilder()
				.expireAfterWrite(1, TimeUnit.MINUTES)
				.expireAfterAccess(30, TimeUnit.SECONDS)
				.maximumSize(1000).build();
		CaffeineCache caffeineCache = new CaffeineCache("products", caffeine);
		simpleCacheManager.setCaches(List.of(caffeineCache));
		return simpleCacheManager;
	}


}
