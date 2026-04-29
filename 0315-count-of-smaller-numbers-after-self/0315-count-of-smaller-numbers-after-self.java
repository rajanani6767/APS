import java.util.*;

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n];
        Arrays.fill(result, 0);   // ✅ initialize all counts to 0
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) indexes[i] = i;

        mergeSort(nums, indexes, result, 0, n - 1);
        return Arrays.asList(result);
    }

    private void mergeSort(int[] nums, int[] indexes, Integer[] result, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, indexes, result, left, mid);
        mergeSort(nums, indexes, result, mid + 1, right);
        merge(nums, indexes, result, left, mid, right);
    }

    private void merge(int[] nums, int[] indexes, Integer[] result, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (nums[indexes[j]] < nums[indexes[i]]) {
                temp[k++] = indexes[j++];
                rightCount++;
            } else {
                result[indexes[i]] += rightCount;
                temp[k++] = indexes[i++];
            }
        }

        while (i <= mid) {
            result[indexes[i]] += rightCount;
            temp[k++] = indexes[i++];
        }

        while (j <= right) {
            temp[k++] = indexes[j++];
        }

        System.arraycopy(temp, 0, indexes, left, temp.length);
    }
}
