package Model.State;

import Model.TrafficLight;

public interface TrafficLightState {
    void turnGreen(TrafficLight trafficLight);
    void turnRed(TrafficLight trafficLight);
    void turnYellow(TrafficLight trafficLight);
    void turnOff(TrafficLight trafficLight);
    String getCurrentState();
}
