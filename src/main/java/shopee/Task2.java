package shopee;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task2 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    String inputPassword = in.nextLine();

    int length = inputPassword.length();

    if (length < 5 || length > 21) {
      System.out.println("invalid");
      return;
    }

    int countUpperCase = 0;
    int countLowerCase = 0;
    int countDigit = 0;
    int countSpecialSymbols = 0;

    Map<Character, Integer> groupOfChar = new HashMap<>();
    for (int i = 0; i < length; i++) {
      char c = inputPassword.charAt(i);

      Integer count = groupOfChar.get(c);
      if (count != null) {
        count += 1;
        groupOfChar.put(c, count);
      } else {
        groupOfChar.put(c, 1);
      }

      countUpperCase |= checkUpperCase(c);
      countLowerCase |= checkLowerCase(c);
      countDigit |= checkDigit(c);
      countSpecialSymbols |= checkSpecialSymbols(c);
    }

    int counterValidation = countUpperCase + countLowerCase + countDigit + countSpecialSymbols;
    boolean isNoRepeatedCharacter =
        groupOfChar.entrySet().stream().anyMatch(entrySet -> entrySet.getValue() < 6);
    boolean isStrongPassword = counterValidation == 4 && isNoRepeatedCharacter;

    if (isStrongPassword) {
      System.out.println("strong");
    } else if (counterValidation >= 2) {
      System.out.println("medium");
    } else {
      System.out.println("simple");
    }
  }


  /**
   * ascii uppercase is between A - Z
   *
   * @param c
   * @return true if it is uppercase otherwise false
   */
  private static int checkUpperCase(char c) {
    return c >= 'A' && c <= 'Z' ? 1 : 0;
  }

  /**
   * ascii lowercase is between a-z
   *
   * @param c
   * @return
   */
  private static int checkLowerCase(char c) {
    return c >= 'a' && c <= 'z' ? 1 : 0;
  }

  /**
   * ascii number is between 0-9
   *
   * @param c
   * @return
   */
  private static int checkDigit(char c) {
    return c >= '0' && c <= '9' ? 1 : 0;
  }

  /**
   * ascii special character is (32–47 / 58–64 / 91–96 / 123–126)
   *
   * @param c
   * @return
   */
  private static int checkSpecialSymbols(char c) {
    return checkUpperCase(c) == 0 && checkLowerCase(c) == 0 && checkDigit(c) == 0 ? 1 : 0;
  }
}
