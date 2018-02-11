package com.manoj.playground.parkinglot;

import com.manoj.playground.parkinglot.command.CommandParser;

import java.util.Scanner;

import static com.manoj.playground.parkinglot.parser.InputFileParser.parseCommandsFromFile;

public class ParkingLotApplication {
   public static void main(String[] args) {
      if (args.length == 1) {
         parseCommandsFromFile(args[0]);
      } else {
         while (true) {
            System.out.println("Input:");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            System.out.println("Output");
            CommandParser.parseCommand(line);
         }
      }
   }
}
