class Solution {
    public int findPeakElement(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // Peak is on the right
                low = mid + 1;
            } else {
                // Peak is at mid or on the left
                high = mid;
            }
        }

        return low;
    }
}