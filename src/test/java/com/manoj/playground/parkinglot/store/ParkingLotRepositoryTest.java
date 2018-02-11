package com.manoj.playground.parkinglot.store;

import org.junit.jupiter.api.Test;

import static com.manoj.playground.parkinglot.store.ParkingLotRepository.getParkingLotRepository;
import static org.assertj.core.api.Java6Assertions.assertThat;

class ParkingLotRepositoryTest {

   @Test
   void getParkingLotRepositoryMustAlwaysReturnSameInstance() {
      ParkingLotRepository parkingLotRepository = getParkingLotRepository();
      ParkingLotRepository anotherParkingLotRepository = getParkingLotRepository();
      assertThat(parkingLotRepository).isEqualTo(anotherParkingLotRepository);
   }
}