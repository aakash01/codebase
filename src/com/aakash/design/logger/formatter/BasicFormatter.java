package com.aakash.design.logger.formatter;

import com.aakash.design.logger.logger.LogRecord;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/20/17.
 */
public class BasicFormatter extends Formatter {
    @Override
    public String format(LogRecord logRecord) {
        return logRecord.getMessage();
    }
}
