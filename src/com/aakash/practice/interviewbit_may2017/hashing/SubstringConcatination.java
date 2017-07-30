package com.aakash.practice.interviewbit_may2017.hashing;

import java.util.*;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/28/17.
 */
public class SubstringConcatination {

    public ArrayList<Integer> findSubstring(String a, final List<String> b) {
        ArrayList<Integer> result = new ArrayList<>();
        if(b.size() == 0){
            return result;
        }
        Map<String, Integer> map  =new HashMap<>();
        for(String s : b){
            if(map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        int l = b.get(0).length();
        int n = b.size();
        int N = a.length();
        for(int i=0;i<=N-n*l;i++){
            Map<String, Integer> currMap = new HashMap<>(map);
            boolean found = true;
            for(int j=1, k=i;j<=n;j++,k+=l){
                String s = a.substring(k, k+l);
                if(!currMap.containsKey(s) || currMap.get(s) == 0){
                    found = false;
                    break;
                }
                currMap.put(s, currMap.get(s) - 1);
            }
            if(found){
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SubstringConcatination substringConcatination = new SubstringConcatination();
        List<String> list = new ArrayList<>(Arrays.asList(new String[]{"foo", "bar"}));
        System.out.println(substringConcatination.findSubstring("abarfoobarfoobarman", list));
    }
}
