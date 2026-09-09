class Solution {
    public void moveZeroes(int[] arr) {
        int n = arr.length;
        int noz = 0; 
        for(int ele : arr){
            if(ele==0) noz++;
        }
        for(int x = 0; x<noz; x++){ // noz passes
          for(int i =0; i<n-x-1; i++){
            if(arr[i]==0){
                // swap 
                int temp = arr[i];
                arr[i]= arr[i+1];
                arr[i+1] = temp;
            }
          }
        }
    }
}