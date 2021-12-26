package com.roilen.code.easyjava;

import java.util.Arrays;
import java.util.List;

public class Player implements Runnable {
    Message message;
    List<String> phrases = Arrays.asList("Hey", "For the alliance!", "Java is easy!", "Go away, scary monster!", "Don't worry, be happy");

    public Player(Message message) {
        this.message = message;
        new Thread(this, "Echo").start();
    }

    @Override
    public void run() {
        while (true) {
            Double random = Math.random() * phrases.size();
            message.say(phrases.get(random.intValue()));
        }
    }
}
