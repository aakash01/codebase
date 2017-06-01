package com.aakash.hackerrank.algorithms.search;

import java.util.*;

/**
 * Created by a0n007d on 19/03/17.
 */
public class IcecreamParlour {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner a = new Scanner(System.in);
        int t= a.nextInt();

        while(t>0){
            int m = a.nextInt();
            int n = a.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            int[] costs = new int[n];
            for(int i=0;i<n;i++){
                costs[i] = a.nextInt();
            }
            for(int i=1;i<=n;i++){
                if(map.containsKey(m - costs[i-1])){
                    System.out.println(map.get(m - costs[i-1])+" "+i);
                    break;
                }else{
                    map.put(costs[i-1], i);
                }
            }
            t--;
        }


    }
}
