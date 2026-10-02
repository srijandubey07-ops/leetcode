class Solution {

    public int bs(int[] arr, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            else if (arr[mid] > target) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {

        // find pivot
        int n = nums.length;

        if (n == 1) {
            if (nums[0] == target) return 0;
            return -1;
        }

        if (n == 2) {
            for (int i = 0; i < n; i++) {
                if (nums[i] == target) return i;
            }
            return -1;
        }

        int lo = 1;
        int hi = n - 2;
        int pivot = -1;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            // mid is the largest element
            if (nums[mid] > nums[mid - 1] &&
                nums[mid] > nums[mid + 1]) {

                pivot = mid;
                break;
            }

            // mid is the smallest element
            else if (nums[mid] < nums[mid - 1] &&
                     nums[mid] < nums[mid + 1]) {

                pivot = mid - 1;
                break;
            }

            // increasing part
            else if (nums[mid] > nums[mid - 1] &&
                     nums[mid] < nums[mid + 1]) {

                if (nums[mid] > nums[n - 1]) {
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1;
                }
            }
        }

        // Array was not rotated
        if (pivot == -1) {
            return bs(nums, 0, n - 1, target);
        }

        // Search in left part
        int left = bs(nums, 0, pivot, target);

        if (left != -1) {
            return left;
        }

        // Search in right part
        int right = bs(nums, pivot + 1, n - 1, target);

        return right;
    }
}