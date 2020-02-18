package spring.core.logger;

import spring.core.beans.Event;

import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

    private String cacheSize;
    List<Event> cache = new ArrayList<>();

    public CacheFileEventLogger(String fileName, String cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    @PreDestroy
    public void destroy() {
        if ( !cache.isEmpty() )
            writeEventToFile("on Destroy");
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == Integer.parseInt(cacheSize)) {
            writeEventToFile(event.getMsg());
            cache.clear();
        }
    }
}