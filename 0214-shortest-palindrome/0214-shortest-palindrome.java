class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Create the new string: s + "#" + reversed(s)
        StringBuilder sb = new StringBuilder(s);
        String reverseS = sb.reverse().toString();
        String combined = s + "#" + reverseS;

        // Build the LPS array
        int[] lps = buildLPS(combined);

        // Length of the longest palindromic prefix
        int longestPalindromicPrefixLen = lps[combined.length() - 1];

        // Non-palindromic part to add in front
        String nonPalindromicPart = reverseS.substring(0, s.length() - longestPalindromicPrefixLen);
        
        // Form the shortest palindrome
        return nonPalindromicPart + s;
    }

    private int[] buildLPS(String str) {
        int[] lps = new int[str.length()];
        int length = 0; // length of the previous longest prefix suffix
        int i = 1;

        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}