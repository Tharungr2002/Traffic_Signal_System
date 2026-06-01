package Repository;

import Model.EmergencyRequest;

import java.util.Map;

public class EmergencyRepository {
    Map<Integer , EmergencyRequest> emergencyRequestMap;
    int nextId = 1;

    public void save(EmergencyRequest emergencyRequest) {
        emergencyRequestMap.put(emergencyRequest.getId() , emergencyRequest);
    }

    public int getNextId() {
        return nextId++;
    }
}
