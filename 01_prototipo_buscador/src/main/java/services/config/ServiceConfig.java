package services.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"services.implementations"})
@Configuration
public class ServiceConfig {

}
