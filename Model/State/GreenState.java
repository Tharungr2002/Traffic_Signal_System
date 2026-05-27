package Model.State;

import Model.State.Exception.InvalidStateTransitionException;
import Model.TrafficLight;

public class GreenState implements TrafficLightState{
    @Override
    public void turnGreen(TrafficLight trafficLight) {
        System.out.println("Already in Green");
    }

    @Override
    public void turnRed(TrafficLight trafficLight) {
        throw new InvalidStateTransitionException("Invalid GREEN -> RED");
    }

    @Override
    public void turnYellow(TrafficLight trafficLight) {
        trafficLight.setCurrentState(new YellowState());
        System.out.println("Traffic light " + trafficLight.getDirection() + " changed from GREEN to YELLOW");
    }

    @Override
    public void turnOff(TrafficLight trafficLight) {
        trafficLight.setCurrentState(new OffState());
        System.out.println("Traffic Light" + trafficLight.getDirection() + "changed to Yellow -> Off");
    }

    @Override
    public String getCurrentState() {
        return "GreenState";
    }
}
