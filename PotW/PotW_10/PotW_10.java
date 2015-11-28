// Decrypts the lowercase "Ciavaglia Cipher"
import java.util.Scanner;
class PotW_10 {
	static String decrypt(String s){
		String new_Str = "";
		int last = 5, letter;
		for(int i = 0; i < s.length(); ++i){
			letter=(char)((26-last+s.charAt(i)-'a')%26);
			new_Str+=(char)(letter+'a');
			last=(last+letter)%26;
		}
		return new_Str;
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println(decrypt(s));
	}
}
