package Model;

public class IntersectionCycle {
    private int intersectionId;
    private int currentPhase;
    private boolean isPaused;
    private int pausedAtPhase;
    private long phaseStartTime;

    public IntersectionCycle(int intersectionId) {
        this.intersectionId = intersectionId;
        this.currentPhase = 0;
        this.isPaused = false;
        this.pausedAtPhase = 0;
        this.phaseStartTime = System.currentTimeMillis();
    }
}
