//Complete the following Java code that finds the total number of square numbers from a 100000 random integers array using an array of 20 threads in parallel. You cannot write any more classes.

import java.util.Random;
import java.util.zip.CheckedInputStream;

class ParallelSquareCounter implements Runnable {
    private int[] numbers;
    private int startIndex;
    private static final int NUMBER_COUNT = 5000;
    private int squareCount;
	// you are not allowed to add any more fields

	// you are not allowed to change this constructor, and you are not allowed to add any more constructor
    ParallelSquareCounter(int[] numbers, int startIndex) {
        this.numbers = numbers;
        this.startIndex = startIndex;
        this.squareCount = 0;
    }
	// your code here
    public void run(){
        boolean flag= true;
        for(int i=startIndex; i<startIndex+5000;i++){
            if(CheckPerfectSquare(numbers[i])==true){
                squareCount++;
            }
        }
    }

    public boolean CheckPerfectSquare(int n){
        double m = Math.sqrt(n);
        return ((m-Math.floor(m))==0);
    }

    public int getSquareCount(){
        return squareCount;
    }
    public void setSquareCount(int squareCount){
        this.squareCount=squareCount;
    }
}

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        final int NUMBER_COUNT = 100000;
        final int THREAD_COUNT = 20;
        int[] numbers = new int[NUMBER_COUNT];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt();
        }
        ParallelSquareCounter[] parallelSquareCounters = new ParallelSquareCounter[THREAD_COUNT];
        Thread[] threads = new Thread[THREAD_COUNT];
		// your code here

        int cnt = 0;
        for(int i=0;i<THREAD_COUNT;i++){
            parallelSquareCounters[i]= new ParallelSquareCounter(numbers, i*5000);
            threads[i]= new Thread(parallelSquareCounters[i]);
            threads[i].start();
        }
        for(int i=0;i<THREAD_COUNT;i++){
            cnt+=parallelSquareCounters[i].getSquareCount();
        }
        System.out.println("Total Count " + cnt);
    }
}