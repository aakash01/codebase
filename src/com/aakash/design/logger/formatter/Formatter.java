package com.aakash.design.logger.formatter;

import com.aakash.design.logger.logger.LogRecord;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/20/17.
 */
public abstract class Formatter {

    public abstract String format(LogRecord logRecord);
}
