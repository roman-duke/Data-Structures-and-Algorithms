package javaAnswers;

import java.io.IOException;

import javaAnswers.utils.java.Questionfetcher;

public class Day01 {
  public static void main(String[] args) {
    String input;
    try {
      input = Questionfetcher.fetchQuestion();
      System.out.println(input);
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
  }
}
