package com.aakash.practice.interviewbit_may2017.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/24/17.
 */
public class MergeOverlappingInterval {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                if(i1.start == i2.start){
                    return i1.end - i2.end;
                }
                return i1.start - i2.start;
            }
        });

        ArrayList<Interval> mergedInterval = new ArrayList<>();
        if(intervals.isEmpty()){
            return mergedInterval;
        }
        Interval interval = intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            Interval currInterval = intervals.get(i);
            if(currInterval.start <= interval.end){
                if(currInterval.end > interval.end){
                    interval.end = currInterval.end;
                }
            } else {
                mergedInterval.add(interval);
                interval = currInterval;
            }
        }
        mergedInterval.add(interval);
        return mergedInterval;

    }

    public static void main(String[] args) {
        MergeOverlappingInterval mergeOverlappingInterval = new MergeOverlappingInterval();
        Interval i1 = new Interval(3,4);
        Interval i2 = new Interval(1,17);
        Interval i3 = new Interval(17,20);

        ArrayList<Interval> result = new ArrayList<>();
        result.add(i1);
        result.add(i2);
        result.add(i3);
        System.out.println(mergeOverlappingInterval.merge(result));

    }

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "[ "+start +", "+end+" ]";
        }
    }
}
