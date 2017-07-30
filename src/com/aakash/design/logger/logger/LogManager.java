package com.aakash.design.logger.logger;

import com.aakash.design.logger.common.AsyncAppender;
import com.aakash.design.logger.common.AsyncPeriodicAppender;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/20/17.
 */
public class LogManager {

    private Map<String, Logger> loggerMap;
    private AsyncPeriodicAppender asyncPeriodicAppender;
    private static final LogManager logManager = new LogManager();

    private LogManager(){
        loggerMap = new HashMap<>();
        startAsyncAppenderThread();
    }

    private void startAsyncAppenderThread(){
        asyncPeriodicAppender = new AsyncPeriodicAppender();
        Thread t = new Thread(asyncPeriodicAppender);
        t.setDaemon(true);
        t.start();
    }

    public static LogManager getLogManager(){
        return logManager;
    }

    public Logger getLogger(String name){
        return getLogger(name, false);
    }

    public Logger getLogger(String name, boolean isAsync){
        if(loggerMap.containsKey(name)){
            return loggerMap.get(name);
        }
        Logger logger;
        if(isAsync){
            logger = new ASyncLogger(name);
            asyncPeriodicAppender.registerAsyncLogger((AsyncAppender) logger);
        } else {
            logger =new SyncLogger(name);
        }
        loggerMap.put(name, logger);
        return logger;
    }

}
