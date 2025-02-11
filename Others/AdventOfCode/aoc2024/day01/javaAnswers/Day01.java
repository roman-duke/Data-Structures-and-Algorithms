package Others.AdventOfCode.aoc2024.day01.javaAnswers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import Others.AdventOfCode.aoc2024.day01.javaAnswers.utils.java.Questionfetcher;

public class Day01 {
  static List<List<Integer>> _splitIntoTwoColumns(String input) {
    List<Integer> column1 = new ArrayList<Integer>();
    List<Integer> column2 = new ArrayList<Integer>();

    // Parse the input and store the items respectively in the correct destinations
    // This here is quite interesting; is there any way for us to do this in one pass?
    // By using the built-in split method to split the string by multiple lines, internally
    // java has to go through the whole string
    // We should do this in one pass by manually scanning the string and then identifying if we've
    // encountered a new line break or a white space (indicating the start of a new "lexeme")
    // But I am too lazy for that actually

    // A n-element array of strings from each line of the input
    // Actually, another way to build the array is by using a single regex
    // that matches the pattern "\n "or " +" (newlines or consecutive spaces)
    // And then we sieve the array, all (i+1)%2 == 0 gets added to the second list
    // and all (i+1)%2 == 1 get added to the first list.
    String[] inputArr = input.split("\n");

    for (String line : inputArr) {
      String[] lineArr = line.split("\\s+");
      column1.add(Integer.valueOf(lineArr[0]));
      column2.add(Integer.valueOf(lineArr[1]));
    }

    List<List<Integer>> result = new ArrayList<>();
    result.add(column1); result.add(column2);

    return result;
  }

  static int part01(String input) {
    int sumOfDifference = 0;
    var columns = _splitIntoTwoColumns(input);
    var column1 = columns.get(0);
    var column2 = columns.get(1);

    // Now sort both lists
    Collections.sort(column1, (a, b) -> a.compareTo(b));
    Collections.sort(column2, (a, b) -> a.compareTo(b));

    for (int i = 0; i < column1.size(); i++) {
      sumOfDifference += Math.abs(column1.get(i) - column2.get(i));
    }

    return sumOfDifference;
  }

  /**
   * Essentially, this attempts to calculate the similarity index
   * between the two lists found in the Chief Historian's office.
   * This is calculated by finding the number of occurrences, in the right list,
   * of each number in the left list, multiplying them and finding the sum of everything.
   *
   * @param inputArr the input array
   * @return the similarity index
   *
   */
  static int part02(String input) {
    int similarityIndex = 0;
    // So essentially we use a hash map to store the number of occurrences
    // but to build this hash map, we have to loop over the lists twice.
    HashMap<Integer, Integer> leftListHashMap = new HashMap<>();
    var columns = _splitIntoTwoColumns(input);
    var column1 = columns.get(0);
    var column2 = columns.get(1);

    for (int leftColumnItem : column1) {
      leftListHashMap.put(leftColumnItem, 0);
    }

    // Just take the sum as you update the map
    for (int rightColumnItem : column2) {
      if (leftListHashMap.containsKey(rightColumnItem)) {
        similarityIndex += rightColumnItem;
      }
    }

    return similarityIndex;
  }

  public static void main(String[] args) {
    String input = "";

    try {
      input = Questionfetcher.fetchQuestion();
      // System.out.println(input);
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }

    System.out.println("The sum of the differences is --> " + part01(input));
    System.out.println("The similarity index is given as follows --> " + part02(input));
  }
}
