package com.roilen.code.easyjava;

public class DeadLock {
    public static final Object anvil = new Object();
    public static final Object bugle = new Object();

    public static void main(String[] args) {
        new PlayerOne().start();
        new PlayerTwo().start();
    }

    private static class PlayerOne extends Thread{
        @Override
        public void run() {
            synchronized (anvil) {
                System.out.println("Player One is using anvil!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Player One is waiting for bugle");

            }
            synchronized (bugle) {
                System.out.println("Player One is using bugle!");
            }
        }
    }

    private static class PlayerTwo extends Thread{
        @Override
        public void run() {
            synchronized (bugle) {
                System.out.println("Player Two is using bugle!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Player Two is waiting for anvil");
            }
            synchronized (anvil) {
                System.out.println("Player Two is using anvil!");
            }
        }
    }
}
