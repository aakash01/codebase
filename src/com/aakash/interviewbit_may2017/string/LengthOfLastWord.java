package com.aakash.interviewbit_may2017.string;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 5/25/17.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(final String a) {
        int i = a.length() - 1;
        int count = 0;
        boolean wordStarted = false;
        char[] carr = a.toCharArray();
        while(i >= 0){
            char ch = Character.toLowerCase(carr[i]);
            if(ch >= 'a' && ch <= 'z'){
                wordStarted = true;
                count++;
            }else {
                if(wordStarted){
                    break;
                }
            }
            i--;
        }
        return count;
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("aakash"));
    }
}
