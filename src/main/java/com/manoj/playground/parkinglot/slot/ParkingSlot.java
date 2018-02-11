package com.manoj.playground.parkinglot.slot;

import com.manoj.playground.parkinglot.car.Car;

import static java.lang.String.join;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class ParkingSlot implements Comparable<ParkingSlot> {

   private final String slotId;

   private Car car;

   public ParkingSlot(String slotId) {
      if (isBlank(slotId)) {
         throw new IllegalArgumentException("Invalid input. Slot Id mandatory for creating a slot!");
      }
      this.slotId = slotId;
   }

   public boolean isEmpty() {
      return this.car == null;
   }

   public String getSlotId() {
      return slotId;
   }

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }

      ParkingSlot that = (ParkingSlot) o;

      return slotId.equals(that.slotId);
   }

   @Override
   public int hashCode() {
      return slotId.hashCode();
   }

   @Override
   public int compareTo(ParkingSlot o) {
      return this.slotId.compareTo(o.getSlotId());
   }

   public String printParkingSlotInformation() {
      return join("\t", this.slotId, this.car.getRegNo(), this.car.getColor());
   }
}
