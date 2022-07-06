package Kata_4;

import java.util.logging.*;

public class Loger {
    public static void logging() {
        final Logger logger = Logger.getLogger("com.javamentor.logging.Test");
        logger.log(Level.INFO, "Все хорошо");
        logger.warning("Произошла ошибка");
    }
}
