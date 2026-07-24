class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        
        // Fill the initial row with 1s (only 1 way to move horizontally in the first row)
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }

        // Iterate through each row starting from row 1
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1]; // dp[j] is top, dp[j-1] is left
            }
        }

        return dp[n - 1];
    }
}