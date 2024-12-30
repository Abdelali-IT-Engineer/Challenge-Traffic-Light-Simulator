package com.example.demo;

import javafx.application.Platform;
import javafx.scene.layout.GridPane;

public class TrafficSimulator {
    private final GridPane layout;
    private final TrafficLight northLight;
    private final TrafficLight southLight;
    private final TrafficLight eastLight;
    private final TrafficLight westLight;
    private final TrafficController controller;

    public TrafficSimulator() {
        layout = new GridPane();

        // Initialize traffic lights for each direction
        northLight = new TrafficLight();
        southLight = new TrafficLight();
        eastLight = new TrafficLight();
        westLight = new TrafficLight();

        // Arrange traffic lights in a grid
        layout.add(northLight.getLightUI(), 1, 0); // North
        layout.add(southLight.getLightUI(), 1, 2); // South
        layout.add(eastLight.getLightUI(), 0, 1); // East
        layout.add(westLight.getLightUI(), 2, 1); // West

        // Initialize traffic controller
        controller = new TrafficController(northLight, southLight, eastLight, westLight);
    }

    public GridPane getLayout() {
        return layout;
    }

    public void startSimulation() {
        Platform.runLater(controller::startTrafficControl);
    }
}
