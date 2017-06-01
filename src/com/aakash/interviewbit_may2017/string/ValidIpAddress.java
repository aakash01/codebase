package com.aakash.interviewbit_may2017.string;

import java.util.ArrayList;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/25/17.
 */
public class ValidIpAddress {

    public ArrayList<String> restoreIpAddresses(String a) {
        return helper(a, 4);
    }
//1.2.16.134 1.2.161.34 1.21.6.134 1.21.61.34 1.216.1.34 1.216.13.4 12.1.6.134 12.1.61.34 12.16.1.34 12.16.13.4 12.161.3.4 121.6.1.34 121.6.13.4 121.61.3.4
    private ArrayList<String> helper(String s, int subnet){
        if(s == null || s.length() > 3*subnet){
            return null;
        }
        ArrayList<String> list = new ArrayList<>();

        if(subnet == 1){
            int i = Integer.parseInt(s);
            if(i>255){
                return null;
            }
            if(s.startsWith("0") && s.length()>1){
                return null;
            }
            list.add(s);
            return list;
        } else {
            for(int i=1;i<=3  && i<s.length();i++){
                String sub = s.substring(0, i);

                int k = Integer.parseInt(sub);
                if(k > 255){
                    continue;
                }
                if(sub.startsWith("0") && sub.length()>1){
                    continue;
                }
                ArrayList<String> res  = helper(s.substring(i), subnet-1);
                if(res == null || res.size() ==0){
                    continue;
                }
                for(String st : res){
                    list.add(sub + "."+st);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ValidIpAddress validIpAddress=  new ValidIpAddress();
        System.out.println(validIpAddress.restoreIpAddresses("010010"));
    }
}
