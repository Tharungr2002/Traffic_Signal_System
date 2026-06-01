package Service;

import Controller.IntersectionController;
import Model.Direction;
import Model.Intersection;
import Model.IntersectionCycle;
import Repository.IntersectionRepository;
import Repository.SignalTimingRepository;

public class IntersectionService {
    private IntersectionRepository intersectionRepository;
    private SignalTimingRepository signalTimingRepository;

    public IntersectionService(IntersectionRepository intersectionRepository) {
        this.intersectionRepository = intersectionRepository;
    }

    public void createIntersection(int id, String name) {
        if(intersectionRepository.exist(id)) {
            System.out.println("Intersection id already available");
            return;
        }

        Intersection intersection = new Intersection(id, name);
        intersectionRepository.save(intersection);

        signalTimingRepository.initiateDefaultTiming(id);

        IntersectionCycle intersectionCycle = new IntersectionCycle(id);
        intersectionRepository.updateCycle(id, intersectionCycle);

        System.out.println("Automatic cycle starts for id :" + id);
    }

    public void pauseCycle(int id, int duration, Direction direction,Intersection intersection) {
        IntersectionCycle cycle = intersectionRepository.findCycle(id);
        if(cycle == null) {
            System.out.println("cycle not present");
            return;
        }

        cycle.setPaused(true);
        intersection.setPaused(true);

    }

    public void setAllSignalToRed(Intersection intersection) {
        for(Direction direction : Direction.values()) {
            intersection.turnToRed(direction);
        }
    }


    public void setGreen(Intersection intersection, Direction direction) {
        intersection.setGreen(direction);
    }
}
