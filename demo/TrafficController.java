package com.example.demo;

public class TrafficController {
    private final TrafficLight northLight;
    private final TrafficLight southLight;
    private final TrafficLight eastLight;
    private final TrafficLight westLight;

    public TrafficController(TrafficLight north, TrafficLight south, TrafficLight east, TrafficLight west) {
        this.northLight = north;
        this.southLight = south;
        this.eastLight = east;
        this.westLight = west;
    }

    public void startTrafficControl() {
        Thread controllerThread = new Thread(() -> {
            while (true) {
                try {
                    // Step 1: North-South Green, East-West Red
                    setLights(northLight, southLight, TrafficState.GREEN);
                    setLights(eastLight, westLight, TrafficState.RED);
                    Thread.sleep(5000);

                    // Step 2: North-South Yellow
                    setLights(northLight, southLight, TrafficState.YELLOW);
                    Thread.sleep(2000);

                    // Step 3: All Red
                    setLights(northLight, southLight, TrafficState.RED);
                    Thread.sleep(1000);

                    // Step 4: East-West Green, North-South Red
                    setLights(eastLight, westLight, TrafficState.GREEN);
                    setLights(northLight, southLight, TrafficState.RED);
                    Thread.sleep(5000);

                    // Step 5: East-West Yellow
                    setLights(eastLight, westLight, TrafficState.YELLOW);
                    Thread.sleep(2000);

                    // Step 6: All Red
                    setLights(eastLight, westLight, TrafficState.RED);
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        controllerThread.setDaemon(true);
        controllerThread.start();
    }

    private void setLights(TrafficLight light1, TrafficLight light2, TrafficState state) {
        light1.setState(state);
        light2.setState(state);
    }
}
