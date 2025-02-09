package Others.AdventOfCode.aoc2024.general_utils.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnvReader {
  //TODO: Write custom Java code that searches for the .env at the top level of the directory
  public static List<String> readEnvFile(Path path) throws IOException {
    return Files.readAllLines(path);
  }

  public static Map<String, String> convertLinesToMap(String[] lineStrings) {
    //Lookup table
    Map<String, String> envMap = new HashMap<>();
    for (String line : lineStrings) {
      String[] lineParts = line.split("=");
      envMap.put(lineParts[0], lineParts[1]);
    }

    return envMap;
  }

  public static String readEnv(String env) {
    var path = Path.of("Others/AdventOfCode/.env");
    String[] lines;
    try {
      lines = EnvReader.readEnvFile(path).toArray(new String[0]);
    } catch (IOException e) {
      throw new Error("File Not Found");
    }

    var envMap = convertLinesToMap(lines);

    // read from the lookup table and return the value
    return envMap.get(env);
  }
}
