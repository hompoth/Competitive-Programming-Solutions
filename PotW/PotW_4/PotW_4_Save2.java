import java.util.*;
class PotW_4 {
	static int[][] sumRectangle(int[][] arr){
		int M=arr.length, N=arr[0].length, max=arr[0][0], tmp, min;
		int[][] numArray = new int[M][N];
		int[] minArray = new int[N], minPos = new int[N];;
		for(int j = 0; j < N; ++j)
			minArray[j]=arr[0][j];
		for(int i = 0; i < M; ++i){
			min=arr[i][0]+((i>0)?numArray[i-1][0]:0);
			for(int j = 0, k=0, sum=0; j < N; ++j){
				sum+=arr[i][j];
				numArray[i][j]+=sum;
				if(i>0) numArray[i][j]+=numArray[i-1][j];
	
				if(i==0) minArray[j]=numArray[i][j];
				if(i==minPos[j]) tmp=numArray[i][j]-numArray[i][k];
				else if(j==k) tmp=numArray[i][j]-numArray[minPos[j]][j];
				else tmp=numArray[i][j]-min-minArray[j]+numArray[minPos[j]][k];
				System.out.println(tmp+" "+min+" "+minArray[j]+" "+numArray[minPos[j]][k]+" : "+i+" "+j+" "+k+" "+minPos[j]);
				if(tmp>max) max=tmp;
				if(numArray[i][j]>max) max=numArray[i][j];
				if(min>numArray[i][j]) min=numArray[i][k=j];
				if(minArray[j]>numArray[i][j]) minArray[j]=numArray[minPos[j]=i][j];
			}
		}
		System.out.println("\n"+max+"\n");
		return numArray;
	}
	static void bestRectangle(int[][] arr){
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
		bestRectangle(arr);
		System.out.println();
		bestRectangle(sumRectangle(arr));
	}
}

