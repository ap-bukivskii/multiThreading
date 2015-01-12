package edu.tolik.MT_dz4;

/**
 * Created by tolik_b on 1/12/15.
 */
public class Worker extends Thread{
    private final Object stop;
    public Worker(Object stop){
        this.stop = stop;
    }
    @Override
    public void run() {
        System.out.println("Worker: " + Thread.currentThread().getId() + " started. Waiting for interruption.");
        while(true){//!Thread.currentThread().isInterrupted()){
            synchronized (stop){
                try {
                    stop.wait();break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println ("Worker: "+Thread.currentThread().getId()+" interrupted.");
    }
}
