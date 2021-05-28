package src.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import src.myaop.anno.EnableMyAop;


@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"src.*"})
@EnableMyAop
public class AppConfig {
}
