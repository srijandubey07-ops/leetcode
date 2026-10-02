class Solution {

    public int search(int[] nums, int target) {

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[lo] <= nums[mid]) {

                // Target lies in left sorted half
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                }
                // Target lies in right half
                else {
                    lo = mid + 1;
                }
            }

            // Right half is sorted
            else {

                // Target lies in right sorted half
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                }
                // Target lies in left half
                else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }
}