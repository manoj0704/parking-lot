package com.manoj.playground.parkinglot.slot;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class ParkingSlot {
   private final String slotId;

   public ParkingSlot(String slotId) {
      if (isBlank(slotId)) {
         throw new IllegalArgumentException("Invalid input. Slot Id mandatory for creating a slot!");
      }
      this.slotId = slotId;
   }

   public String getSlotId() {
      return slotId;
   }
}
