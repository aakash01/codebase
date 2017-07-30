package com.aakash.practice.interviewbit_may2017.dynamic_programming;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/1/17.
 */
public class WaysToDecode {

    public int numDecodingsBackTrackign(String a) {
        if(a.length() != 0 && a.startsWith("0")){
            return 0;
        }
        if(a.length() <= 1){
            return 1;
        }
        int count = numDecodingsBackTrackign(a.substring(1));
        int n = Integer.parseInt(a.substring(0, 2));
        if(n>=1 && n<=26){
            count += numDecodingsBackTrackign(a.substring(2));
        }
        return count;
    }

    public int  numDecodings(String a){
        int[] dp = new int[a.length()+1];
        for(int i=0;i<a.length()+1;i++){
            dp[i] = -1;
        }
        return helper(a, 0, dp);
    }

    public int helper(String a, int i, int[] dp){
        if(a.length() != i && a.charAt(i) == '0'){
            return 0;
        }
        if(a.length() - i <= 1){
            return 1;
        }
        int count = 0;
        if(dp[i+1] == -1){
            dp[i+1] = helper(a, i+1, dp);
        }
        count +=dp[i+1];
        int n = Integer.parseInt(a.substring(i, i+2));
        if(n>=1 && n<=26){
            if(dp[i+2] == -1){
                dp[i+2] = helper(a, i+2, dp);
            }
            count += dp[i+2];
        }
        dp[i] = count;
        return count;
    }

    public static void main(String[] args) {
        WaysToDecode waysToDecode = new WaysToDecode();
        System.out.println(waysToDecode.numDecodings("121"));
    }


}
