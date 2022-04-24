package grab;

import java.math.BigDecimal;
import java.util.Arrays;

public class Practice {
  public static void main(String[] args) {
    //    System.out.println(smallestPositiveIntegerNotInArray(new int[] {1, 3, 6, 4, 1, 2}));

    StringBuilder S = new StringBuilder();
    for (int i = 1; i <= 100; i++) {
      S.append("1");
    }

    //    System.out.println(task2(S.toString()));
    //    System.out.println(task2("111"));
    System.out.println(findMaxDistance(new int[] {10, 0, 8, 2, -1, 12, 11, 3}));
  }

  static int smallestPositiveIntegerNotInArray(int[] A) {
    Arrays.sort(A);

    return -1;
  }

  static long task2(String S) {
    BigDecimal bd = new BigDecimal(S);
    int base = 1;
    BigDecimal decimal = BigDecimal.ZERO;

    while (bd.compareTo(BigDecimal.ZERO) > 0) {
      BigDecimal last = bd.remainder(new BigDecimal(10));
      bd = bd.divide(new BigDecimal(10), BigDecimal.ROUND_FLOOR);

      decimal = decimal.add(last.multiply(BigDecimal.valueOf(base)));

      base *= 2;
    }

    long count = 0;
    while (decimal.compareTo(BigDecimal.ZERO) > 0) {
      if (decimal.remainder(new BigDecimal(2)).compareTo(BigDecimal.ZERO) > 0) {
        decimal = decimal.subtract(new BigDecimal(1));
      } else {
        decimal = decimal.divide(new BigDecimal(2), BigDecimal.ROUND_FLOOR);
      }
      count++;
    }
    return count;
  }

  /*
  You want to park your bicycle in a bicycle parking area where bike racks are aligned in a row. There are already N bikes parked there (each bike is attached to exactly one rack, but a rack can have multiple bikes attached to it). We call racks that already have bikes attached used.

You want to park your bike in a rack in the parking area according to the following criteria:

The chosen rack must lie between the first and the last used racks (inclusive);

The distance between the chosen rack and any other used rack is as big as possible

A description of the bikes already parked in the racks is given in a non-empty zero-indexed array A element A[K] denotes the position of the rack to which bike number K is attached (for 0 ≤ K<N) The central position in the parking area is position 0. A positive value means that the rack is located A[K] meters to the right of the central position 0: a negative value means that it\'s located ∣A[K]∣ meters to the left (the absolute value of A[K])

For example, consider array A such that:

A [0] = 10

A [1] = 0

A [2] = 8

A [3] = 2

A [4] = -1

A [5] = 12

A [6] = 11

A [7] = 3

In the figure below, available racks are represented by dots. Bigger dots represent racks with bikes attached to them.

You can attach your bike to any rack between rack -1 and rack 12 (including these two racks).
In order to maximize the distance to any used rack, you should attach your bike either to rack 5 or to rack 6.
The resulting distance is 2 meters (from 5 to used rack 3, or from 6 to used rack 8 respectively) Write a function:

int solution (vector<int> &A);
that, given a non-empty zero-indexed array A of N integers, returns the largest possible distance in meters between the chosen rack and any other used rack.
   */
  static int findMaxDistance(int[] A) {
    int answer = Integer.MIN_VALUE;
    Arrays.sort(A);

    if (A.length == 2) {
      return (A[1] - A[0]) / 2;
    }

    for (int i = 0; i < A.length - 1; i++) {
      if (A[i + 1] - A[i] > 1) {
        answer = Math.max(answer, A[i + 1] - A[i]);
      }
    }
    return answer / 2;
  }
}
