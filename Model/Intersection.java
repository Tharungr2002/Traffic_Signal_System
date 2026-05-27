package Model;

import java.util.Map;

public class Intersection {
    private int id;
    private String name;
    private Direction isEmergency;
    private Map<Direction, TrafficLight> trafficLights;
}
