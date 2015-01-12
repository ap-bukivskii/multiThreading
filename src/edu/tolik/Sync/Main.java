package edu.tolik.Sync;

/**
 * Created by tolik_b on 1/10/15.
 */
public class Main {
    private static class Container {
        public int x = 0, y = 0; // !!!
    }
    private static class TestThread extends Thread {
        Container c;
        public TestThread(Container c) {
            this.c = c;
        }
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
            //synchronized (c) { // !!!
                c.x++;
                c.y++;
            //}
        }
    }
    public static void main(String[] args) throws Exception {
        Container c = new Container();
        TestThread t;
        for (int i = 0; i < 1000; i++) {
            t = new TestThread(c);
            t.start();
        }
        Thread.sleep(1000);
        System.out.println(c.x + " , "  + c.y);
    }
}
