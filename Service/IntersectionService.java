package Service;

import Controller.IntersectionController;
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
}
