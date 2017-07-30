package com.aakash.practice.interviewbit_may2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/6/17.
 */
public class Test {

    public int getNumMeetingRooms(List<Interval> intervals){
        ArrayList<Interval> starts = new ArrayList<Interval>(intervals);
        ArrayList<Interval> ends = new ArrayList<Interval>(intervals);

        Collections.sort(starts, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        Collections.sort(ends, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.end - i2.end;
            }
        });
        int i=1, j=0;
        int count = 1, minCount = 1;
        int n = intervals.size();
        while(i<n && j<n){
            Interval start  = starts.get(i);
            Interval end = ends.get(j);
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
        String s = new StringBuilder()
                .append("SELECT distinct fs.retailer_id as retailer_id, fs.url as url, IFNULL(a.is_proper,0) as recrawl ")
                .append("FROM fetch_priority_schedule fs ")
                .append("LEFT JOIN amazon_proper_items a ")
                .append(" ON fs.retailer_id = a.retailer_id ")
                .append("INNER JOIN sources s ")
                .append(" ON fs.source_id = s.id ")
                .append("WHERE fs.next_fetch_time < CURRENT_TIMESTAMP ")
                .append(" AND fs.queued = 0 AND fs.source_id = 1 ")
                .append(" AND s.status='TRACKING' ")
                .append(" ORDER BY fs.next_fetch_time ASC")
                .append(" LIMIT 0,%d").toString();
        System.out.println(s);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 3));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(4, 7));
        System.out.println(new Test().getNumMeetingRooms(intervals));
    }


    private static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
