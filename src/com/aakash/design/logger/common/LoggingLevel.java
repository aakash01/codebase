package com.aakash.design.logger.common;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/20/17.
 */
public enum LoggingLevel {

    OFF(0),
    INFO(1),
    ERROR(2),
    WARNING(3),
    DEBUG(4);

    private int level;

    LoggingLevel(int level){
        this.level = level;
    }

    public boolean isLoggable(LoggingLevel level){
        return this.level >= level.level;
    }

}
