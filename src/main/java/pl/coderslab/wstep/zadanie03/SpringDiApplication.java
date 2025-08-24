package pl.coderslab.wstep.zadanie03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;




public class SpringDiApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Pobranie beana Ship
        Ship ship = context.getBean("blackPearl", Ship.class);

        // Wywołanie metody kapitana
        ship.getCaptain().startSailing();
    }
}
