package Controller;

import Model.Direction;
import Model.Intersection;
import Service.EmergencyService;

public class EmergencyController {
    private EmergencyService emergencyService;

    public EmergencyController(EmergencyService emergencyService) {
        this.emergencyService = emergencyService;
    }

    public void RequestEmergency(int id, Direction direction , int duration) {
        emergencyService.RequestEmergency(id, duration, direction);
    }

}
