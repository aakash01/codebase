package com.aakash.practice.personal.concurrency;

import java.io.*;
import java.util.concurrent.Callable;

/**
 * Created by a0n007d on 28/02/17.
 */
public class Adder implements Callable<Integer>{

    private String infile;

    public Adder(String infile){
        this.infile = infile;
    }

    public Integer call() throws IOException{
        return doAdd();
    }

    int doAdd() throws IOException{
        int total = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(infile))){
            String readline = null;
            while((readline = reader.readLine()) != null){
                total += Integer.parseInt(readline);
            }
        }

        return total;
    }
}
