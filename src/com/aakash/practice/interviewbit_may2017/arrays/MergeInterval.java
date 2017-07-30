package com.aakash.practice.interviewbit_may2017.arrays;

import java.util.ArrayList;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/22/17.
 */
public class MergeInterval {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<>();
        for(int i=0;i<intervals.size();i++){
            Interval currInterval = intervals.get(i);
            if(newInterval != null) {
                if (newInterval.start < currInterval.end) {
                    if (newInterval.start < currInterval.start) {
                        if (newInterval.end < currInterval.end) {
                            if(newInterval.end < currInterval.start){
                                result.add(newInterval);
                                result.add(currInterval);
                            } else {
                                result.add(new Interval(newInterval.start, currInterval.end));
                            }
                            newInterval = null;
                        } else {
                            continue;
                        }
                    } else {
                        if (newInterval.end < currInterval.end) {
                            result.add(currInterval);
                            newInterval = null;
                        } else {
                            newInterval = new Interval(currInterval.start, newInterval.end);
                        }
                    }
                } else {
                    if(currInterval.start > newInterval.end){
                        result.add(newInterval);
                        result.add(currInterval);
                        newInterval = null;
                    } else {
                        if(currInterval.end < newInterval.end){
                            result.add(currInterval);
                        } else {
                            newInterval = new Interval(newInterval.start, currInterval.end);
                        }
                    }
                }
            } else {
                result.add(currInterval);
            }
        }

        if(newInterval != null){
            result.add(newInterval);
        }

        return result;

    }

    public static void main(String[] args) {
        MergeInterval mergeInterval = new MergeInterval();
        Interval i1 = new Interval(3,4);
        Interval i2 = new Interval(5,7);
        Interval i3 = new Interval(10,15);
        Interval ni = new Interval(17,25);

        ArrayList<Interval> result = new ArrayList<>();
        result.add(i1);
        result.add(i2);
        result.add(i3);
        System.out.println(mergeInterval.insert(result, ni));

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
