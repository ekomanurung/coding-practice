package algorithm;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordBreakTest {

  @Test
  public void testWordBreakRecursive() {
    WordBreak wordBreak = new WordBreak();

    assertTrue(wordBreak.wordBreak("code", Arrays.asList("c", "od", "e", "x"), new HashMap<>()));
    assertTrue(wordBreak.wordBreak("leetcode", Arrays.asList("leet", "code"), new HashMap<>()));
    assertTrue(wordBreak.wordBreak("applepenapple",
        Arrays.asList("apple", "pen"),
        new HashMap<>()));
    assertFalse(wordBreak.wordBreak("catsandog",
        Arrays.asList("cats", "dog", "sand", "and", "cat"),
        new HashMap<>()));
    assertTrue(wordBreak.wordBreak("cars",
        Arrays.asList("car", "ca", "rs"),
        new HashMap<>()));
    assertTrue(wordBreak.wordBreak("aaaaaaa",
        Arrays.asList("aaaa", "aaa"),
        new HashMap<>()));
  }

  @Test
  public void testWordBreakII() {
    WordBreak wordBreak = new WordBreak();
    assertEquals(Arrays.asList(
        "cat sand dog",
        "cats and dog"
    ), wordBreak.wordBreakII("catsanddog",
        Arrays.asList("cat", "cats", "and", "sand", "dog"), new HashMap<>()));
    assertEquals(Arrays.asList(
        "pine apple pen apple",
        "pine applepen apple",
        "pineapple pen apple"
    ), wordBreak.wordBreakII("pineapplepenapple",
        Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"), new HashMap<>()));
    assertEquals(Arrays.asList("ca rs"), wordBreak.wordBreakII("cars",
        Arrays.asList("car", "ca", "rs"), new HashMap<>()));
    assertEquals(Collections.emptyList(), wordBreak.wordBreakII("catsandog",
        Arrays.asList("cats", "dog", "sand", "and", "cat"), new HashMap<>()));
  }
}
