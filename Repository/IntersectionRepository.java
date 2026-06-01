package Repository;

import Model.Intersection;
import Model.IntersectionCycle;

import java.util.Map;

public class IntersectionRepository {
    Map<Integer , Intersection> intersections;
    Map<Integer , IntersectionCycle> cycles;
    int nextId = 1;

    public boolean exist(int id) {
        return intersections.containsKey(id);
    }

    public void save(Intersection intersection) {
        intersections.put(intersection.getId(), intersection);
    }

    public void updateCycle(int id, IntersectionCycle intersectionCycle) {
        cycles.put(id, intersectionCycle);
    }

    public Intersection find(int id) {
        if(intersections.containsKey(id)) {
            return intersections.get(id);
        }
        return null;
    }

    public void update(Intersection intersection) {
        intersections.put(intersection.getId(), intersection);

    }

    public int getNextId() {
        return nextId++;
    }

    public IntersectionCycle findCycle(int id) {
        return cycles.get(id);
    }
}
