package hackerrank;

import java.math.BigInteger;

public class BinaryMultiplication {

  public int solution(int A, int B) {
    BigInteger results = BigInteger.valueOf(A).multiply(BigInteger.valueOf(B));

    if (results.equals(BigInteger.ZERO))
      return 0;

    String s = Long.toBinaryString(results.longValue());

    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1')
        count++;
    }
    return count;
  }
}
