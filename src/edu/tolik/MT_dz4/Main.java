package edu.tolik.MT_dz4;

import java.util.Scanner;

/**
 * Created by tolik_b on 1/12/15.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Object stopper  = new Object();
        Scanner in = new Scanner(System.in);
        Creator creator = new Creator(5,stopper);
        Thread  starter = new Thread(creator);
        starter.start();

        while (true){
            if (in.nextLine().equals("")){
                starter.interrupt();
                synchronized (stopper) {
                    stopper.notifyAll();
                }
                try {
                    starter.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }

        }
        System.out.println("\nAll done!");
    }
}
//TODO спитати, як нормально чекати інтерапта
//TODO спитати чи нормально чекати на нефінальному об’єкті