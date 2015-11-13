import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
class squawk {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<Integer>(), q2 = new LinkedList<Integer>();
		int n = sc.nextInt(), m = sc.nextInt(), s = sc.nextInt(), t = sc.nextInt();
		long cur_total = 0;
		List<Set<Integer>> adj = new ArrayList<Set<Integer>>();
		for(int i = 0; i < n; ++i) adj.add(new HashSet<Integer>());
		long[] sum_arr = new long[n], new_sum_arr = new long[n];
		boolean[] visited = new boolean[n];
		for(int i = 0; i < m; ++i){
			int a = sc.nextInt(), b = sc.nextInt();
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		q.add(s);
		sum_arr[s] = 1;
		for(int i = 0; i < t; ++i){
			cur_total = 0;
			while(q.peek()!=null){
				int node = q.remove();
				if(!visited[node])
					for(int child : adj.get(node)){
						cur_total+=sum_arr[node];
						new_sum_arr[child]+=sum_arr[node];
						q2.add(child);
					}
				visited[node] = true;
			}
			q = new LinkedList<Integer>(q2);
			q2.clear();
			for(int j = 0; j < n; ++j) sum_arr[j] = new_sum_arr[j];
			for(int j = 0; j < n; ++j) new_sum_arr[j] = 0;
			for(int j = 0; j < n; ++j) visited[j] = false;
		}
		System.out.println(cur_total);
	}
}
