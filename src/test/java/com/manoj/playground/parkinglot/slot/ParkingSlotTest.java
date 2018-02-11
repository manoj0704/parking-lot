package com.manoj.playground.parkinglot.slot;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParkingSlotTest {

   @Test
   void shouldBeAbleToCreateSlotsWithAnId() {
      ParkingSlot parkingSlot = new ParkingSlot("1");
      assertThat(parkingSlot.getSlotId()).isEqualTo("1");
   }
}