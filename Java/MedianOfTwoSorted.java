// 4. Median of Two Sorted Arrays

// https://leetcode.com/problems/median-of-two-sorted-arrays/

public class MedianOfTwoSorted {
    
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;

            if(n1 > n2)
                return findMedianSortedArrays(nums2, nums1);

            int low = 0, high = n1;
            while(low <= high) {
                int mid1 = (low + high) / 2;
                int mid2 = ((n1 + n2 + 1) / 2) - mid1;

                int min1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];
                int max1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
                int min2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];
                int max2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];

                // Check for Median Cases
                if(max1 <= min2 && max2 <= min1) {
                    // Check for EVEN number of elements
                    if((n1 + n2) % 2 == 0)
                        return (double) (Math.max(max1, max2) + Math.min(min1, min2)) / 2;
                    // ODD number of elements
                    else
                        return Math.max(max1, max2);
                }

                // Check for Corner cases
                else if(max1 > min2)
                    high = mid1 - 1;
                else
                    low = mid1 + 1;
            }

            return -1;
        }
    }
}