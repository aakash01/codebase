package com.aakash.practice.programcreek;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/15/17.
 */
public class ReconstructItinerary {

    HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    LinkedList<String> result = new LinkedList<String>();

    public List<String> findItinerary(String[][] tickets) {
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                PriorityQueue<String> q = new PriorityQueue<String>();
                map.put(ticket[0], q);
            }
            map.get(ticket[0]).offer(ticket[1]);
        }

        dfs("JFK");
        return result;
    }

    public void dfs(String s) {
        PriorityQueue<String> q = map.get(s);

        while (q != null && !q.isEmpty()) {
            dfs(q.poll());
        }

        result.addFirst(s);
    }

    protected static final String FETCH_SCHEDULER_STATUS_UPDATE_QUERY = new StringBuilder()
            .append("Update %s SET queued=%b, job_id='%s' WHERE retailer_id='%s' AND source_id=%d")
            .append(" ").toString();

    public static void main(String[] args) {
        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        String[][] tickets = new String[][]{{"JFK", "SCJ"},{"SCJ","JFK"},{"JFK","ALT"}};
        System.out.println(reconstructItinerary.findItinerary(tickets));
    }
}
