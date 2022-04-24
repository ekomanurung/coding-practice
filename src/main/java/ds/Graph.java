package ds;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Graph {

  private Map<String, List<String>> map = new HashMap<>();

  void dfs(String source) {
    System.out.print("Starting dfs with source: " + source + ": ");
    Stack<String> stack = new Stack();
    stack.push(source);

    while (!stack.isEmpty()) {
      String curr = stack.pop();
      System.out.print(String.join(",", curr));

      List<String> neighbours = map.get(curr);

      if (neighbours == null) {
        System.out.println(" -> Node " + source + " is not exist");
        return;
      }

      for (String neighbour : neighbours) {
        stack.push(neighbour);
      }
    }
    System.out.println();
  }

  void bfs(String source) {
    System.out.print("Starting bfs with source: " + source + ": ");
    Queue<String> queue = new LinkedList<>();
    queue.add(source);

    while (!queue.isEmpty()) {
      String curr = queue.remove();
      System.out.print(String.join(",", curr));
      for (String neighbour : map.get(curr)) {
        queue.add(neighbour);
      }
    }
  }

  void build(Map<String, List<String>> map) {
    this.map = map;
  }
}


class Driver {
  public static void main(String[] args) {
    Graph graph = new Graph();
    Map<String, List<String>> sample = new HashMap<String, List<String>>() {{
      put("a", Arrays.asList("c", "b"));
      put("b", Arrays.asList("d"));
      put("c", Arrays.asList("e"));
      put("d", Arrays.asList("f"));
      put("e", Collections.emptyList());
      put("f", Collections.emptyList());
    }};

    graph.build(sample);
    graph.dfs("a");
    graph.dfs("f");
    graph.dfs("k");

    graph.bfs("a");
  }
}
