package com.example.lab9compulsory;

import java.io.IOException;
import java.util.logging.*;

public class LogHelper {
    private static final Logger logger = Logger.getLogger(LogHelper.class.getName());
    static {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.SEVERE);
        logger.addHandler(ch);

        try {
            FileHandler fh = new FileHandler("application.log", true);
            fh.setLevel(Level.FINE);
            logger.addHandler(fh);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "File logger not working.", e);
        }
    }

    public static void log(Level level, String msg) {
        logger.log(level, msg);
    }
}
