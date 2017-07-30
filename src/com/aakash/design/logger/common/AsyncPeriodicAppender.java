package com.aakash.design.logger.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/20/17.
 */
public class AsyncPeriodicAppender implements Runnable{

    private static final int SLEEP_TIME = 60000; // 1 minute

    private List<AsyncAppender> asyncLoggers = new ArrayList<>();

    @Override
    public void run() {
        while(true){
            try {
                for (AsyncAppender logger : asyncLoggers) {
                    logger.flush();
                }
                Thread.sleep(SLEEP_TIME);
            }catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }

    public void registerAsyncLogger(AsyncAppender asyncAppender){
        asyncLoggers.add(asyncAppender);
    }
}
