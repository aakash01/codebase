package com.aakash.design.logger.appender;

import com.aakash.design.logger.logger.LogRecord;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/20/17.
 */
public class ConsoleAppender extends Appender{

    @Override
    public void doAppendLog(LogRecord logRecord) {
        System.out.println(getFormatter().format(logRecord));
    }
}
