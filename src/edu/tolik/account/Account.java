package edu.tolik.account;

/**
 * Created by tolik_b on 1/10/15.
 */

public class Account {

    int money;

    public Account(int money) {
        this.money = money;
    }

    public int get() {
        return money;
    }

    public void set(int x) {
        money = x;
    }
}