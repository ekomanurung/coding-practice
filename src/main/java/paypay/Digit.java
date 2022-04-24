package paypay;

public class Digit {
  public static void main(String[] args) {
    System.out.println(solution(29));
  }

  static int solution(int n) {
    int sum = 0;
    while (n > 0) {
      int mod = n % 10;
      sum += mod;
      n /= 10;
    }
    return sum;
  }
}
