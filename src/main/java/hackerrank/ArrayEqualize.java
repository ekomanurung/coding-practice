package hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class ArrayEqualize {
  public static void main(String[] args) {
    System.out.println(equalizeArray(Arrays.asList(1, 1, 2, 2, 3)));
    String s2 = "saya";
    //    System.out.println(equalizeArray(Arrays.asList(37, 32, 97, 35, 76, 62)));
  }

  static int equalizeArray(List<Integer> arr) {
    SortedMap<Integer, Integer> countItem = new TreeMap<>();

    for (Integer item : arr) {
      countItem.merge(item, 1, Integer::sum);
    }

    Integer max = countItem.entrySet()
        .stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getValue)
        .orElse(0);

    int countMax = countItem.values()
        .stream()
        .filter(integer -> integer == max)
        .mapToInt(Integer::intValue)
        .sum();

    System.out.println(countMax);

    int countElse = countItem.values()
        .stream()
        .filter(integer -> integer != max)
        .mapToInt(Integer::intValue)
        .sum();

    System.out.println(countElse);

    countMax = countMax > 1 ? countMax - max : countMax;

    System.out.println(countMax);

    return countElse + countMax;
  }
}
