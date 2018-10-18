package com.example.logger;


import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ulogger {

    public static void log(Logger logger, Level level, Supplier<String> msgSupplier) {
        if (logger.isLoggable(level)) {
            logger.log(level, msgSupplier.get());
        }
    }
}
