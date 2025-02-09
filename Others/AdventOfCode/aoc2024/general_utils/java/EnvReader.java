package Others.AdventOfCode.aoc2024.general_utils.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EnvReader {
  public static String readEnv(Path path) throws IOException {
    String content = Files.readString(path);
    return content;
  }

  public static void main(String[] args) {
    var path = Path.of("Others/AdventOfCode/.env");
    try {
      System.out.println(EnvReader.readEnv(path));
    } catch (IOException e) {
      System.out.println("Eren Jaeger");
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
