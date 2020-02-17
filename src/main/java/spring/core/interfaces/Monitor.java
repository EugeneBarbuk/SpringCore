package spring.core.interfaces;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class Monitor implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("Big brother is watching you");
    }
}
