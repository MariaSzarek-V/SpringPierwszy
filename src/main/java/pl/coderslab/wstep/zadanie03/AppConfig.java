package pl.coderslab.wstep.zadanie03;

import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public Captain jackSparrow() {
        return new Captain();
    }

    @Bean
    public Ship blackPearl() {
        return new Ship(jackSparrow());
    }
}