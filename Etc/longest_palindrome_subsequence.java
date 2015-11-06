import java.util.*;
class longest_palindrome_subsequence {
	static void longest_palindrome(String s){
		int max = 0, cur = 0;
		char tmp;
		Stack<Character> stack = new Scanner();
		for(int i = 0; i < s.length(); ++i){
			tmp = s.charAt(i);
			if(stack.peek() == tmp){
				stack.pop();
				++cur;
			}
			else {
				stack.push(tmp);
			}
			// abcaacbbc

		}
		return max;
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(longest_palindrome(s));
	}
}
