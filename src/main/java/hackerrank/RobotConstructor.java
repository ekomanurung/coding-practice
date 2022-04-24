package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RobotConstructor {
  public static void main(String[] args) {
    String requiredParts1 = "sensors,case,speaker,wheels";
    String requiredParts2 = "sensors,case,speaker,wheels,claw";

    String[] allParts = {
        "Rocket_claw",
        "Rocket_sensors",
        "Dustie_case",
        "Rust_sensors",
        "Bolt_sensors",
        "Rocket_case",
        "Rust_case",
        "Bolt_speaker",
        "Rocket_wheels",
        "Rocket_speaker",
        "Dustie_case",
        "Dustie_arms",
        "Rust_claw",
        "Dustie_case",
        "Dustie_speaker",
        "Bolt_case",
        "Bolt_wheels",
        "Rust_legs",
        "Bolt_sensors"
    };

    System.out.println(findPossibleRobots(allParts, requiredParts1));
    System.out.println(findPossibleRobots(allParts, requiredParts2));
  }

  static List<String> findPossibleRobots(String[] allParts, String requiredPart) {
    Map<String, Set<String>> robotAndParts = new HashMap<>();
    for (String el : allParts) {
      String[] parts = el.split("_");
      Set<String> values = robotAndParts.get(parts[0]);
      if (values != null) {
        values.add(parts[1]);
        robotAndParts.put(parts[0], values);
      } else {
        Set<String> newVals = new HashSet<String>() {{
          add(parts[1]);
        }};
        robotAndParts.put(parts[0], newVals);
      }
    }

    Set<String> requiredParts = Arrays.stream(requiredPart.split(",")).collect(Collectors.toSet());

    return robotAndParts.entrySet()
        .stream()
        .filter(e -> e.getValue().containsAll(requiredParts))
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }
}
