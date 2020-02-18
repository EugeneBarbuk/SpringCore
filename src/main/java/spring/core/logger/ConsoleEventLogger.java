package spring.core.logger;

import org.springframework.stereotype.Component;
import spring.core.beans.Event;

@Component
public class ConsoleEventLogger implements EventLogger {

    @Override
    public void logEvent(Event event) {
        System.out.println(event);
    }
}
