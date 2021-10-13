package src.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import src.myaop.anno.EnableMyAop;

import java.nio.charset.StandardCharsets;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"src.*"})
@EnableMyAop
public class AppConfig {

    @Bean
    MultipartResolver multipartResolver() {
        CommonsMultipartResolver fileResolver = new CommonsMultipartResolver();
        fileResolver.setDefaultEncoding(StandardCharsets.UTF_8.name());
        //100MB
        fileResolver.setMaxUploadSize(1024 * 1024 * 100);
        //10MB内存
        fileResolver.setMaxInMemorySize(1024 * 1024 * 10);
        return fileResolver;
    }
}
