import java.util.ArrayList;
import java.util.List;

public class P0023FindAllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] charCountP = new int[26];
        int[] charCountS = new int[26];

        for (char c : p.toCharArray()) {
            charCountP[c - 'a']++;
        }

        int windowSize = p.length();
        for (int i = 0; i < windowSize; i++) {
            charCountS[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s.length() - windowSize; i++) {

            boolean res = true;
            inner: for (int j = 0; j < 26; j++) {
                if (charCountS[j] != charCountP[j]) {
                    res = false;
                    break inner;
                }
            }

            if (res) {
                result.add(i);
            }

            if (i + windowSize < s.length()) {
                charCountS[s.charAt(i) - 'a']--;
                charCountS[s.charAt(i + windowSize) - 'a']++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        P0023FindAllAnagrams solution = new P0023FindAllAnagrams();
        List<Integer> result = solution.findAnagrams(s, p);

        // Print the result
        System.out.println(result);
    }
}
