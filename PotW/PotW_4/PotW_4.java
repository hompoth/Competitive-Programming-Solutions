import java.util.*;
class Tuple {
	int val, x1, x2, y1, y2;
	Tuple(int val, int x2, int y2, int x1, int y1){	this.val=val;this.x1=x1;this.x2=x2;this.y1=y1;this.y2=y2;}
	void print(){System.out.println("("+x1+", "+y1+") ("+x2+", "+y2+") "+val);}
}
class PotW_4 {	
	static Tuple rectSum(int[][] a, int i, int j, int k, int l){
		return new Tuple(a[i][j]-((--k>=0)?a[k][j]:0)-((--l>=0)?a[i][l]:0)+((k>=0&&l>=0)?a[k][l]:0), i, j, k+1, l+1);
	}
	static Tuple sumRectangle(int[][] arr, int M, int N){
		int[][] sumArray = new int[M][N];
		Tuple tmp, max = new Tuple(arr[0][0], 0, 0, 0, 0);
		for(int i = 0; i < M; ++i)
			for(int j = 0, sum = 0; j < N; ++j)
				for(int k=0,c=sumArray[i][j]+=(sum+=arr[i][j])+((i>0)?sumArray[i-1][j]:0);k<=i;++k)
					for(int l = 0; l <= j; ++l)
						if((tmp=rectSum(sumArray,i,j,k,l)).val>max.val) max=tmp;
		return max;
	}
	public static void  main(String args[]){
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(), N = sc.nextInt();
		int[][] arr = new int[M][N];
		for(int i = 0; i < M; ++i)
			for(int j = 0; j < N; ++j)
				arr[i][j]=sc.nextInt();
		sumRectangle(arr, M, N).print();
	}
}

