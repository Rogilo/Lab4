package Music.logging;

import java.io.IOException;
import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log {

    private Logger logger;
    private FileHandler handler;

    public Log(String fileName) throws SecurityException, IOException {
        File file = new File(fileName);
        if(!file.exists()) {
            file.createNewFile();
        }
        handler = new FileHandler(fileName,true);
        logger = Logger.getLogger("Logger");
        logger.addHandler(handler);
        handler.setFormatter(new SimpleFormatter());
    }

    public Logger getLogger() {
        return logger;
    }

}
