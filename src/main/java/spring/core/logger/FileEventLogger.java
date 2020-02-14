package spring.core.logger;

import org.apache.commons.io.FileUtils;
import spring.core.beans.Event;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileEventLogger implements EventLogger {

    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() throws IOException {
        this.file = new File(fileName);
        if (this.file.exists() && !this.file.canWrite()) {
            throw new IOException();
        } else {
            this.file.createNewFile();
        }
    }

    public void writeEventToFile(String msg){
        try {
            FileUtils.writeStringToFile(file, msg, StandardCharsets.UTF_8, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void logEvent(Event event) {
        writeEventToFile(event.getMsg()+ event.getId());
    }
}
