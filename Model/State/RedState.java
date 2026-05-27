package Model.State;

import Model.State.Exception.InvalidStateTransitionException;
import Model.TrafficLight;

public class RedState implements TrafficLightState{

    @Override
    public void turnGreen(TrafficLight trafficLight) {
        trafficLight.setCurrentState(new GreenState());
        System.out.println("Traffic Light" + trafficLight.getDirection() + "changed to Red -> Green");
    }

    @Override
    public void turnRed(TrafficLight trafficLight) {
        System.out.println("Already in Red");
    }

    @Override
    public void turnYellow(TrafficLight trafficLight) {
        throw new InvalidStateTransitionException("Error transforming Red-> Yellow");
    }

    @Override
    public void turnOff(TrafficLight trafficLight) {
        trafficLight.setCurrentState(new OffState());
        System.out.println("Traffic Light" + trafficLight.getDirection() + "changed to Red -> Off");
    }

    @Override
    public String getCurrentState() {
        return "RedState";
    }
}
