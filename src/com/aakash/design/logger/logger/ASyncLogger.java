package com.aakash.design.logger.logger;

import com.aakash.design.logger.common.AsyncAppender;
import com.aakash.design.logger.common.LoggingLevel;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/20/17.
 */
public class ASyncLogger extends Logger implements AsyncAppender{

    private Queue<LogRecord> logRecords = new ConcurrentLinkedQueue<>();

    public ASyncLogger(String name) {
        super(name);
    }

    public void LOG(LoggingLevel messageLevel, String message){
        if(!this.level.isLoggable(messageLevel)){
            System.out.println("Skipping message.");
            return;
        }
        LogRecord logRecord = new LogRecord(messageLevel, message);
        logRecords.add(logRecord);
    }

    public void flush(){
        synchronized (logRecords){
            while(!logRecords.isEmpty()){
                logMessage(logRecords.poll());
            }
        }
    }
}
