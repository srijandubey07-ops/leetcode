class Solution {
    public int mySqrt(int x) {
        int s = 1;
        int hi = x ;
        int ans = 0;
        if(x==0) return 0;
        while(s<=hi){
            int mid = s + (hi-s)/2;
            if(mid == x/mid) {
            return mid;
            }
            else if(mid> x/mid) { 
                 hi = mid -1;
            }
            else {
                ans = mid;
                 s = mid + 1;
            }
        }
        return ans;
    }
}