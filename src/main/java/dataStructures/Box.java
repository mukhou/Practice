/* 
User: Urmi
Date: 1/27/2020 
Time: 10:56 AM
*/

package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class Box {
    private double width;
    private double length;
    private double height;
    private static double DH;

    public Box(double width, double length, double height) {

        this.width = width;
        this.length = length;
        height = this.height;

    }

    private void swap(int x, int y){
        int temp = x;
        x = y;
        y = temp;
    }

    public Box(double width, double length) {
        this.width = width;
        this.length = length;
        this.height = DH;
    }
    public static void main(String[] args){
        Box b = new Box(5, 5, DH);
        int x = 24, y = 42;
        b.swap(x, y);
        System.out.println(x + " " + y);
    }
}
