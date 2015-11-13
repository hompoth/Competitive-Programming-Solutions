// 194 ms solution
class Node {
    Node left, right;
    char c;
    Node(char c){this.c=c; this.left=null; this.right=null;}
    boolean addC(char c){
        Node cur = this;
        while(true){
            if(c<cur.c){
                if(cur.left==null) {
                    cur.left = new Node(c);
                    return true;
                }
                else cur = cur.left;
            }
            else if(c>cur.c){
                if(cur.right==null) {
                    cur.right = new Node(c);
                    return true;
                }
                else cur = cur.right;
            }
            else return false;
        }
    }
}
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<1) return 0;
        Node n = new Node(s.charAt(0));
        int start = 0, cursize = 1, max = 0;
        for(int i = 0; i < s.length(); ++i){
            if(n.addC(s.charAt(i))) ++cursize;
            else{
                for(int j = start; j < i; ++j){
                    if(s.charAt(j)==s.charAt(i)){
                        start=j+1;
                        max=Math.max(max, cursize);
                        cursize=i-start+1;
                        n = new Node(s.charAt(i));
                        for(int k = start; k <= i; ++k) n.addC(s.charAt(k));
                        break;
                    }
                }
            }
        }
        max=Math.max(max, cursize);
        return max;
    }
}
