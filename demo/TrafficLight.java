package com.example.demo;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TrafficLight {
    private final Circle redLight;
    private final Circle yellowLight;
    private final Circle greenLight;

    public TrafficLight() {
        redLight = createLight(Color.RED);
        yellowLight = createLight(Color.YELLOW);
        greenLight = createLight(Color.GREEN);

        // Default state is RED
        setState(TrafficState.RED);
    }

    private Circle createLight(Color color) {
        Circle light = new Circle(20);
        light.setFill(Color.GRAY); // Default off
        return light;
    }

    public VBox getLightUI() {
        VBox layout = new VBox(10);
        layout.getChildren().addAll(redLight, yellowLight, greenLight);
        return layout;
    }

    public void setState(TrafficState state) {
        redLight.setFill(state == TrafficState.RED ? Color.RED : Color.GRAY);
        yellowLight.setFill(state == TrafficState.YELLOW ? Color.YELLOW : Color.GRAY);
        greenLight.setFill(state == TrafficState.GREEN ? Color.GREEN : Color.GRAY);
    }
}
