package com.aakash.practice.booking.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/23/17.
 */
public class Problem3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while((line = br.readLine()) != null){
            String[] input = line.split(" ");
            int a[] = new int[input.length];
            for(int i=0;i<input.length;i++){
                a[i] = Integer.parseInt(input[i]);
            }

            int seq = a[0];
            for(int i=0;i<a.length;i++){
                if(i > 0){
                    seq = a[i] - a[i-1];
                }
                System.out.print(seq + " ");
                if(seq >= -127 || seq <= 127){
                    System.out.print(-128+" ");
                }
            }
        }
    }
}
