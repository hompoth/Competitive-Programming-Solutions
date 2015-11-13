import java.util.*;
class Pair {
	int x, y, x2, y2;
	boolean t;
	Pair(int x, int y, boolean t){this.t = t; this.x=x; this.y=y;this.x2=x;this.y2=y;}
}
class deletethis {
	static int lcs_with_offset(int[][] arr, int[] xpos_array, int[] ypos_array, int N, int M){
		int[][] sum_arr = new int[N][M];
		int min = Integer.MAX_VALUE, tmp;
		for(int i = 0; i < N; ++i){
			for(int j = 0; j < M; ++j){
				sum_arr[i][j] = arr[i][j];
				if(i>=1) sum_arr[i][j]+= sum_arr[i-1][j];
				if(j>=1) sum_arr[i][j]+= sum_arr[i][j-1];
				if(i>=1&&j>=1) sum_arr[i][j]-= sum_arr[i-1][j-1];
			}
		}
		for(int k = 0; k < N; ++k){
			for(int l = 0; l < M; ++l){
				for(int i = k; i < N; ++i){
					for(int j = l; j < M; ++j){
						// Added an 8x14 offset for the 9x15 sized pixels
						int offset_y = 0, offset_x = 0;
						for(int m = i+1; m < N; ++m) 
							if(ypos_array[m] <= ypos_array[i]+14) ++offset_y;
							else break;
						for(int n = j+1; n < M; ++n) 
							if(xpos_array[n] <= xpos_array[j]+8) ++offset_x;
							else break;
						tmp = sum_arr[i+offset_y][j+offset_x];
						if(k>=1) tmp-= sum_arr[k-1+offset_y][j+offset_x];
						if(l>=1) tmp-= sum_arr[i+offset_y][l-1+offset_x];
						if(k>=1&&l>=1) tmp+= sum_arr[k-1+offset_y][l-1+offset_x];
						min = Math.min(min, tmp);
					}
				}
			}
		}
		return min;
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		sc.nextInt();
		int n = sc.nextInt(), m = sc.nextInt(), M, N, k = 0, c, last, tmp;
		int[] xpos_array = new int[n+m], ypos_array = new int[n+m];
		Pair[] pair_arr = new Pair[n+m];
		for(int i = 0; i < n; ++i) 
			pair_arr[k++] = new Pair(sc.nextInt(), sc.nextInt(), true);
		for(int i = 0; i < m; ++i) 
			pair_arr[k++] = new Pair(sc.nextInt(), sc.nextInt(), false);
		Arrays.sort(pair_arr, new Comparator<Pair>() {
			public int compare(Pair o1, Pair o2) {
				return o1.x - o2.x;
			}
		});
		c = -1; last = -1;
		for(int i = 0; i < n+m; ++i){
			tmp = pair_arr[i].x;
			if(pair_arr[i].x == last) pair_arr[i].x = c;
			else pair_arr[i].x = ++c;
			last = tmp;
			xpos_array[c] = pair_arr[i].x2;
		}
		M = c+1;
		Arrays.sort(pair_arr, new Comparator<Pair>() {
			public int compare(Pair o1, Pair o2) {
				return o1.y - o2.y;
			}
		});
		c = -1; last = -1;
		for(int i = 0; i < n+m; ++i){
			tmp = pair_arr[i].y;
			if(pair_arr[i].y == last) pair_arr[i].y = c;
			else pair_arr[i].y = ++c;
			last = tmp;
			ypos_array[c] = pair_arr[i].y2;
		}
		N = c+1;
		int[][] simple_arr = new int[N][M];
		for(int i = 0; i < n+m; ++i) 
			simple_arr[pair_arr[i].y][pair_arr[i].x] = (pair_arr[i].t)?-1:1;
		System.out.println((n+lcs_with_offset(simple_arr, xpos_array, ypos_array, N, M)));
	}

}
