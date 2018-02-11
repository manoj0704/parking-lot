package com.manoj.playground.parkinglot.slot;

import com.manoj.playground.parkinglot.car.Car;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class ParkingSlot {

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
}
