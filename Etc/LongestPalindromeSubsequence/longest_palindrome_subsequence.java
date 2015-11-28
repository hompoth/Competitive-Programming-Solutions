import java.util.*;
class longest_palindrome_subsequence {
	static int ispalindrome(String s, int a, int b){
		for(int j = a, k = b; j <= k; ++j, --k)
			if(s.charAt(j)!=s.charAt(k)) return 0;
		return b-a+1;
	}
	static int longest_palindrome(String s){
		if(s.length() == 0) return 0;
		int max = 1;
		for(int i = 0; i < s.length(); ++i)
			for(int j = s.length()-1; j > i; --j)
				max=Math.max(ispalindrome(s,i,j), max);
		return max;
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(longest_palindrome(s));
	}
}
