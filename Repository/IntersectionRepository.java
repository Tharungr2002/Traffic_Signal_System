package Repository;

import Model.Intersection;
import Model.IntersectionCycle;

import java.util.Map;

public class IntersectionRepository {
    Map<Integer , Intersection> intersections;
    Map<Integer , IntersectionCycle> cycles;
    public boolean exist(int id) {
        return intersections.containsKey(id);
    }

    public void save(Intersection intersection) {
        intersections.put(intersection.getId(), intersection);
    }

    public void updateCycle(int id, IntersectionCycle intersectionCycle) {
        cycles.put(id, intersectionCycle);
    }
}
