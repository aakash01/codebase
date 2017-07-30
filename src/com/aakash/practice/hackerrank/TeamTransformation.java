package com.aakash.practice.hackerrank;

import java.io.*;
import java.util.*;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/25/17.
 */
public class TeamTransformation {

    static long teamFormation(int[] score, int team, int m) {
        // use max heap to build group
        PriorityQueue<Integer> groupA = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> groupB = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0,j = score.length-1;
        for(int t=1;t<=m && i<score.length;t++,i++){
            groupA.add(score[i]);
        }
        for(int t=1;t<=m && j>i;t++,j--){
            groupB.add(score[j]);
        }

        int count = 0;
        for(int k=1;k<=team;k++){
            if(groupA.isEmpty()){
                count += groupB.poll();
            } else if(groupB.isEmpty()){
                count+= groupA.poll();
            } else {
                int a = groupA.peek();
                int b = groupB.peek();
                if (a >= b) {
                    count += a;
                    groupA.poll();
                    if (i <= j && i < score.length) {
                        groupA.add(score[i]);
                        i++;
                    }
                } else {
                    count += b;
                    groupB.poll();
                    if (j >= i) {
                        groupB.add(score[j]);
                        j--;
                    }
                }
            }
        }

        return count;
    }
    //8 18 5 15 18 11 15 9 7 5 1
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = "test.out";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        long res;

        int _score_size = 0;
        _score_size = Integer.parseInt(in.nextLine().trim());
        int[] _score = new int[_score_size];
        int _score_item;
        for(int _score_i = 0; _score_i < _score_size; _score_i++) {
            _score_item = Integer.parseInt(in.nextLine().trim());
            _score[_score_i] = _score_item;
        }

        int _team;
        _team = Integer.parseInt(in.nextLine().trim());

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        res = teamFormation(_score, _team, _m);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}
