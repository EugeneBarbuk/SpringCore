package spring.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import spring.core.beans.Client;
import spring.core.beans.Event;
import spring.core.beans.EventType;
import spring.core.interfaces.AwareBean;
import spring.core.logger.EventLogger;

import java.util.Map;
@Component
public class App {
    private Client client;
    private EventLogger eventLogger;
    private Map<EventType, EventLogger> loggerMap;
    private Event event;

    @Autowired
    public App(Client client, @Qualifier("consoleEventLogger") EventLogger eventLogger, Event event) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.event=event;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) applicationContext.getBean("app");
        app.logEvent();
        applicationContext.close();

    }

    private void logEvent() {
        event.setMsg(client.toString());
        eventLogger.logEvent(event);
    }
}
