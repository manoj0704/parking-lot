package com.manoj.playground.parkinglot.car;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class Car {

   private final String regNo;

   private final String color;

   public Car(String regNo, String color) {
      if (isBlank(regNo) || isBlank(color)) {
         throw new IllegalArgumentException("Invalid input. Registration number and color mandatory for a car!");
      }
      this.regNo = regNo;
      this.color = color;
   }

   public String getRegNo() {
      return regNo;
   }

   public String getColor() {
      return color;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }

      Car car = (Car) o;

      return regNo.equals(car.regNo) && color.equals(car.color);
   }

   @Override
   public int hashCode() {
      int result = regNo.hashCode();
      result = 31 * result + color.hashCode();
      return result;
   }
}
