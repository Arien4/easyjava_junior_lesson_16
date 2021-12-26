package com.roilen.code.easyjava;

import java.awt.*;

public class Main3 {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();
        Plane plane = new Plane(new Point(2, 8), dispatcher);
        dispatcher.requestLanding(plane);
        new Thread(() -> {

            for (int i = 0; i < 10000; i++) {
                dispatcher.getMap();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                plane.setLocation(new Point(1, 1));
            }
        }).start();

    }


}
