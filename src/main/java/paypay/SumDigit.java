package paypay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumDigit {
  public static void main(String[] args) {
    System.out.println(Arrays.asList(solution(new int[] {25, 2, 3, 57, 38, 41})));
    System.out.println(Arrays.asList(solution(new int[] {0, 3, 5, 0})));
  }

  static List<Integer> solution(int[] a) {
    //move the solution to use array since digit only 10 and array is o(1)
    int[] bucket = new int[10];

    for (int i = 0; i < a.length; i++) {
      int el = a[i];
      if (el == 0) {
        bucket[el]++;
      }
      while (el > 0) {
        int mod = el % 10;
        bucket[mod]++;
        el /= 10;
      }
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < bucket.length; i++) {
      max = Math.max(bucket[i], max);
    }

    List<Integer> sol = new ArrayList<>();
    for (int i = 0; i < bucket.length; i++) {
      if (bucket[i] == max)
        sol.add(i);
    }

    return sol;
  }
}
