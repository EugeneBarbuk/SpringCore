package spring.core.interfaces;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AwareBean implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }
    public void init(){
        System.out.println("Beware beware the fifth of november");
    }
}
