package com.manoj.playground.parkinglot;

import static com.manoj.playground.parkinglot.parser.InputFileParser.parseCommandsFromFile;

public class ParkingLotApplication {
   public static void main(String[] args) {
      if (args.length == 1) {
         parseCommandsFromFile(args[0]);
      } else {
         System.out.println("Welcome");
      }
   }
}
