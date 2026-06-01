package Model;

import Repository.EmergencyRepository;

public class EmergencyRequest {
    private int id;

    public int getIntersectionId() {
        return intersectionId;
    }

    public void setIntersectionId(int intersectionId) {
        this.intersectionId = intersectionId;
    }

    private int intersectionId;
    private int duration;
    private Direction direction;
    private boolean isActive;

    public EmergencyRequest(int id, int intersectionId, int duration, Direction direction) {
        this.id = id;
        this.intersectionId =intersectionId;
        this.duration = duration;
        this.direction = direction;
        this.isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


}
