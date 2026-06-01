package Service;

import Model.Direction;
import Model.EmergencyRequest;
import Model.Intersection;
import Repository.EmergencyRepository;
import Repository.IntersectionRepository;

import java.util.UUID;

public class EmergencyService {
    private EmergencyRepository emergencyRepository;
    private IntersectionRepository intersectionRepository;

    public EmergencyService(EmergencyRepository emergencyRepository,
                            IntersectionRepository intersectionRepository) {
        this.emergencyRepository = emergencyRepository;
        this.intersectionRepository = intersectionRepository;
    }

    public void RequestEmergency(int id, int duration, Direction direction) {
        Intersection intersection = intersectionRepository.find(id);
        if(intersection == null) {
            System.out.println("intersection did not found");
            return;
        }
        int reqId = emergencyRepository.getNextId();
        EmergencyRequest emergencyRequest = new EmergencyRequest(reqId,id,duration,direction);
        emergencyRepository.save(emergencyRequest);

        //pause cycle

        //set all dir red

        //set emergency direction green



    }

    public void EndEmergency(int id) {
        //get emergency id

        //set all sig to red

        //deactivate emer req

        //resume cycle




    }


}
