package com.roilen.code.easyjava;

import java.awt.*;

public class Plane {
    private Point location, destination;
    private final Dispatcher dispatcher;

    public Plane(Point destination, Dispatcher dispatcher) {
        this.destination = destination;
        this.dispatcher = dispatcher;
    }

    public Point getLocation() {
        System.out.println("Getting location");
        return this.location;
    }

    public synchronized void setLocation(Point location) {
        System.out.println("Setting location: " + location.x + " " + location.y);
        this.location = location;
        if (location == destination) dispatcher.requestLanding(this);
    }

    public Point getDestination() {
        return destination;
    }

    public void setDestination(Point destination) {
        this.destination = destination;
    }
}
