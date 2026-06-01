package Model;

import Model.State.RedState;
import Model.State.TrafficLightState;

public class TrafficLight {
    private Direction direction;
    private TrafficLightState currentState;

    public TrafficLight(Direction direction) {
        this.direction = direction;
        this.currentState = new RedState();
    }

    public void turnRed() {
        currentState.turnRed(this);
    }

    public void turnYellow() {
        currentState.turnYellow(this);
    }

    public void turnGreen() {
        currentState.turnGreen(this);
    }

    public void turnOff() {
        currentState.turnOff(this);
    }

    public String getCurrentStateName() {
        return currentState.getCurrentState();
    }


    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setCurrentState(TrafficLightState currentState) {
        this.currentState = currentState;
    }


    public Direction getDirection() {
        return direction;
    }

    public TrafficLightState getCurrentState() {
        return currentState;
    }
}
