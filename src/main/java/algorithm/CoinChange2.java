package algorithm;

/**
 * given an array coins and amount
 * find unique ways to change the amount into coins
 * ex input: [1,2,5] amount=5
 * output: 4
 * explanation:
 * 1+1+1+1+1 = 5
 * 2+1+1+1 = 5
 * 2+2+1 = 5
 * 5
 */
public class CoinChange2 {
  public static void main(String[] args) {
    System.out.println(4 == solution(new int[] {1, 2, 5}, 5));
    System.out.println(0 == solution(new int[] {2}, 3));
  }

  /**
   * @param coins
   * @param amount
   * @return unique ways to change the coins with amount 5
   * using dp tables
   */
  static int solution(int[] coins, int amount) {
    //dp tables will store the combination of coins and amount
    int m = coins.length;
    int n = amount + 1;
    int dp[][] = new int[n][m];

    //fill column 0 as 1 because we only have 1 way to do with 0 amount, do nothing
    for (int i = 0; i < m; i++) {
      dp[0][i] = 1;
    }

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int x = i - coins[j] >= 0 ? dp[i - coins[j]][j] : 0;
        int y = j >= 1 ? dp[i][j - 1] : 0;

        dp[i][j] = x + y;
      }
    }

    return dp[n - 1][m - 1];
  }
}
