package hackerrank;

public class ChocolateFest {
  public static void main(String[] args) {
    System.out.println(chocolateFest(12, 4, 4));
    System.out.println(chocolateFest(10, 2, 5));
    System.out.println(chocolateFest(6, 2, 2));
  }

  static int chocolateFest(int n, int c, int m) {
    int coklat = n / c;
    int bungkus = n / c;

    while (bungkus >= m) {
      coklat += (bungkus / m);
      bungkus = (bungkus / m) + (bungkus % m);
    }
    return coklat;
  }
}
