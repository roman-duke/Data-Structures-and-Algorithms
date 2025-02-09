package Others.AdventOfCode.aoc2024.day01.javaAnswers.utils.java;

import java.net.URI;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import Others.AdventOfCode.aoc2024.general_utils.java.EnvReader;

public class Questionfetcher {
  // TODO: Write a custom class that retrieves the environment variable for the
  // relevant day from the .env file
  private static final String URL_STRING = EnvReader.readEnv("ADVENT_OF_CODE_DAY_1_INPUT_URL");

  public static String fetchQuestion() throws IOException, InterruptedException {
    System.out.println("Here is the environment variable --> " + URL_STRING);
    // Create an HttpClient instance
    HttpClient client = HttpClient.newHttpClient();

    //TODO: Automate the process of getting the cookies (essentially the login flow)
    // Define cookies
    String cookies = "_ga=GA1.2.950787434.1738016527;" +
      "_gid=GA1.2.368833985.1739110144;" +
      "session=53616c7465645f5fbc0fff6561263ea20d4a49de9498927af0af0f76a43670549f50e8da8d44365f25fd86360e4d0521f41c453a13b26748e7c1fb3200452dda;" +
      "_ga_MHSNPJKWC7=GS1.2.1739110145.2.1.1739110671.0.0.0";

    // Create a request with cookies in the header
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(URL_STRING))
        .header("Cookie", cookies)
        .GET()
        .build();

    // Send the request and get the response
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

    return response.body();
  }
}
