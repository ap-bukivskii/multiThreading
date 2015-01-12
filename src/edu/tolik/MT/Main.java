package edu.tolik.MT;

import java.util.Scanner;

/**
 * Created by tolik_b on 1/10/15.
 */
public class Main {
    public static void main(String[] args) {
        Worker w = new Worker();
        Thread t = new Thread(w);
        Scanner in = new Scanner(System.in);
        t.start();

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e){e.printStackTrace();}
//        int i=0;
//        while (i<10){
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e){e.printStackTrace(); break;}
//            System.out.println("Main: i = "+i++);
//            if (Thread.currentThread().isInterrupted()){break;}
//        }
        while(true){
            if(in.nextLine().equals("quit")){
                t.interrupt();
                break;
            }
        }
    }
}
