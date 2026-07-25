class Solution {

    static int findPivot(int[] nums){
        int s = 0;
        int e = nums.length - 1;

        while(s < e){
            int mid = s + (e - s) / 2;

            if(nums[mid] > nums[e]){
                s = mid + 1;
            }else{
                e = mid;
            }
        }

        return s;
    }

    static int BS(int[] nums, int s, int e, int target){
        while(s <= e){
            int mid = s + (e - s) / 2;

            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                s = mid + 1;
            else
                e = mid - 1;
        }

        return -1;
    }

    public int search(int[] nums, int target) {

        int n = nums.length;
        int pivot = findPivot(nums);

        // Array is not rotated
        if(pivot == 0){
            return BS(nums,0,n-1,target);
        }

        // Left sorted part
        if(target >= nums[0] && target <= nums[pivot-1]){
            return BS(nums,0,pivot-1,target);
        }

        // Right sorted part
        return BS(nums,pivot,n-1,target);
    }
}