import java.util.Stack;
class Solution {
    boolean isLeft(char c){
        if(c == '{' || c == '(' || c == '[') return true;
        return false;
    }
    boolean isSame(char c, char c2){
        if(c == '{' && c2 == '}' ||
           c == '(' && c2 == ')' ||
           c == '[' && c2 == ']') return true;
           return false;
    }
    public int solution(String S) {
        Stack<Character> s = new Stack<Character>();
        char tmp;
        for(int i = 0; i < S.length(); ++i){
            tmp = S.charAt(i);
            if(isLeft(tmp)) s.push(tmp);
            else if(s.empty()) return 0;
            else if(isSame(s.peek(), tmp)) s.pop();
            else return 0;
        }
        return (s.empty())?1:0;
    }
}
