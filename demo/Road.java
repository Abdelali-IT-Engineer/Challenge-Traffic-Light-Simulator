package com.example.demo;

import javafx.scene.layout.VBox;

public class Road {
    private final TrafficLight incomingLight;
    private final TrafficLight outgoingLight;

    public Road() {
        incomingLight = new TrafficLight();
        outgoingLight = new TrafficLight();
    }

    public TrafficLight getIncomingLight() {
        return incomingLight;
    }

    public TrafficLight getOutgoingLight() {
        return outgoingLight;
    }

    public VBox getRoadUI() {
        VBox roadLayout = new VBox(10);
        roadLayout.getChildren().addAll(incomingLight.getLightUI(), outgoingLight.getLightUI());
        return roadLayout;
    }
}

