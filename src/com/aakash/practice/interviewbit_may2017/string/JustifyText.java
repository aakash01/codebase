package com.aakash.practice.interviewbit_may2017.string;

import com.aakash.practice.common.GoodQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 6/21/17.
 */
@GoodQuestion
public class JustifyText {

    public ArrayList<String> fullJustify(ArrayList<String> a, int b) {
        ArrayList<String> result = new ArrayList<String>();
        if(a.size() == 0){
            return result;
        }
        int start = 0, currLen = a.get(0).length();
        for(int i=1;i<a.size();i++){
            String s = a.get(i);
            int newLen = currLen + s.length() + 1;
            if(newLen == b){
                result.add(justify(a.subList(start, i+1), b, newLen));
                start = i+1;
                currLen = -1;
            } else if(newLen > b){
                result.add(justify(a.subList(start, i), b, currLen));
                start = i;
                currLen = s.length();
            } else {
                currLen = newLen;
            }
        }
        if(start < a.size()){
            // add string;
            StringBuilder sb = new StringBuilder(a.get(start));
            for(int i=start+1;i<a.size();i++){
                sb.append(" ");
                sb.append(a.get(i));
            }
            int reqSpace =b-sb.length();
            for(int i=1;i<=reqSpace;i++){
                sb.append(" ");
            }
            result.add(sb.toString());
        }

        return result;
    }

    private String justify(List<String> list, int total, int width){
        //remove space
        int size = list.size();
        width = width - (size-1);
        int reqSpace = total - width;
        int spaceWidth = (size == 1) ? reqSpace : (reqSpace / (size -1));
        int extraSpace = (size == 1) ? 0 : reqSpace % (size -1);
        StringBuilder sb = new StringBuilder(list.get(0));
        for(int i=1;i<size;i++){
            for(int j=0;j<spaceWidth;j++){
                sb.append(" ");
                reqSpace--;
            }
            if(extraSpace > 0){
                sb.append(" ");
                extraSpace--;
                reqSpace--;
            }
            sb.append(list.get(i));
        }
        for(int j=0;j<reqSpace;j++){
            sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        JustifyText justifyText = new JustifyText();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(new String[]{"am", "fasgoprn", "lvqsrjylg", "rzuslwan", "xlaui", "tnzegzuzn", "kuiwdc", "fofjkkkm", "ssqjig", "tcmejefj", "uixgzm", "lyuxeaxsg", "iqiyip", "msv", "uurcazjc", "earsrvrq", "qlq", "lxrtzkjpg", "jkxymjus", "mvornwza", "zty", "q", "nsecqphjy"}));
        System.out.println(justifyText.fullJustify(list, 14));
    }
}
