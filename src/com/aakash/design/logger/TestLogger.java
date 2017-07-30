package com.aakash.design.logger;

import com.aakash.design.logger.appender.Appender;
import com.aakash.design.logger.appender.ConsoleAppender;
import com.aakash.design.logger.appender.FileAppender;
import com.aakash.design.logger.common.LoggingLevel;
import com.aakash.design.logger.formatter.BasicFormatter;
import com.aakash.design.logger.logger.LogManager;
import com.aakash.design.logger.logger.Logger;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/20/17.
 */
public class TestLogger {
    private static final Logger logger =  LogManager.getLogManager().getLogger("testLogger", true);
    static {
        Appender consoleAppender = new ConsoleAppender();
        consoleAppender.setFormatter(new BasicFormatter());
        consoleAppender.setLevel(LoggingLevel.ERROR);
        logger.addAppender(consoleAppender);

        Appender fileAppender = new FileAppender("/Users/a0n007d/Personal/dev/src/com/aakash/design/logger/test.log");
        fileAppender.setLevel(LoggingLevel.DEBUG);
        logger.addAppender(fileAppender);

        logger.setLevel(LoggingLevel.DEBUG);
    }


    public static void main(String[] args) throws InterruptedException {
        logger.INFO("This is Info");
        logger.DEBUG("This is Debug");
        logger.WARNING("This is Warning");
        logger.ERROR("This is Error");

        Thread.sleep(80000);
    }
}
