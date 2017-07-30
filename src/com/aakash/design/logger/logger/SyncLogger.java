package com.aakash.design.logger.logger;

import com.aakash.design.logger.common.LoggingLevel;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/20/17.
 */
public class SyncLogger extends Logger{


    public SyncLogger(String name) {
        super(name);
    }

    public void LOG(LoggingLevel messageLevel, String message){
        if(!this.level.isLoggable(messageLevel)){
            System.out.println("Skipping message.");
            return;
        }
        LogRecord logRecord = new LogRecord(messageLevel, message);
        logMessage(logRecord);
    }
}
