import java.util.Stack;
class Solution {
    public int solution(int[] H) {
        int count = 0, tmp;
        Stack<Integer> s = new Stack<Integer>();
        s.add(0);
        for(int i = 0; i < H.length; ++i){
            if((tmp=s.peek()) != 0 && tmp > H[i]){
                while(s.peek() > H[i]){
                    s.pop();
                    ++count;
                }
            }
            if((tmp=s.peek()) == 0 || tmp != H[i])
                s.add(H[i]);
        }
        while(s.peek()!=0){
            ++count;
            s.pop();
        }
        return count;
    }
}
