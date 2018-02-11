package com.manoj.playground.parkinglot.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class InputFileParser {

   public static void parseCommandsFromFile(String fileLocation) {
      try {
         FileInputStream fin = new FileInputStream(fileLocation);
         BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
         String line;
         while ((line = reader.readLine()) != null) {
            System.out.println(line);
         }
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
}
