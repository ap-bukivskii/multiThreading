package edu.tolik.MT;

import java.util.Date;

/**
 * Created by tolik_b on 1/10/15.
 */
public class Worker implements Runnable {

    @Override
    public void run() {
        while (true){
            try {Thread.sleep(1000);}
            catch (InterruptedException e){e.printStackTrace(); break;}
            System.out.println(new Date());
            if (Thread.currentThread().isInterrupted()){break;}
        }
    }
}
