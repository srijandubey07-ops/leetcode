class Solution {
    public int[] searchRange(int[] arr, int target) {

        int ans[] = {-1, -1};

        // first check element is present
        int n = arr.length;
        int lo = 0, hi = n - 1;

        boolean flag = false; // false means not present

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (arr[mid] == target) {
                flag = true;
                break;
            }
            else if (arr[mid] > target) {
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }

        if (flag == false)
            return ans;

        // now find the lower bound
        lo = 0;
        hi = n - 1;

        int lb = n;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (arr[mid] >= target) {
                lb = Math.min(lb, mid);
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }

        ans[0] = lb;

        // now find the upper bound
        lo = 0;
        hi = n - 1;

        int ub = n;

        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (arr[mid] > target) {
                ub = Math.min(ub, mid);
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }

        ans[1] = ub - 1;

        return ans;
    }
}