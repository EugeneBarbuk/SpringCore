package spring.core.logger;

import spring.core.beans.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private int cacheSize;
    List<Event> cache = new ArrayList<>();

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    public void destroy() {
        if ( !cache.isEmpty() )
            writeEventToFile("on Destroy");
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            writeEventToFile(event.getMsg());
            cache.clear();
        }
    }
}