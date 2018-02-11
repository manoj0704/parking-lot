package com.manoj.playground.parkinglot.command;

import com.manoj.playground.parkinglot.car.Car;
import com.manoj.playground.parkinglot.exception.CarNotFoundException;
import com.manoj.playground.parkinglot.exception.ParkingLotFullException;
import com.manoj.playground.parkinglot.exception.SlotNotFoundException;
import com.manoj.playground.parkinglot.slot.ParkingSlot;
import com.manoj.playground.parkinglot.store.ParkingLotRepository;

import java.util.List;

import static com.manoj.playground.parkinglot.command.Commands.findCommandByInput;
import static com.manoj.playground.parkinglot.store.ParkingLotRepository.getParkingLotRepository;
import static java.lang.Integer.valueOf;

public class CommandParser {

   private static ParkingLotRepository parkingLotRepository = getParkingLotRepository();

   public static void parseCommand(String input) {
      String[] words = input.split(" ");
      Commands command = findCommandByInput(words[0]);
      try {
         runCommand(command, words);
      } catch (IllegalArgumentException e) {
         System.out.println(e.getMessage());
      }
   }

   private static void runCommand(Commands command, String[] words) {
      switch (command) {
         case CREATE_SLOT:
            createSlots(words[1]);
            break;
         case PARK:
            parkCar(words[1], words[2]);
            break;
         case LEAVE:
            leave(words[1]);
            break;
         case STATUS:
            printStatus();
            break;
         case CARS_BY_COLOR:
            printCarsByColor(words[1]);
            break;
         case SLOTS_BY_COLOR:
            printSlotsByColor(words[1]);
            break;
         case SLOT_BY_CAR:
            printSlotByCar(words[1]);
            break;
         default:
            printErrorMessage();
      }
   }

   private static void printErrorMessage() {
      System.out.println("Unrecognized command! Please try again!");
   }

   private static void printSlotByCar(String regNumber) {
      try {
         final ParkingSlot slotForCar = parkingLotRepository.findSlotForCar(regNumber);
         System.out.println(slotForCar.getSlotId());
      } catch (CarNotFoundException e) {
         System.out.println("Not found");
      }
   }

   private static void printSlotsByColor(String color) {
      List<ParkingSlot> parkingSlots = parkingLotRepository.findSlotsByColor(color);
      if (parkingSlots != null) {
         int i;
         for (i = 0; i < parkingSlots.size() - 1; i++) {
            System.out.print(parkingSlots.get(i).getSlotId() + ", ");
         }
         System.out.println(parkingSlots.get(i).getSlotId());
      } else {
         System.out.println("Not found");
      }
   }

   private static void printCarsByColor(String color) {
      List<Car> cars = parkingLotRepository.findCarsByColor(color);
      if (cars != null) {
         int i;
         for (i = 0; i < cars.size() - 1; i++) {
            System.out.print(cars.get(i).getRegNo() + ", ");
         }
         System.out.println(cars.get(i).getRegNo());
      } else {
         System.out.println("Not found");
      }
   }

   private static void printStatus() {
      System.out.println("Slot No.\tRegistration No\tColour");
      parkingLotRepository.getAllParkedSlots()
         .forEach(parkingSlot -> System.out.println(parkingSlot.printParkingSlotInformation()));
   }

   private static void leave(String parkingSlot) {
      try {
         parkingLotRepository.unparkCar(parkingSlot);
         System.out.println("Slot number " + parkingSlot + " is free");
      } catch (SlotNotFoundException e) {
         System.out.println("Slot not found! Please try again.");
      }
   }

   private static void parkCar(String regNumber, String color) {
      try {
         final ParkingSlot parkingSlot = parkingLotRepository.parkCar(new Car(regNumber, color));
         System.out.println("Allocated slot number: " + parkingSlot.getSlotId());
      } catch (ParkingLotFullException e) {
         System.out.println("Sorry, parking lot is full");
      }
   }

   private static void createSlots(String numberOfSlots) {
      parkingLotRepository.createSlots(valueOf(numberOfSlots));
      System.out.println("Created a parking lot with " + numberOfSlots + " slots");
   }

}
