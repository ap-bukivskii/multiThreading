package edu.tolik.account;

/**
 * Created by tolik_b on 1/10/15.
 */

public class Action extends Thread {

    Account acc;
    int withdraw;

    public Action(Account acc, int withdraw) {
        this.acc = acc;
        this.withdraw = withdraw;
    }

    public void run() {
        synchronized (acc) {
            int has = acc.get();
            if (has >= withdraw) {
                acc.set(acc.get() - withdraw);
            }
        }
    }
}