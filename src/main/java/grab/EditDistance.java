package grab;

public class EditDistance {
  public static void main(String[] args) {
    System.out.println(editDistanceOnlyOne("grab", ""));
    System.out.println(editDistanceOnlyOne("", "grab"));
    System.out.println(editDistanceOnlyOne("grab", "grab"));
    System.out.println(editDistanceOnlyOne("grab", "trab"));
    System.out.println(editDistanceOnlyOne("grab1", "grab"));
    System.out.println(editDistanceOnlyOne("grab", "grab1"));
    System.out.println(editDistanceOnlyOne("Hujan", "Hutan"));
    System.out.println(editDistanceOnlyOne("Hujan", "Huan"));

    System.out.println("=========== Dynamic Programming Approach ===========");
    System.out.println(editDistanceDP("grab", ""));
    System.out.println(editDistanceDP("", "grab"));
    System.out.println(editDistanceDP("grab", "grab"));
    System.out.println(editDistanceDP("grab", "trab"));
    System.out.println(editDistanceDP("grab1", "grab"));
    System.out.println(editDistanceDP("grab", "grab1"));
    System.out.println(editDistanceDP("Hujan", "Hutan"));
    System.out.println(editDistanceDP("Hujan", "Huan"));
  }

  private static boolean editDistanceDP(String original, String edited) {
    int n = original.length();
    int m = edited.length();

    if (n == 0)
      return m == 1;
    if (m == 0)
      return n == 1;

    int[][] dp = new int[n][m];

    for (int i = 0; i < n; i++) {
      dp[i][0] = i;
    }

    for (int i = 0; i < m; i++) {
      dp[0][i] = i;
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        if (original.charAt(i - 1) == edited.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
        }
      }
    }

    return dp[n - 1][m - 1] == 1;
  }

  private static boolean editDistanceOnlyOne(String original, String edited) {
    int n = original.length();
    int m = edited.length();

    if (n == 0)
      return m == 1;
    if (m == 0)
      return n == 1;

    int count = 0, i = 0, j = 0;

    while (j < m) {
      if (i >= n)
        break;
      if (original.charAt(i) == edited.charAt(j)) {
        i++;
        j++;
      } else {
        if (n > m) {
          i++;
        } else if (n < m) {
          j++;
        } else {
          i++;
          j++;
        }
        count++;
      }
    }

    if (i < n)
      count += n - i;
    if (j < m)
      count += m - j;

    return count == 1;
  }
}
