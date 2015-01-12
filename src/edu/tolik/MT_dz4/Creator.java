package edu.tolik.MT_dz4;

import java.util.AbstractList;
import java.util.ArrayList;

/**
 * Created by tolik_b on 1/12/15.
 */
public class Creator implements Runnable {
    private int threadCount;
    private final Object stop = new Object();
    private final Object stopSelf;
    private ArrayList<Worker> workers = new ArrayList<>();
    public Creator(int threadCount,Object stop){this.threadCount = threadCount;this.stopSelf = stop;}
    @Override
    public void run() {
        System.out.println("Creator: Creating "+threadCount+" workers.");
        for (int i = 0; i < threadCount; i++) {
            Worker tmp = new Worker(stop);
            workers.add(tmp);
            workers.get(i).start();
        }
        while(!Thread.currentThread().isInterrupted()){
            synchronized (stopSelf){
                try {
                    stopSelf.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        this.interruptWorkers();
        for (Worker tmp:workers){
            try {
                tmp.join();
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }

    public void interruptWorkers(){
        System.out.println("Creator: Interrupting "+threadCount+" workers.");
        synchronized (stop) {
            stop.notifyAll();
        }
        for (Worker tmp:workers){tmp.interrupt();}
    }
}
