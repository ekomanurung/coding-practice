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

    for (int i = 0; i < length; i++) {
      char c = inputPassword.charAt(i);

      countUpperCase += checkUpperCase(c) ? 1 : 0;
      countLowerCase += checkLowerCase(c) ? 1 : 0;
      countDigit += checkDigit(c) ? 1 : 0;
      countSpecialSymbols += checkSpecialSymbols(c) ? 1 : 0;
    }

    int counterValidation =
        (countUpperCase > 0 ? 1 : 0)
            + ((countLowerCase > 0) ? 1 : 0)
            + (countDigit > 0 ? 1 : 0)
            + (countSpecialSymbols > 0 ? 1 : 0);

    boolean isRepeatedCharacterExist = checkRepeatCharacters(inputPassword);
    boolean isStrongPassword = counterValidation == 4 && !isRepeatedCharacterExist;

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
  private static boolean checkUpperCase(char c) {
    return c >= 'A' && c <= 'Z';
  }

  /**
   * ascii lowercase is between a-z
   *
   * @param c
   * @return
   */
  private static boolean checkLowerCase(char c) {
    return c > 'a' && c < 'z';
  }

  /**
   * ascii number is between 0-9
   *
   * @param c
   * @return
   */
  private static boolean checkDigit(char c) {
    return c > '0' && c < '9';
  }

  /**
   * ascii special character is (32–47 / 58–64 / 91–96 / 123–126)
   *
   * @param c
   * @return
   */
  private static boolean checkSpecialSymbols(char c) {
    return !checkUpperCase(c) && !checkLowerCase(c) && !checkDigit(c);
  }

  private static boolean checkRepeatCharacters(String input) {
    Map<Character, Integer> groupOfChar = new HashMap<Character, Integer>();

    for (int i = 0; i < input.length(); i++) {
      Integer count = groupOfChar.get(input.charAt(i));
      if (count != null) {
        count += 1;
        groupOfChar.put(input.charAt(i), count);
      } else {
        groupOfChar.put(input.charAt(i), 1);
      }
    }

    return groupOfChar.entrySet().stream().anyMatch(entrySet -> entrySet.getValue() > 5);
  }
}
