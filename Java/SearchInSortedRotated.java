// 33. Search in Rotated Sorted Array
// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInSortedRotated {
    class Solution {
        public int search(int[] nums, int target) {
            int low = 0, high = nums.length - 1;
            while(low <= high) {
                int mid = (low + high) / 2;

                if(nums[mid] == target)
                    return mid;

                // LHS Sorted
                else if(nums[low] <= nums[mid]) {
                    if(target >= nums[low] && target <= nums[mid])
                        high = mid - 1;
                    else
                        low = mid + 1;
                }

                // RHS Sorted
                else {
                    if(target >= nums[mid] && target <= nums[high])
                        low = mid + 1;
                    else
                        high = mid - 1;
                }
            }

            return -1;
        }
    }
}