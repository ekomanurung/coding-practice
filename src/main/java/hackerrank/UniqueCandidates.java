package hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UniqueCandidates {
  public static void main(String[] args) {
    int[] candidates = {2, 3, 6, 7};
    int target = 7;

    //result should be [[2,2,3], [7]]
    System.out.println(findUniqueCombinations(candidates, target));
  }

  static void helper(List<List<Integer>> ans,
      Queue<Integer> queue,
      int[] candidates,
      int index,
      int target) {

    if (target == 0) {
      ans.add(new ArrayList<>(queue));
      return;
    }

    for (int i = index; i < candidates.length; i++) {
      if (target - candidates[i] >= 0) {
        queue.add(candidates[i]);

        helper(ans, queue, candidates, i, target - candidates[i]);
        queue.remove();
      }
    }
  }

  static List<List<Integer>> findUniqueCombinations(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    helper(ans, queue, candidates, 0, target);

    return ans;
  }
}
