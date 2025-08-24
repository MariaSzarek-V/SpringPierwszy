package pl.coderslab.wstep;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDiApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SayGoodbye test = context.getBean(SayGoodbye.class);
        test.hello();

        HelloWorld bean = context.getBean("helloWorld", HelloWorld.class);
        bean.hello();

    }
}
