package com.manoj.playground.parkinglot.parser;

import com.manoj.playground.parkinglot.command.CommandParser;

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
            CommandParser.parseCommand(line.trim());
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
