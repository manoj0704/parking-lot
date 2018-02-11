package com.manoj.playground.parkinglot.slot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

class ParkingSlotTest {

   @Test
   void shouldBeAbleToCreateSlotsWithAnId() {
      ParkingSlot parkingSlot = new ParkingSlot("1");
      assertThat(parkingSlot.getSlotId()).isEqualTo("1");
   }

   @Test
   void shouldNotBeAbleToCreateASlotWithoutId() {
      assertThatThrownBy(() -> new ParkingSlot("  "))
         .isInstanceOf(IllegalArgumentException.class)
         .withFailMessage("Invalid input. Slot Id mandatory for creating a slot!");
   }
}