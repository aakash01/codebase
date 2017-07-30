package com.aakash.practice.hackerrank.algorithms.search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by a0n007d on 19/03/17.
 */
public class KnightL {

    public static int move(int x, int y, int n){
        int[][] v=  new int[n][n];
        for(int i=0;i<n;i++){
            for(int j = 0;j<n; j++){
                v[i][j] = 0;
            }
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1, 1));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            int c = v[p.i-1][p.j-1];
            if(p.i == n && p.j == n){
                return c;
            }
            visit(queue, v, p.i+x, p.j+y, c, n);
            visit(queue, v, p.i-x, p.j+y, c, n);
            visit(queue, v, p.i+x, p.j-y, c, n);
            visit(queue, v, p.i-x, p.j-y, c, n);
            visit(queue, v, p.i+y, p.j+x, c, n);
            visit(queue, v, p.i+y, p.j-x, c, n);
            visit(queue, v, p.i-y, p.j+x, c, n);
            visit(queue, v, p.i-y, p.j-x, c, n);
        }
        return -1;

    }

    static void visit(Queue<Pair> queue, int[][] v, int i, int j, int c, int n){
        if(i > n || j> n || i <1 || j<1 || v[i-1][j-1]!= 0){
            return;
        }
        v[i-1][j-1] = c+1;
        queue.add(new Pair(i, j));

    }
    static class Pair {
        int i, j;
        public Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // your code goes here
        int[][] res = new int[n-1][n-1];
        for(int i=0;i<n-1;i++){
            for(int j = 0;j<n-1; j++){
                res[i][j] = -1;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=i;j<n;j++){
                int r = move(i, j, n);
                res[i-1][j-1] = r;
                res[j-1][i-1] = r;
            }
        }

        for(int[] row : res){
            for(int i: row){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
