package spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.core.beans.Client;
import spring.core.beans.Event;
import spring.core.beans.EventType;
import spring.core.logger.EventLogger;

import java.util.Map;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private Map<EventType, EventLogger> loggerMap;
    private Event event;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggerMap ) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggerMap=loggerMap;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) applicationContext.getBean("app");
        app.logEvent("Some event for user 1", EventType.ERROR);
        ((ConfigurableApplicationContext)applicationContext).close();

    }

    private void logEvent(String msg, EventType type) {
        EventLogger logger = loggerMap.get(type);
        System.out.println(logger);
        if (logger == null) {
            logger = eventLogger;
        }
        System.out.println("just to test");
        event.setMsg(client.toString());
        logger.logEvent(event);
    }
}
