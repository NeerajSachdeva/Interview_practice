package scenario;

import java.util.*;

public class ParkingLotApp {

    public static void main(String[] args) {

        ParkingLot lot = new ParkingLot(3);

        int s1 = lot.park("CAR1");
        int s2 = lot.park("CAR2");

        System.out.println("CAR1 parked at "+s1);
        System.out.println("CAR2 parked at "+s2);

        lot.leave("CAR1");

        int s3 = lot.park("CAR3");
        System.out.println("CAR3 parked at "+s3);
    }
}

class ParkingLot {

    private PriorityQueue<Integer> freeSlots;
    private Map<String,Integer> parked = new HashMap<>();

    public ParkingLot(int capacity) {

        freeSlots = new PriorityQueue<>();

        for(int i=1;i<=capacity;i++)
            freeSlots.offer(i);
    }

    public int park(String vehicleId) {

        if(freeSlots.isEmpty())
            return -1;

        int slot = freeSlots.poll();
        parked.put(vehicleId,slot);
        return slot;
    }

    public void leave(String vehicleId) {

        if(!parked.containsKey(vehicleId))
            return;

        int slot = parked.remove(vehicleId);
        freeSlots.offer(slot);
    }
}