package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WordBreak {
  /**
   * @param s
   * @param dictionary
   * @return true or false if we can construct the s from dictionary
   * recursive can be overlapping because the decision tree can repeat the same substring > 1
   * ex: wordBreak("od", dict) can be repeated
   * how to tackle that? we need to store each of recursive solution in hashmap,
   * so it won't process the same substring more than 1
   */
  public boolean wordBreak(String s, List<String> dictionary, Map<String, Boolean> isVisited) {
    if (s.equals(""))
      return true;

    if (isVisited.containsKey(s))
      return isVisited.get(s);

    for (String word : dictionary) {
      if (s.startsWith(word)) {
        String subset = s.substring(word.length());
        if (wordBreak(subset, dictionary, isVisited)) {
          isVisited.put(subset, true);
          return true;
        }
      }
    }
    isVisited.put(s, false);
    return false;
  }

  public List<String> wordBreakII(String s,
      List<String> dictionary, Map<String, List<String>> visited) {
    List<String> ans = new ArrayList<>();
    if (s.equals("")) {
      ans.add("");
      return ans;
    }

    if (visited.containsKey(s))
      return visited.get(s);

    for (String word : dictionary) {
      if (s.startsWith(word)) {
        String subset = s.substring(word.length());
        List<String> subsets = wordBreakII(subset, dictionary, visited);
        for (String t : subsets) {
          String space = t.isEmpty() ? "" : " ";
          String valueStr = word + space + t;
          ans.add(valueStr);
          List<String> strings = visited.getOrDefault(valueStr, new ArrayList<>());
          strings.add(valueStr);
          visited.put(s, strings);
        }
      }
    }
    return ans;
  }
}
