package algorithm;

/**
 * given a set of coins [1,2,5] and amount 11
 * return the fewest possible coin that can be used
 * input: coins: [1,2,5] , amount = 11
 * output : 3 : [5,5,1]
 */


import java.util.Arrays;

/**
 * solution 1 : greedy loop from max coins until the min coins
 * time complexity : O(C2) because we need to loop all coins for particular amount
 * space complexity: O(1)
 * solution 2: dynamic programming using memoization table
 * cache the amount from 0 ... amount
 * find minimum for each amount
 * time complexity: O(C * len(amount))
 * space complexity: O(len(amount))
 */
public class CoinChange {
  public static void main(String[] args) {
    System.out.println("Greedy");
    System.out.println(3 == greedySolution(new int[] {1, 2, 5}, 11));
    System.out.println(2 == greedySolution(new int[] {1, 3, 4, 5}, 7));

    System.out.println("Dynamic Programming bottom up memoization");
    System.out.println(3 == dpSolution(new int[] {1, 2, 5}, 11));
    System.out.println(2 == dpSolution(new int[] {1, 3, 4, 5}, 7));
  }

  static int dpSolution(int[] coins, int amount) {
    int dp[] = new int[amount + 1];

    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int i = 1; i < dp.length; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (i - coins[j] >= 0) {
          dp[i] = Math.min(1 + dp[i - coins[j]], dp[i]);
        }
      }
    }
    return dp[amount];
  }

  static int greedySolution(int[] coins, int amount) {
    int ans = 0;

    for (int i = coins.length - 1; i >= 0; i--) {
      while (amount >= coins[i] && amount - coins[i] >= 0) {
        amount -= coins[i];
        ans++;
      }
    }
    return ans;
  }
}
