package Model.State;

import Model.State.Exception.InvalidStateTransitionException;
import Model.TrafficLight;

public class YellowState implements TrafficLightState{
    @Override
    public void turnGreen(TrafficLight trafficLight) {
        throw new InvalidStateTransitionException("Error transforming YellowState->green");
    }

    @Override
    public void turnRed(TrafficLight trafficLight) {
        trafficLight.setCurrentState(new RedState());
        System.out.println("Traffic Light" + trafficLight.getDirection() + "changed to YellowState -> Red");
    }

    @Override
    public void turnYellow(TrafficLight trafficLight) {
        System.out.println("Already in yellow");
    }

    @Override
    public void turnOff(TrafficLight trafficLight) {
        trafficLight.setCurrentState(new OffState());
        System.out.println("Traffic Light" + trafficLight.getDirection() + "changed to Yellow -> Off");
    }

    @Override
    public String getCurrentState() {
        return "YellowState";
    }

}
