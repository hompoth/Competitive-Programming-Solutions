// bfs n time
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class Pair {
	int i, j;
	Pair(int i, int j){this.i = i; this.j = j;}
}
class rings2 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt(), x = sc.nextInt(), rings = 0;
		boolean[][] bool_arr = new boolean[y][x];
		boolean[][] checked = new boolean[y][x];
		int[][] arr = new int[y][x];
		Queue<Pair> q = new LinkedList<Pair>();
		String str;
		for(int i = 0; i < y; ++i){
			str = sc.next();
			for(int j = 0; j < x; ++j) {
				if(str.charAt(j)=='T') bool_arr[i][j] = true;
				if(str.charAt(j)=='.'||i==0||j==0||i==y-1||j==x-1) q.add(new Pair(i, j));
			}
		}
		while(q.peek()!=null){
			Pair p = q.remove();
			int i = p.i, j = p.j;
			if(checked[i][j]) continue;
			checked[i][j] = true;
			if(i>0 && !checked[i-1][j]) q.add(new Pair(i-1, j));
			if(j>0 && !checked[i][j-1]) q.add(new Pair(i, j-1));
			if(i<y-1 && !checked[i+1][j]) q.add(new Pair(i+1, j));
			if(j<x-1 && !checked[i][j+1]) q.add(new Pair(i, j+1));
			if(bool_arr[i][j]){
				int min = Integer.MAX_VALUE;
				if(i>0 && checked[i-1][j]) min = Math.min(min, arr[i-1][j]);
				else if(i==0) min = 0;
				if(j>0 && checked[i][j-1]) min = Math.min(min, arr[i][j-1]);
				else if(j==0) min = 0;
				if(i<y-1 && checked[i+1][j]) min = Math.min(min, arr[i+1][j]);
				else if(i==y-1) min = 0;
				if(j<x-1 && checked[i][j+1]) min = Math.min(min, arr[i][j+1]);
				else if(j==x-1) min = 0;
				if(min == Integer.MAX_VALUE) min = 0;
				arr[i][j] = min+1;
				rings = Math.max(arr[i][j], rings);
			}
		}
		for(int i = 0; i < y; ++i){
			for(int j = 0; j < x; ++j){
				if(rings < 10){
					if(arr[i][j] == 0) System.out.print("..");
					else System.out.print("."+arr[i][j]);
				}
				else {
					if(arr[i][j] == 0) System.out.print("...");
					else if(arr[i][j] < 10) System.out.print(".."+arr[i][j]);
					else System.out.print("."+arr[i][j]);
				}
			}
			System.out.println();
		}
	}
}
