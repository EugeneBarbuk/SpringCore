package spring.core.logger;

import spring.core.beans.Event;

import java.util.List;

public class CombinedEventLogger implements EventLogger {

    List<EventLogger> loggerList;

    public CombinedEventLogger(List<EventLogger> loggerList) {
        this.loggerList = loggerList;
    }

    @Override
    public void logEvent(Event event) {
        loggerList.forEach(logger->logger.logEvent(event));
    }
}
