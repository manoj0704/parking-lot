package com.manoj.playground.parkinglot.store;

import com.manoj.playground.parkinglot.car.Car;
import com.manoj.playground.parkinglot.slot.ParkingSlot;

import java.util.HashMap;
import java.util.Map;

public final class ParkingLotRepository {

   private static final ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

   private final Map<ParkingSlot, Car> parkingSlotCarMap = new HashMap<>();

   private ParkingLotRepository() {
   }

   public static ParkingLotRepository getParkingLotRepository() {
      return parkingLotRepository;
   }

   public Map<ParkingSlot, Car> getParkingSlotCarMap() {
      return parkingSlotCarMap;
   }
}
