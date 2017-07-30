package com.aakash.practice.personal;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/29/17.
 */
public class GreedyWater {

    public static void main(String[] args) {
        Scanner a  = new Scanner(System.in);
        int t = a.nextInt();
        while(t-- > 0){
            int n = a.nextInt();
            int x = a.nextInt();
            int[] capacity = new int[n];
            for(int i=0;i<n;i++){
                capacity[i] = a.nextInt();
            }
            Arrays.sort(capacity);
            int count = 0;
            for(int i=0;i<n;i++, count++){
                if(x < capacity[i]){
                    break;
                }
                x-= capacity[i];
            }
            System.out.println(count);
        }
    }
}
