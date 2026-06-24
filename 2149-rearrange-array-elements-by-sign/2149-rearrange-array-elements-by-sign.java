class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        // create ans array size of n
        int [] ans = new int[n];
        // postive elemeng at odd place and negative element At even place
        int negIndex = 1 , posIndex = 0;
        // traverse the array
        for(int i =0 ; i<n; i++){
            if(nums[i]<0){
                ans[negIndex] = nums[i];
                negIndex+=2;

            }
            else {
                ans[posIndex] = nums[i];
                posIndex+=2;
            }
        }
        return ans;
    }
}