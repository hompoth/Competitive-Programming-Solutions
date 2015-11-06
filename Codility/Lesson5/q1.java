class Solution {
    public int solution(String S) {
        int count = 0;
        for(int i = 0; i < S.length(); ++i){
            if(S.charAt(i) == '(') ++count;
            else --count;
            if(count < 0) return 0;
        }
        return (count == 0)?1:0;
    }
}
