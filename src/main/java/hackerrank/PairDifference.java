package hackerrank;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PairDifference {


/*
Pairs with Specific Difference
Given an array arr of distinct integers and a nonnegative integer k, write a function findPairsWithGivenDifference that returns an array of all pairs [x,y] in arr, such that x - y = k. If no such pairs exist, return an empty array.

Note: the order of the pairs in the output array should maintain the order of the y element in the original array.

Examples:

input:  arr = [0, -1, -2, 2, 1], k = 1
output: [[1, 0], [0, -1], [-1, -2], [2, 1]]

input:  arr = [1, 7, 5, 3, 32, 17, 12], k = 17
output: []
Constraints:

[time limit] 5000ms

[input] array.integer arr

0 ≤ arr.length ≤ 100
[input]integer k

k ≥ 0
[output] array.array.integer
*/


  /*
   * Click `Run` to execute the snippet below!
   */

  // brute force o(n2)
  // iterate it linear time o(n)

  // [0, -1, -2, 2, 1], k = 1
  //  0 - k || 0 + k = 0. -1 , 0 ,1


  static List<Pair<Integer, Integer>> findPairsWithGivenDifference(int[] arr, int k) {
    Set<Integer> set = new HashSet<>();
    List<Pair<Integer, Integer>> ans = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {
      set.add(arr[i]);
    }

    for (int i = 0; i < arr.length; i++) {
      int left = arr[i] + k;

      if (set.contains(left)) {
        ans.add(new Pair<>(left, arr[i]));
      }
    }
    return ans;
  }

  public static void main(String[] args) {

    int[] arr = new int[] {0, -1, -2, 2, 1};
//    int[] arr = new int[] {1, 7, 5, 3, 32, 17, 12};
    List<Pair<Integer, Integer>> resArr = findPairsWithGivenDifference(arr, 1);
    //print pairs
    for (int i = 0; i < resArr.size(); i++) {
      System.out.println("pair : " + resArr.get(i).getKey() + " , " + resArr.get(i).getValue());
    }
  }
}
