package com.manoj.playground.parkinglot.command;

import org.junit.jupiter.api.Test;

import static com.manoj.playground.parkinglot.command.Commands.CARS_BY_COLOR;
import static com.manoj.playground.parkinglot.command.Commands.CREATE_SLOT;
import static com.manoj.playground.parkinglot.command.Commands.LEAVE;
import static com.manoj.playground.parkinglot.command.Commands.PARK;
import static com.manoj.playground.parkinglot.command.Commands.SLOTS_BY_COLOR;
import static com.manoj.playground.parkinglot.command.Commands.SLOT_BY_CAR;
import static com.manoj.playground.parkinglot.command.Commands.STATUS;
import static com.manoj.playground.parkinglot.command.Commands.findCommandByInput;
import static org.assertj.core.api.Assertions.assertThat;

class CommandsTest {

   @Test
   void findCommandByInputShouldSuccessfullyParseCommands() {
      assertThat(findCommandByInput("create_parking_lot")).isEqualTo(CREATE_SLOT);
      assertThat(findCommandByInput("park")).isEqualTo(PARK);
      assertThat(findCommandByInput("leave")).isEqualTo(LEAVE);
      assertThat(findCommandByInput("status")).isEqualTo(STATUS);
      assertThat(findCommandByInput("registration_numbers_for_cars_with_colour")).isEqualTo(CARS_BY_COLOR);
      assertThat(findCommandByInput("slot_numbers_for_cars_with_colour")).isEqualTo(SLOTS_BY_COLOR);
      assertThat(findCommandByInput("slot_number_for_registration_number")).isEqualTo(SLOT_BY_CAR);
   }
}