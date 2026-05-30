package Repository;

import Model.Direction;
import Model.SignalTiming;

import java.util.Map;

public class SignalTimingRepository {
    Map<Integer, SignalTiming> timingMap;


    public void initiateDefaultTiming(int id) {
        for(Direction directions : Direction.values()) {
            SignalTiming signalTiming = new SignalTiming(id, directions);
            timingMap.put(id, signalTiming);
        }
        System.out.println("Default green intialized");
    }
}
