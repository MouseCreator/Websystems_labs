FROM openjdk:17-jdk-alpine
WORKDIR /app
ARG app_path="target/product-app-1.0.jar"
ARG app_target="/app/product-app-1.0.jar"
COPY ${app_path} ${app_target}

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "product-app-1.0.jar"]
