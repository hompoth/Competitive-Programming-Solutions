import java.util.*;
class Tuple {
	int val, x1, x2, y1, y2;
	Tuple(int val, int x2, int y2, int x1, int y1){	this.val=val;this.x1=x1;this.x2=x2;this.y1=y1;this.y2=y2;}
	void print(){System.out.println("("+x1+", "+y1+") ("+x2+", "+y2+") "+val);}
}
class PotW_4_Lame {	
	static void updateMin(int[][] sumA, int[] minA, int[] minP, int M, int N, int i, int j){
		if(sumA[i][j]<minA[i]) minA[i]=sumA[i][minP[i]=j];
	}
	static void updateMax(int[][] sumA, int[] minA, int[] minP, int M, int N){
		for(int i = 0; i < M; ++i);

		//for(int j = 0; j < N; ++j)
	}
	static Tuple rectSum(int[][] a, int i, int j, int k, int l){
		return new Tuple(a[i][j]-((--k>=0)?a[k][j]:0)-((--l>=0)?a[i][l]:0)+((k>=0&&l>=0)?a[k][l]:0), i, j, k+1, l+1);
	}
	static Tuple sumRectangle(int[][] A, int M, int N){
		int[][] sumA = new int[M][N], sumA2 = new int[M][N];
		int[] minA = new int[M], minP = new int[M], sumA3 = new int[M];
		int minPos=0, maxPos=0, min=A[0][0], max=A[0][0];
		Tuple tmp, maxRect = new Tuple(A[0][0], 0, 0, 0, 0), sav;
		for(int j = 0; j < N; updateMax(sumA, minA, minP, M, N), min=max=A[0][j], minPos=maxPos=0, ++j){
			for(int i = 0, curStart=0; i < M; updateMin(sumA, minA, minP, M, N, i, j), ++i){
				sumA[i][j]=A[i][j]+((j>0)?sumA[i][j-1]:0);
				sumA2[i][j]=sumA[i][j]+((i>0)?sumA2[i-1][j]:0);
				sumA3[i]=A[i][j]+((i>0)?sumA3[i-1]:0);

				if(sumA3[i]>max){
					max = sumA3[i];
					minPos=curStart;
					maxPos= i;
				}
				else if (sumA3[i]<0){
					curStart=i+1;
					sumA3[i]=0;
				}
			}
			for(int i = 0; i < M; ++i){//minPos; i <= maxPos; ++i)
				if((tmp=rectSum(sumA2, maxPos, j, minPos, minP[i])).val>maxRect.val) maxRect=tmp;
				if((tmp=new Tuple(sumA2[i][j], i, j, 0, 0)).val>maxRect.val) maxRect=tmp;
				//maxRect.print();
			}
		}

		//print(sumA);
		//System.out.println();
		//print(sumA2);
		
		return maxRect;
	}	
	static void print(int[][] arr){
		int M=arr.length, N=arr[0].length;
		for(int i = 0; i < M; ++i){
			for(int j = 0; j < N; ++j){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

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

