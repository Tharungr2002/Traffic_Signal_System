package Model;

import java.util.Map;

public class Intersection {
    private int id;
    private String name;
    private Direction isEmergency;
    private Map<Direction, TrafficLight> trafficLights;

    public Intersection(int id, String name) {
        this.id = id;
        this.name = name;
        for(Direction direction : Direction.values()) {
            this.trafficLights.put(direction, new TrafficLight(direction));
        }
        System.out.println("Intersection created " + id);
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
