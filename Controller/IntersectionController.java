package Controller;

import Service.IntersectionService;

public class IntersectionController {
    private IntersectionService intersectionService;

    public IntersectionController(IntersectionService intersectionService) {
        this.intersectionService = intersectionService;
    }

    public void createIntersection(int id, String name) {
        intersectionService.createIntersection(id, name);
    }
}
