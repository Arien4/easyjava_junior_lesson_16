package com.roilen.code.easyjava;

public class Main2 {
    public static void main(String[] args) {
        Message message = new Message("Hey", false);
        new Echo(message);
        new Player(message);
    }
}
