package pl.coderslab.wstep;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("pl.coderslab")
public class AppConfig {

    @Bean(name = "helloWorld")
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }
}