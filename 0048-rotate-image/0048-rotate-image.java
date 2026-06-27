/* 
# optimal approch algo 
To rotate a matrix 90 degrees clockwise in-place (without using extra space), we use two key matrix operations:
Step 1: Transpose the matrix: swap elements across the diagonal. This converts rows into columns.
Step 2: Reverse each row: this turns the new columns into the final rotated rows.

This works because:
Transposing moves elements from (i, j) to (j, i), effectively rotating across the diagonal.
Reversing the rows repositions the elements in each row, finalizing the clockwise rotation.
Get the size of the square matrix (number of rows or columns).
Start the first phase: Transpose the matrix
For each row starting from the top to bottom:
For each column starting from the diagonal element (excluding already visited elements):
Swap the current element with the element that is diagonally opposite across the main diagonal.
This effectively flips the matrix over its top-left to bottom-right diagonal, converting rows into columns.
Move to the second phase: Reverse each row
For every row in the matrix:
Reverse the order of the elements in that row (first element becomes last, second becomes second last, and so on).
This realigns the columns to their correct position for the clockwise rotation.
Once both phases are done, the matrix will have been rotated 90 degrees clockwise in-place.
*/




class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // swap [i][j] -> [j][i]
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
        }
    }
// reverse each row
for(int i = 0 ; i<n; i++){
    int left = 0 , right = n-1;
    while(left<right){
        int temp = matrix[i][left];
        matrix[i][left] = matrix[i][right];
        matrix[i][right] = temp;
        left++;
        right--;
    }
}
    }
}