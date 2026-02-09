class Solution {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int n = s.length();
        int mid = n / 2;
        
        int countA = 0, countB = 0;
        
        // Count vowels in first half
        for (int i = 0; i < mid; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                countA++;
            }
        }
        
        // Count vowels in second half
        for (int i = mid; i < n; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                countB++;
            }
        }
        
        return countA == countB;
    }
}