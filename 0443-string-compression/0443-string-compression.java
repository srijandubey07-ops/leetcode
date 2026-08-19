class Solution {
    public int compress(char[] chars) {
        StringBuilder  ans = new StringBuilder("");
        int i =0 , j=0;
        while(j<chars.length){
            if(chars[i]==chars[j]) j++;
            else{
                ans.append(chars[i]);
                int len = j-i;
                if(len>1) ans.append(len);
                i=j;
            }
        }
        ans.append(chars[i]);
        int len = j-i;
        if(len>1) ans.append(len);
        for(i=0; i<ans.length(); i++){
            chars[i] = ans.charAt(i);
        }
        return ans.length();
    }
}