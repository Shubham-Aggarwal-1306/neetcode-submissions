class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        int matches = 0;

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a'] += 1;
            s2Count[s2.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            matches += s1Count[i] == s2Count[i] ? 1 : 0;
        }

        int l = 0;

        for (int r = s1.length(); r<s2.length(); r++) {
            if (matches == 26) {
                return true;
            }

            s2Count[s2.charAt(r) - 'a'] += 1;

            if (s2Count[s2.charAt(r) - 'a'] == s1Count[s2.charAt(r) - 'a']) {
                matches++;
            } else if (s2Count[s2.charAt(r) - 'a'] - 1 == s1Count[s2.charAt(r) - 'a']) {
                matches--;
            }
            
            s2Count[s2.charAt(l) - 'a'] -= 1; 

            if (s2Count[s2.charAt(l) - 'a'] == s1Count[s2.charAt(l) - 'a']) {
                matches++;
            } else if (s2Count[s2.charAt(l) - 'a'] + 1 == s1Count[s2.charAt(l) - 'a']) {
                matches--;
            }
            l++;
        }


        return matches == 26;
    }
}
