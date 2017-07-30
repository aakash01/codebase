package com.aakash.design.logger.logger;

import com.aakash.design.logger.common.LoggingLevel;

import java.util.Date;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/20/17.
 */
public class LogRecord {

    final LoggingLevel level;
    final String message;
    final Date time = new Date();

    public LogRecord(LoggingLevel level, String message){
        this.level = level;
        this.message = message;
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime(){
        return time;
    }
}
