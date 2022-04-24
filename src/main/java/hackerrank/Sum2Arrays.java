package hackerrank;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum2Arrays {
  public static void main(String[] args) {
    System.out.println(findPairs(new int[] {0, -1, 2, -3, 1}, -2));
    System.out.println(findPairs(new int[] {1, 2, 3, 4, 5}, 5));
    System.out.println("=========== 2 sum memory optimization ===========");
    System.out.println(twoSum(new int[] {1, 2, 3, 4, 5}, 11));
  }

  static String twoSum(int[] arr, int target) {
    Arrays.sort(arr);

    int i = 0, j = arr.length - 1;

    while (i < j) {
      if (arr[i] + arr[j] == target) {
        return arr[i] + " , " + arr[j];
      } else {
        if (arr[j] >= target && arr[i] + arr[j] > target) {
          j--;
        } else {
          i++;
        }
      }
    }
    return "-1";
  }

  static List<Pair<Integer, Integer>> findPairs(int[] arr, int target) {
    List<Pair<Integer, Integer>> pairs = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < arr.length; i++) {
      if (set.contains(target - arr[i])) {
        pairs.add(new Pair<>(arr[i], target - arr[i]));
      } else {
        set.add(arr[i]);
      }
    }

    return pairs;
  }
}
