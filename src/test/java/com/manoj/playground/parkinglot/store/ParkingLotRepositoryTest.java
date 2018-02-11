package com.manoj.playground.parkinglot.store;

import com.manoj.playground.parkinglot.car.Car;
import com.manoj.playground.parkinglot.exception.CarNotFoundException;
import com.manoj.playground.parkinglot.exception.ParkingLotFullException;
import com.manoj.playground.parkinglot.exception.SlotNotFoundException;
import com.manoj.playground.parkinglot.slot.ParkingSlot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.manoj.playground.parkinglot.store.ParkingLotRepository.getParkingLotRepository;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

class ParkingLotRepositoryTest {

   private ParkingLotRepository parkingLotRepository;

   @BeforeEach
   void setUp() {
      parkingLotRepository = getParkingLotRepository();
      parkingLotRepository.createSlots(3);
   }

   @Test
   void getParkingLotRepositoryMustAlwaysReturnSameInstance() {
      ParkingLotRepository object1 = getParkingLotRepository();
      ParkingLotRepository object2 = getParkingLotRepository();
      assertThat(object1).isEqualTo(object2);
   }

   @Test
   void shouldCreateParkingSlots() {
      assertThat(parkingLotRepository.getParkingSlots()).containsExactlyInAnyOrder(new ParkingSlot("1"),
         new ParkingSlot("2"),
         new ParkingSlot("3"));
   }

   @Test
   void shouldParkCarToNearestAvailableSlot() {
      parkingLotRepository.parkCar(new Car("ka01em1234", "white"));
      assertThat(parkingLotRepository.findSlotForCar("ka01em1234").getSlotId()).isEqualTo("1");
      parkingLotRepository.parkCar(new Car("ka02em1234", "red"));
      parkingLotRepository.unparkCar("1");
      parkingLotRepository.parkCar(new Car("ka03em1234", "black"));
      assertThat(parkingLotRepository.findSlotForCar("ka02em1234").getSlotId()).isEqualTo("2");
      assertThat(parkingLotRepository.findSlotForCar("ka03em1234").getSlotId()).isEqualTo("1");
   }

   @Test
   void shouldBeAbleToFindAllParkedSlots() {
      parkingLotRepository.parkCar(new Car("ka01em1234", "white"));
      parkingLotRepository.parkCar(new Car("ka02em1234", "red"));
      parkingLotRepository.parkCar(new Car("ka03em1234", "black"));
      assertThat(parkingLotRepository.getAllParkedSlots()).hasSize(3);
      parkingLotRepository.unparkCar("2");
      assertThat(parkingLotRepository.getAllParkedSlots()).hasSize(2);
   }


   @Test
   void shouldBeAbleToFindCarsByColors() {
      parkingLotRepository.parkCar(new Car("ka01em1234", "white"));
      parkingLotRepository.parkCar(new Car("ka02em1234", "white"));
      parkingLotRepository.parkCar(new Car("ka03em1234", "black"));
      assertThat(parkingLotRepository.findCarsByColor("white")).hasSize(2);
   }

   @Test
   void shouldBeAbleToFindSlotsByColor() {
      parkingLotRepository.parkCar(new Car("ka01em1234", "white"));
      parkingLotRepository.parkCar(new Car("ka02em1234", "white"));
      parkingLotRepository.parkCar(new Car("ka03em1234", "black"));
      assertThat(parkingLotRepository.findSlotsByColor("white")).hasSize(2);
   }

   @Test
   void handleGracefullyWhenParkingLotIsFull() {
      parkingLotRepository.parkCar(new Car("ka01em1234", "white"));
      parkingLotRepository.parkCar(new Car("ka02em1234", "white"));
      parkingLotRepository.parkCar(new Car("ka03em1234", "black"));
      assertThatThrownBy(() -> parkingLotRepository.parkCar(new Car("ka41em1234", "red")))
         .isInstanceOf(ParkingLotFullException.class);
   }

   @Test
   void shouldHandleGracefullyWhenTryingUnparkInvalidSlot() {
      assertThatThrownBy(() -> parkingLotRepository.unparkCar("4"))
         .isInstanceOf(SlotNotFoundException.class);
   }

   @Test
   void handleGracefullyWhenCarIsNotFoundParked() {
      assertThatThrownBy(() -> parkingLotRepository.findSlotForCar("ka01em1234"))
         .isInstanceOf(CarNotFoundException.class);
   }

   @AfterEach
   void tearDown() {
      parkingLotRepository.getParkingSlots().clear();
   }
}