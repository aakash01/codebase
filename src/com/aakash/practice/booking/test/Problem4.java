package com.aakash.practice.booking.test;

import java.util.*;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/23/17.
 */
public class Problem4 {

    private static int getExecRequired(List<Call> calls){
        ArrayList<Call> starts = new ArrayList<Call>(calls);
        ArrayList<Call> ends = new ArrayList<Call>(calls);

        Collections.sort(starts, new Comparator<Call>(){
            public int compare(Call i1, Call i2){
                if(i1.start == i2.start){
                    return 0;
                } else if(i1.start < i2.start){
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        Collections.sort(ends, new Comparator<Call>(){
            public int compare(Call i1, Call i2){
                if(i1.end == i2.end){
                    return 0;
                } else if(i1.end < i2.end){
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        int i=1, j=0;
        int count = 1, minCount = 1;
        int n = calls.size();
        while(i<n && j<n){
            Call start  = starts.get(i);
            Call end = ends.get(j);
            if(start.start>end.end){
                count--;
                j++;
            } else {
                count++;
                i++;
            }
            if(count > minCount){
                minCount = count;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner a  = new Scanner(System.in);
        int numExec = a.nextInt();
        int n = a.nextInt();
        List<Call> calls = new ArrayList<>();
        for(int i=1;i<=n;i++){
            long start = a.nextLong();
            long end = a.nextLong();
            Call call = new Call(start, end);
            calls.add(call);
        }
        int execRequired = getExecRequired(calls);
        System.out.println(execRequired);
        if(execRequired > numExec){
            System.out.println(execRequired - numExec);
        } else {
            System.out.println(0);
        }
    }

    private static class Call {
        long start;
        long end;

        public Call(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
}
