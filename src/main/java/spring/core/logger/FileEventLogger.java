package spring.core.logger;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import spring.core.beans.Event;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.logging.log4j.Logger;



@Component
@PropertySource("classpath:logFile.properties")
public class FileEventLogger implements EventLogger {
    public static final Logger LOGGER = LogManager.getLogger();
    private String fileName;
    private File file;

    public FileEventLogger(@Value("${file.name}") String fileName) {
        this.fileName = fileName;
    }

    @PostConstruct
    public void init() throws IOException {
        this.file = new File(fileName);
        if (this.file.exists() && !this.file.canWrite()) {
            throw new IOException();
        } else {
            this.file.createNewFile();
        }
    }

    public void writeEventToFile(String msg) {
        try {
            FileUtils.writeStringToFile(file, msg, StandardCharsets.UTF_8, true);
        } catch (IOException e) {
          LOGGER.error(e);
        }
    }

    @Override
    public void logEvent(Event event) {
        writeEventToFile(event.getMsg() + event.getId());
    }
}
