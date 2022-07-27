package base;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;


public class Log {
    private static final Logger log = (Logger) LoggerFactory.getLogger("Test Result");

    public static void info(String message) {
        log.info(message);
    }

    public static void warn(String message) {
        log.warn(message);
    }

    public static void testPass() {
        log.info( " Tests Passed !!");
    }

}
