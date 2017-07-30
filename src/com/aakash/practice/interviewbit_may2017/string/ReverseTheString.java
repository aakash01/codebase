package com.aakash.practice.interviewbit_may2017.string;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/25/17.
 */
public class ReverseTheString {
    public String reverseWords(String a) {
        char[] cArr = a.toCharArray();
        reverseHelper(cArr, 0, cArr.length-1);

        boolean wordStarted = false;
        int wordStartIndex = -1, i=0;

        for(i=0;i<cArr.length;i++){
            if(cArr[i] == ' '){
                if(wordStarted){
                    reverseHelper(cArr, wordStartIndex, i-1);
                }
                wordStarted = false;
            } else {
                if(!wordStarted){
                    wordStartIndex = i;
                }
                wordStarted = true;
            }
        }
        if(wordStarted){
            reverseHelper(cArr, wordStartIndex, i-1);
        }

        // trim  the data
        boolean spaceAdded = true;
        i=0;
        int j=0;
        for(j=0; j<cArr.length;j++){
            if(cArr[j] == ' '){
                if(spaceAdded){
                    continue;
                }
                cArr[i++] = cArr[j];
                spaceAdded = true;
            } else {
                cArr[i++] = cArr[j];
                spaceAdded = false;
            }
        }
        if(spaceAdded){
            i--;
        }
        if(i == -1){
            return "";
        }
        return new String(cArr, 0, i);
    }

    private void reverseHelper(char[] cArr, int s, int e){
        while(s < e){
            char t = cArr[s];
            cArr[s] = cArr[e];
            cArr[e] = t;
            s++;
            e--;
        }
    }

    public static void main(String[] args) {
        ReverseTheString reverseTheString = new ReverseTheString();
        System.out.println(reverseTheString.reverseWords("  aakash  "));
    }
}
