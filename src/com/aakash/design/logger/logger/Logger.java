package com.aakash.design.logger.logger;

import com.aakash.design.logger.appender.Appender;
import com.aakash.design.logger.common.LoggingLevel;
import com.aakash.design.logger.formatter.Formatter;
import com.aakash.design.logger.formatter.SimpleFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/20/17.
 */
public abstract class Logger {

    private final String name;
    LoggingLevel level = LoggingLevel.DEBUG;
    Formatter formatter = new SimpleFormatter();
    List<Appender> appenders = new ArrayList<>();

    public Logger(String name){
        this.name = name;
        //this.level = level;
        //this.formatter = formatter;
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public void setLevel(LoggingLevel level) {
        this.level = level;
    }

    public Formatter getFormatter() {
        return formatter;
    }

    public void setFormatter(Formatter formatter) {
        this.formatter = formatter;
    }

    public void addAppender(Appender appender){
        if(appender.getFormatter() == null){
            appender.setFormatter(formatter);
        }
        this.appenders.add(appender);
    }

    public abstract void LOG(LoggingLevel messageLevel, String message);

    protected void logMessage(LogRecord logRecord){
        for(Appender appender: appenders){
            appender.appendLog(logRecord);
        }
    }

    public void INFO(String message){
        LOG(LoggingLevel.INFO, message);
    }

    public void DEBUG(String message){
        LOG(LoggingLevel.DEBUG, message);
    }

    public void WARNING(String message){
        LOG(LoggingLevel.WARNING, message);
    }

    public void ERROR(String message){
        LOG(LoggingLevel.ERROR, message);
    }
}
