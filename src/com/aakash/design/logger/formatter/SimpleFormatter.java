package com.aakash.design.logger.formatter;

import com.aakash.design.logger.logger.LogRecord;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/20/17.
 */
public class SimpleFormatter extends Formatter {

    private static final String FORMAT = "Simple Format: %tc - %s - %s";

    @Override
    public String format(LogRecord logRecord) {
        return String.format(FORMAT, logRecord.getTime(), logRecord.getLevel().name(), logRecord.getMessage());
    }
}
