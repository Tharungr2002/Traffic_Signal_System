package Model.State;

import Model.TrafficLight;

public class OffState implements TrafficLightState{
    @Override
    public void turnGreen(TrafficLight trafficLight) {
        trafficLight.setCurrentState(new GreenState());
        System.out.println("Traffic light " + trafficLight.getDirection() + " changed from OFF to GREEN");
    }

    @Override
    public void turnYellow(TrafficLight trafficLight) {
        trafficLight.setCurrentState(new YellowState());
        System.out.println("Traffic light " + trafficLight.getDirection() + " changed from OFF to YELLOW");
    }

    @Override
    public void turnRed(TrafficLight trafficLight) {
        trafficLight.setCurrentState(new RedState());
        System.out.println("Traffic light " + trafficLight.getDirection() + " changed from OFF to RED");
    }

    @Override
    public void turnOff(TrafficLight trafficLight) {
        System.out.println("Traffic light " + trafficLight.getDirection() + " is already OFF");
    }

    @Override
    public String getCurrentState() {
        return "OffState";
    }

}
