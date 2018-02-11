package com.manoj.playground.parkinglot.command;

import static java.util.Arrays.stream;

public enum Commands {

   CREATE_SLOT("create_parking_lot"),

   PARK("park"),

   LEAVE("leave"),

   STATUS("status"),

   CARS_BY_COLOR("registration_numbers_for_cars_with_colour"),

   SLOTS_BY_COLOR("slot_numbers_for_cars_with_colour"),

   SLOT_BY_CAR("slot_number_for_registration_number");

   private final String commandText;

   Commands(String commandText) {
      this.commandText = commandText;
   }

   public static Commands findCommandByInput(String input) {
      return stream(values())
         .filter(commands -> commands.commandText.equals(input))
         .findFirst()
         .orElse(null);
   }
}
