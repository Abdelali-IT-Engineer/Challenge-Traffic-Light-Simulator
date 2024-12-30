package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Initialize Traffic Simulator
        TrafficSimulator simulator = new TrafficSimulator();
        root.setCenter(simulator.getLayout());

        // Start simulation
        simulator.startSimulation();

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Four-Way Traffic Light Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
