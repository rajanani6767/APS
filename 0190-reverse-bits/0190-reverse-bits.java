public class Solution {
    // Reverse bits of a 32-bit unsigned integer
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;          // shift result left
            result |= (n & 1);     // add current LSB of n
            n >>= 1;               // shift n right
        }
        return result;
    }
}
