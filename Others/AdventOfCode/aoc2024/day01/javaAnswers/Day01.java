package Others.AdventOfCode.aoc2024.day01.javaAnswers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Others.AdventOfCode.aoc2024.day01.javaAnswers.utils.java.Questionfetcher;

public class Day01 {
  public static void main(String[] args) {
    String input = "";
    List<Integer> column1 = new ArrayList<Integer>();
    List<Integer> column2 = new ArrayList<Integer>();
    int sumOfDifference = 0;

    try {
      input = Questionfetcher.fetchQuestion();
      // System.out.println(input);
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }

    // Parse the input and store the items respectively in the correct destinations
    // This here is quite interesting; is there any way for us to do this in one pass?
    // By using the built-in split method to split the string by multiple lines, internally
    // java has to go through the whole string
    // We should do this in one pass by manually scanning the string and then identifying if we've
    // encountered a new line break or a white space (indicating the start of a new "lexeme")
    // But I am too lazy for that actually

    // A n-element array of strings from each line of the input
    String[] inputArr = input.split("\n");

    for (String line : inputArr) {
      String[] lineArr = line.split("\\s+");
      column1.add(Integer.valueOf(lineArr[0]));
      column2.add(Integer.valueOf(lineArr[1]));
    }

    // Now sort both lists
    Collections.sort(column1, (a, b) -> a.compareTo(b));
    Collections.sort(column2, (a, b) -> a.compareTo(b));

    for (int i = 0; i < column1.size(); i++) {
      sumOfDifference += Math.abs(column1.get(i) - column2.get(i));
    }

    System.out.println("The sum of the differences is --> " + sumOfDifference);
  }
}
