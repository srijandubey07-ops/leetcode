class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0 ;
        // variable to store the longest sequence length found
        int longest = 1;
        // hashset to store the unique element 
        Set<Integer> st = new HashSet<>();
        // add all the element to the set to remove the dupilcate
        for(int i = 0; i<n; i++){
            st.add(nums[i]);
        }
        /* loop through each element in the set to find the starting point of the longestConsecutive sequence
        */
        for(int it : st ){
            // if there is no number before it , it is the starting of the sequence
            if(! st.contains(it-1)){
                // start the cout for this sequence
                int cnt  = 1;
                // store the current element 
                int x = it;
            // keep chacking for the next consecutive number
            while(st.contains(x+1)){
                // move to the next number in sequence
                x = x+1;
                // increment the length of the current sequence
                cnt = cnt +1;
            }
            longest = Math.max(longest,cnt);
            }
        } 
        return longest;
    }
}