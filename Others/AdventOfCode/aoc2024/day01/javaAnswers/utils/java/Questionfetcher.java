package Others.AdventOfCode.aoc2024.day01.javaAnswers.utils.java;

import java.net.URI;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Questionfetcher {
  // TODO: Write a custom class that retrieves the environment variable for the relevant day from the .env file
  private static final String URL_STRING = System.getenv("ADVENT_OF_CODE_DAY_1_INPUT_URL");

  public static String fetchQuestion() throws IOException, InterruptedException {
    System.out.println("Here is the environment variable --> " + URL_STRING);
    // Create an HttpClient instance
    HttpClient client = HttpClient.newHttpClient();

    // Create a request
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(URL_STRING))
        .GET()
        .build();

    // Send the request and get the response
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    // Print the status code and response body
    System.out.println("Status Code: " + response.statusCode());
    System.out.println("Response Body: " + response.body());

    return response.body();
  }
}
