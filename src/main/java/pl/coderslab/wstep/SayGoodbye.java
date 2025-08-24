package pl.coderslab.wstep;

import org.springframework.stereotype.Component;

@Component
public class SayGoodbye {

    private final GetMessageComponent getMessageComponent;

    public SayGoodbye(GetMessageComponent getMessageComponent) {
        this.getMessageComponent = getMessageComponent;
    }

    public void hello() {
        System.out.println("Goodbye!");
        System.out.println("Your random message is: " + getMessageComponent.getMessage());
    }
}