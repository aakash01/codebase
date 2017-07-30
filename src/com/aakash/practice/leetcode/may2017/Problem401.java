package com.aakash.practice.leetcode.may2017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/10/17.
 */
public class Problem401 {

    public List<String> readBinaryWatch(int n){
        int min = Math.max(n-6, 0);
        int max = Math.min(n, 4);
        List<String> result = new ArrayList<>();
        for(int i=min;i<=max;i++){
            List<Integer> hours = new ArrayList<>();
            List<Integer> minutes = new ArrayList<>();
            getCombination(4, i, 0, 11, hours);
            getCombination(6, n-i, 0, 59, minutes);
            for(Integer h : hours){
                for(Integer m : minutes){
                    String time = String.format("%d:%02d", h, m);
                    result.add(time);
                }
            }
        }
        return result;
    }

    private void getCombination(int n, int b, int v, int maxVal, List<Integer> result){
        if(b == 0){
            result.add(v);
            return;
        }
        if(n == b){
            int newVal =(int) (v + Math.pow(2, n-1));
            if(newVal <= maxVal) {
                getCombination(n - 1, b - 1, newVal, maxVal, result);
            }
        } else {
            //include
            int newVal =(int) (v + Math.pow(2, n-1));
            if(newVal <= maxVal) {
                getCombination(n - 1, b - 1, newVal, maxVal, result);
            }
            //exclude
            getCombination(n-1, b, v, maxVal, result);
        }
    }

    public List<String> readBinaryWatch2(int num) {
        List<String> res = new ArrayList<>();
        int[] nums1 = new int[]{1,2,4,8}, nums2 = new int[]{1,2,4,8,16,32};
        for(int i = 0; i <= num; i++) {
            List<Integer> list1 = generateDigit(nums1, i);
            List<Integer> list2 = generateDigit(nums2, num - i);
            for(int num1: list1) {
                if(num1 >= 12) continue;
                for(int num2: list2) {
                    if(num2 >= 60) continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
        }
        return res;
    }

    private List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        generateDigitHelper(nums, count, 0, 0, res);
        return res;
    }

    private void generateDigitHelper(int[] nums, int count, int weight, int sum, List<Integer> res) {
        if(count == 0) {
            res.add(sum);
            return;
        }

        for(int i = weight; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);
        }
    }

    public static void main(String[] args) {
        System.out.println(Math.ceil(2));
        System.out.println(1/2);
        String[] s2 = {"0:15","0:23","0:27","0:29","0:30","0:39","0:43","0:45","0:46","0:51","0:53","0:54","0:57","0:58","1:07","1:11","1:13","1:14","1:19","1:21","1:22","1:25","1:26","1:28","1:35","1:37","1:38","1:41","1:42","1:44","1:49","1:50","1:52","1:56","2:07","2:11","2:13","2:14","2:19","2:21","2:22","2:25","2:26","2:28","2:35","2:37","2:38","2:41","2:42","2:44","2:49","2:50","2:52","2:56","3:03","3:05","3:06","3:09","3:10","3:12","3:17","3:18","3:20","3:24","3:33","3:34","3:36","3:40","3:48","4:07","4:11","4:13","4:14","4:19","4:21","4:22","4:25","4:26","4:28","4:35","4:37","4:38","4:41","4:42","4:44","4:49","4:50","4:52","4:56","5:03","5:05","5:06","5:09","5:10","5:12","5:17","5:18","5:20","5:24","5:33","5:34","5:36","5:40","5:48","6:03","6:05","6:06","6:09","6:10","6:12","6:17","6:18","6:20","6:24","6:33","6:34","6:36","6:40","6:48","7:01","7:02","7:04","7:08","7:16","7:32","8:07","8:11","8:13","8:14","8:19","8:21","8:22","8:25","8:26","8:28","8:35","8:37","8:38","8:41","8:42","8:44","8:49","8:50","8:52","8:56","9:03","9:05","9:06","9:09","9:10","9:12","9:17","9:18","9:20","9:24","9:33","9:34","9:36","9:40","9:48","10:03","10:05","10:06","10:09","10:10","10:12","10:17","10:18","10:20","10:24","10:33","10:34","10:36","10:40","10:48","11:01","11:02","11:04","11:08","11:16","11:32"};
        Problem401 problem401= new Problem401();
        List<String> s1 = problem401.readBinaryWatch2(5);
        List<String> s3 = problem401.readBinaryWatch(6);
       Arrays.sort(s2);
        System.out.println(Arrays.toString(s2));
        Collections.sort(s1);
        System.out.println(s1);
        Collections.sort(s3);
        System.out.println(s3);
    }
}
