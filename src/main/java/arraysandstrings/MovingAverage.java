package com.jpmorgan.sample;

public class MovingAverage {

    private final double[] window; // use this data structure

    // you can add other fields here
    private int oldest = 0;

    /*
     * Always invoked with windowSize > 0
     */
    public MovingAverage(int windowSize) {
        window = new double[windowSize];
    }

    /*
     * Adds the number to window if it is larger than the value of 2.0d.
     * If window is full then replace the oldest added number in the window with the number provided.
     * [1 2 3 4 ]
     * [5 2 3 4]
     * [5 6 3 4]
     */
    public void addNumberToWindow(double number) {
        //check if valid number
        if(number > 2.0d) {
            //check if array is full -> if not try to add the number
            if(window[window.length - 1] == 0.0) {
                insertNum(number);
            } else {
              //replace the oldest added number in the window with the number provided
                replaceNum(number);
            }
        }
    }

    private void replaceNum(double number) {
        window[oldest ++] = number;
        if(oldest == window.length - 1) {
            oldest = 0;
        }
    }

    private void insertNum(double number) {
        for(int i = 0; i < window.length; i++) {
            if (window[i] == 0.0) {
                window[i] = number;
                break;
            }
        }
    }

    /*
     * Return the average of the numbers added that are currently present in the window.
     * Otherwise when no numbers in window return 0.0d
     */
    public double getAverage() {
        double sum = 0.0d;
        int blankVal = 0;
        for(int i = 0; i < window.length; i++) {
            if(window[i] == 0.0d) {
                blankVal ++;
            }
            sum += window[i];
        }
        if(sum == 0.0) {
            return 0.0d;
        } else {
            return sum/(window.length - blankVal);
        }

    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(4);
        movingAverage.addNumberToWindow(1.5d);
        movingAverage.addNumberToWindow(2.5d);
        System.out.println(movingAverage.getAverage()); // prints 2.5
        movingAverage.addNumberToWindow(3.0d);
        movingAverage.addNumberToWindow(3.5d);
        System.out.println(movingAverage.getAverage()); // prints 3.0
        movingAverage.addNumberToWindow(2.0d);
        System.out.println(movingAverage.getAverage()); // prints 3.0
        movingAverage.addNumberToWindow(7.0d);
        System.out.println(movingAverage.getAverage()); // prints 4.0
        movingAverage.addNumberToWindow(6.5d);
        System.out.println(movingAverage.getAverage()); // prints 5.0
    }
}
