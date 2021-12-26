package com.roilen.code.easyjava;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dispatcher {
    private final Set<Plane> planes;

    public Dispatcher() {
        this.planes = new HashSet<>();
    }

    public synchronized void requestLanding(Plane plane) {
        planes.add(plane);
    }

    public Map<Point, Plane> getMap() {
        System.out.println("Getting map");
        Map<Point, Plane> planeMap = new HashMap<>();
        for (Plane plane : planes) {
            planeMap.put(plane.getLocation(), plane);
        }
        return planeMap;
    }
}
