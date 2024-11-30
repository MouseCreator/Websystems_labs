package mouse.uviv.productsapp.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Log4j2
public class ImageController {
    @GetMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImage() throws IOException {
        log.info("[!CACHE] Getting image");
        ClassPathResource imgFile = new ClassPathResource(("static/image.jpg"));
        return StreamUtils.copyToByteArray(imgFile.getInputStream());
    }
}
