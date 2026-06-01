package Model;

import java.util.Map;

public class Intersection {
    private int id;
    private String name;
    private Direction emergencyDirection;
    private Map<Direction, TrafficLight> trafficLights;
    private boolean isEmergencyMode;
    private boolean isPaused;

    public Intersection(int id, String name) {
        this.id = id;
        this.name = name;
        for(Direction direction : Direction.values()) {
            this.trafficLights.put(direction, new TrafficLight(direction));
        }
        System.out.println("Intersection created " + id);
        this.isEmergencyMode = false;
        this.isPaused = false;
    }

    public boolean isEmergencyMode() {
        return isEmergencyMode;
    }

    public void setEmergencyMode(boolean emergencyMode) {
        isEmergencyMode = emergencyMode;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
