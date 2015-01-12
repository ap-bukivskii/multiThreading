package edu.tolik.MT2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tolik_b on 1/10/15.
 */
public class Main {
    public static final Object stop = new Object();
    public static void main(String[] args) {
        ArrayList <Thread> threads = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            Thread tmp = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread: " + Thread.currentThread().getId() + " started. Waiting for interruption.");
                    while(!Thread.currentThread().isInterrupted()){
                        synchronized (stop){
                            try {
                                stop.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    System.out.println ("Thread: "+Thread.currentThread().getId()+" interrupted.");
                }
            });
            threads.add(tmp);
            threads.get(i).start();
        }

        //TODO really wait for all of the threads to start
        System.out.println("\nAll threads started.\nTo interrupt all of the threads press \"enter\"");

        while (true){
            if (in.nextLine().equals("")){
                for (Thread tmp : threads) {
                    tmp.interrupt();
                    synchronized (stop) {
                        stop.notifyAll();
                    }
                    try {
                        tmp.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
        }
        System.out.println("\nAll done!");
    }
}
