package com.aakash.practice.booking.test;

import java.util.Scanner;

/**
 * Created by Aakash(anagar@walmartlabs.com) on 7/23/17.
 */
public class Polygons {

    enum Shape{
        Square, Rectangle, Other
    }

    private static Shape checkShape(int a, int b, int c, int d){
        if(a<=0 || b <=0 || c<= 0 || d<=0){
            return Shape.Other;
        }else if(a == b && b == c && c == d){
            return Shape.Square;
        } else if (a == c && b == d){
            return Shape.Rectangle;
        }
        return Shape.Other;
    }

    public static void main(String[] args) {
        Scanner a  = new Scanner(System.in);
        String line;
        int square = 0, rectangle = 0, other = 0;
        while((line = a.nextLine()) != null && !"".equals(line)){
            String[] s = line.split(" ");
            Shape shape = checkShape(Integer.parseInt(s[0]), Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]));
            switch (shape){
                case Other:
                    other++;
                    break;
                case Square:
                    square++;
                    break;
                case Rectangle:
                    rectangle++;
                    break;
            }
        }
        System.out.print(square+" "+rectangle+" "+other);
    }
}
