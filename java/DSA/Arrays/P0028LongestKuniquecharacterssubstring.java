import java.util.HashMap;
import java.util.Map;

public class P0028LongestKuniquecharacterssubstring {
    public int longestKSubstr(String s, int k) {
        if (s == null || s.length() < k) {
            return -1;
        }

        Map<Character, Integer> charFrequency = new HashMap<>();
        int left = 0;
        int maxLength = Integer.MIN_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);

            while (charFrequency.size() > k) {
                char leftChar = s.charAt(left);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
                if (charFrequency.get(leftChar) == 0) {
                    charFrequency.remove(leftChar);
                }
                left++;
            }

            if (charFrequency.size() == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength == Integer.MIN_VALUE ? -1 : maxLength;
    }

    public static void main(String[] args) {
        P0028LongestKuniquecharacterssubstring solution = new P0028LongestKuniquecharacterssubstring();

        String s1 = "aabacbebebe";
        int k1 = 3;
        System.out.println(solution.longestKSubstr(s1, k1)); // Output: 7

        String s2 = "aaaa";
        int k2 = 2;
        System.out.println(solution.longestKSubstr(s2, k2)); // Output: -1
    }
}
