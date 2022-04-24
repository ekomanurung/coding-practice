package hackerrank;

/*
You work in an automated robot factory.
 Once robots are assembled,
 they are sent to the shipping center via a series of
 autonomous delivery carts, each of which moves packages
 on a one-way route.

Given input that provides the (directed) steps that each
 cart takes as pairs, write a function that identifies
 all the start locations, and a collection of all
 of the possible ending locations for each start location.

In this diagram, starting locations are at the top
 and destinations are at the bottom -
 i.e. the graph is directed exclusively downward.

   A         E      J       Key:  [Origins]
  / \       / \      \             \
 B   C     F   L      M            [Destinations]
  \ /  \  /
   K     G
        / \
       H   I

paths = [
  ["A", "B"],
  ["A", "C"],
  ["B", "K"],
  ["C", "K"],
  ["E", "L"],
  ["F", "G"],
  ["J", "M"],
  ["E", "F"],
  ["G", "H"],
  ["G", "I"],
  ["C", "G"]
]

Expected output (unordered):
[ "A": ["K", "H", "I"],
  "E:" ["H", "L", "I"],
  "J": ["M"] ]

N: Number of pairs in the input.
*/


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class RobotPath {
  public static void main(String[] args) {
    String path[][] = new String[][] {
        {"A", "B"},
        {"A", "C"},
        {"B", "K"},
        {"C", "K"},
        {"E", "L"},
        {"F", "G"},
        {"J", "M"},
        {"E", "F"},
        {"G", "H"},
        {"G", "I"},
        {"C", "G"}
    };

    System.out.println(findPossiblePath(path));
  }

  private static Map<String, Set<String>> findPossiblePath(String[][] path) {
    Map<String, Set<String>> graph = buildGraph(path);
    Map<String, Boolean> visited = new HashMap<>();
    Map<String, Set<String>> solutions = new HashMap<>();

    //bfs O(K * (V+E)) where K is number of non visited edges and O(E+V) is complexity of bfs
    for (Map.Entry<String, Set<String>> entry : graph.entrySet()) {
      Queue<String> queue = new LinkedList<>();
      Set<String> lastElements = new HashSet<>();
      if (visited.get(entry.getKey()) == null) {
        queue.add(entry.getKey());
        while (!queue.isEmpty()) {
          String curr = queue.remove();
          Set<String> vals = graph.get(curr);
          visited.put(curr, true);
          if (vals == null || vals.isEmpty()) {
            lastElements.add(curr);
          } else {
            for (String val : vals) {
              queue.add(val);
            }
          }
        }
        solutions.put(entry.getKey(), lastElements);
      }
    }
    return solutions;
  }

  //O(N) N is number of rows
  static Map<String, Set<String>> buildGraph(String[][] path) {
    Map<String, Set<String>> graph = new HashMap<>();
    for (String[] row : path) {
      Set<String> values = graph.get(row[0]);
      if (values == null) {
        graph.put(row[0], new HashSet<String>() {{
          add(row[1]);
        }});
      } else {
        values.add(row[1]);
        graph.put(row[0], values);
      }
    }
    return graph;
  }
}
