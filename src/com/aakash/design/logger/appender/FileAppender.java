package com.aakash.design.logger.appender;

import com.aakash.design.logger.logger.LogRecord;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/20/17.
 */
public class FileAppender extends Appender{

    private String fileName;

    public FileAppender(String fileName){
        this.fileName = fileName;
    }


    @Override
    public void doAppendLog(LogRecord logRecord) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))){
            bw.write(getFormatter().format(logRecord));
            bw.write("\n");
        } catch (IOException io){
            io.printStackTrace();
        }
    }
}
