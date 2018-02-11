package com.manoj.playground.parkinglot.slot;

import com.manoj.playground.parkinglot.car.Car;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
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

   @Test
   void addACarToAParkingSlot() {
      Car redCar = new Car("regNumber", "red");
      ParkingSlot parkingSlot = new ParkingSlot("1");
      parkingSlot.setCar(redCar);
      assertThat(parkingSlot.getCar()).isEqualTo(redCar);
      assertThat(parkingSlot.isEmpty()).isEqualTo(FALSE);
   }

   @Test
   void shouldBeAbleToCheckIfSlotIsEmpty() {
      ParkingSlot parkingSlot = new ParkingSlot("2");
      assertThat(parkingSlot.isEmpty()).isEqualTo(TRUE);
   }
}