package Model;

public class SignalTiming {
    private int intersectionId;
    private Direction direction;
    private int greenDuration;

    public SignalTiming(int intersectionId, Direction direction) {
        this.intersectionId = intersectionId;
        this.direction = direction;
        this.greenDuration = 45;
    }

    public int getIntersectionId() {
        return intersectionId;
    }

    public void setIntersectionId(int intersectionId) {
        this.intersectionId = intersectionId;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getGreenDuration() {
        return greenDuration;
    }

    public void setGreenDuration(int greenDuration) {
        this.greenDuration = greenDuration;
    }
}
