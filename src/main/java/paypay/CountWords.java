package paypay;

public class CountWords {
  package paypay;

public class CountWords {
  public static void main(String[] args) {

        List<String> dict = new ArrayList<String>() {{
            add("ted");
            add("tex");
            add("red");
            add("tax");
            add("tad");
            add("den");
            add("rex");
            add("pee");
        }};

        List<String> dict2 = new ArrayList<String>() {{
            add("a");
            add("b");
            add("c");
        }};
        System.out.println(ladderLength("red", "tax", dict));
//        System.out.println(ladderLength("a", "c", dict2));
    }

    static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> dictionary = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                dictionary.computeIfAbsent(pattern, v -> new ArrayList<>()).add(word);
            }
        }

        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        q.add(beginWord);
        int result = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.remove();
                if (word.equals(endWord)) {
                    return result;
                }
                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    for (String neiword : dictionary.getOrDefault(pattern, new ArrayList<>())) {
                        if (!visited.contains(neiword)) {
                            visited.add(neiword);
                            q.add(neiword);
                        }
                    }
                }
            }
            result += 1;
        }
        return 0;
    }
}
