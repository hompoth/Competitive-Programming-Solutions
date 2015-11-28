// Looks for the smallest subsequence such that:
// 	All numbers from 1 to K are included
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
class sks {
	public static void main (String args[]){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int[] arr = new int[s.length()];
		for(int i = 0; i < s.length(); ++i)
			arr[i] = s.charAt(i)-48;
		int k = sc.nextInt();
		System.out.println(smallestK(arr, k));
	}
	public static String smallestK(int[] s, int k){
		int[] check = new int[k];
		int total = 0;
		int start=0, end=0, mins=-1, mine=-1;
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < s.length; ++i){
			if(s[i]<=k){
				if(total == 0) start = i;
				q.add(i);
				if(check[s[i]-1] == 0) ++total;
				++check[s[i]-1];
			}
			if(total == k){
				end = i;
				while(q.peek()!=null && total == k){
					if(mins==-1 || (end-start)<(mine-mins)){
						mins = start;
						mine = end;
					}
					int index = q.remove();
					--check[s[index]-1];
					if(check[s[index]-1] == 0) --total;
					else if(q.peek()!=null) start = q.peek();
				}
				if(q.peek()==null) start = i; 
			}
		}
		return mins+" "+mine;
	}
}
