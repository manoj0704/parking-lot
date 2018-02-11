package com.manoj.playground.parkinglot.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

class CarTest {

   @Test
   void shouldBeAbleToCreateANewCar() {
      Car whiteCar = new Car("regNo", "white");
      assertThat(whiteCar.getRegNo()).isEqualTo("regNo");
      assertThat(whiteCar.getColor()).isEqualTo("white");
   }

   @Test
   void shouldFailIfTryingToCreateACarWithoutRegNumber() {
      assertThatThrownBy(() -> new Car(" ", "white"))
         .isInstanceOf(IllegalArgumentException.class)
         .withFailMessage("Invalid input. Registration number and color mandatory for a car!");
   }

   @Test
   void shouldFailIfTryingToCreateACarWithoutColor() {
      assertThatThrownBy(() -> new Car("regNumber", "  "))
         .isInstanceOf(IllegalArgumentException.class)
         .withFailMessage("Invalid input. Registration number and color mandatory for a car!");
   }
}