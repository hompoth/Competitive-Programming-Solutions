// 7 ms solution
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0, cursize=0, start=0;
        for(int i = 0; i < s.length(); ++i){
            ++cursize;
            for(int j = start; j < i; ++j){
                if(s.charAt(j)==s.charAt(i)){
                    max=Math.max(max,cursize-1);
                    cursize=i-j;
                    start=j+1;
                    break;
                }
            }
        }
        max=Math.max(max, cursize);
        return max;
    }
}
