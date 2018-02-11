package com.manoj.playground.parkinglot.store;

import com.manoj.playground.parkinglot.car.Car;
import com.manoj.playground.parkinglot.exception.CarNotFoundException;
import com.manoj.playground.parkinglot.exception.ParkingLotFullException;
import com.manoj.playground.parkinglot.exception.SlotNotFoundException;
import com.manoj.playground.parkinglot.slot.ParkingSlot;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.String.valueOf;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public final class ParkingLotRepository {

   private static final ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

   private final Set<ParkingSlot> parkingSlots = new TreeSet<>();

   private ParkingLotRepository() {
   }

   public static ParkingLotRepository getParkingLotRepository() {
      return parkingLotRepository;
   }

   public void createSlots(Integer slots) {
      rangeClosed(1, slots)
         .forEach(value -> parkingSlots.add(new ParkingSlot(valueOf(value))));
   }

   public ParkingSlot parkCar(Car car) {
      ParkingSlot parkingSlot = getNearestParkingSlot();
      parkingSlot.setCar(car);
      return parkingSlot;
   }

   public void unparkCar(String inputSlot) {
      final ParkingSlot parkingSlot = parkingSlots.stream()
         .filter(ps -> !ps.isEmpty())
         .filter(ps -> ps.getSlotId().equals(inputSlot))
         .findFirst()
         .orElseThrow(SlotNotFoundException::new);

      parkingSlot.setCar(null);
   }

   public List<Car> findCarsByColor(String color) {
      return parkingSlots.stream()
         .filter(parkingSlot -> !parkingSlot.isEmpty())
         .filter(parkingSlot -> parkingSlot.getCar().getColor().equals(color))
         .map(ParkingSlot::getCar)
         .collect(toList());
   }

   public List<ParkingSlot> findSlotsByColor(String color) {
      return parkingSlots.stream()
         .filter(parkingSlot -> !parkingSlot.isEmpty())
         .filter(parkingSlot -> parkingSlot.getCar().getColor().equals(color))
         .collect(toList());
   }

   public ParkingSlot findSlotForCar(String regNumber) {
      return parkingSlots.stream()
         .filter(parkingSlot -> !parkingSlot.isEmpty())
         .filter(parkingSlot -> parkingSlot.getCar().getRegNo().equals(regNumber))
         .findFirst()
         .orElseThrow(CarNotFoundException::new);
   }

   public Set<ParkingSlot> getParkingSlots() {
      return parkingSlots;
   }

   private ParkingSlot getNearestParkingSlot() {
      return parkingSlots.stream()
         .filter(ParkingSlot::isEmpty)
         .findFirst()
         .orElseThrow(ParkingLotFullException::new);
   }

   public List<ParkingSlot> getAllParkedSlots() {
      return parkingSlots.stream()
         .filter(parkingSlot -> !parkingSlot.isEmpty())
         .collect(toList());
   }
}
