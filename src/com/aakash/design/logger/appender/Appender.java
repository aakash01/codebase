package com.aakash.design.logger.appender;

import com.aakash.design.logger.common.LoggingLevel;
import com.aakash.design.logger.logger.LogRecord;
import com.aakash.design.logger.formatter.Formatter;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/20/17.
 */
public abstract class Appender {

    private Formatter formatter;
    private LoggingLevel level;

    public final void appendLog(LogRecord logRecord){
        if(!level.isLoggable(logRecord.getLevel())){
            System.out.println("Appender filtered");
            return;
        }
        doAppendLog(logRecord);
    }

    public abstract void doAppendLog(LogRecord logRecord);

    public Formatter getFormatter() {
        return formatter;
    }

    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }


    public LoggingLevel getLevel() {
        return level;
    }

    public void setLevel(LoggingLevel level) {
        this.level = level;
    }
}
