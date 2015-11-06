class TestCases {
	public static void main(String args[]){
		//PotW_4 p1 = new PotW_4();
		//PotW_4_Lame p2 = new PotW_4_Lame();
		for(int M = 1; M < 10; ++M)
			for(int N = 1; N < 10; ++N){
				int[][] arr = new int[M][N];
				for(int i = 0; i < M; ++i)
					for(int j = 0; j < N; ++j)
						arr[i][j]=(new java.util.Random()).nextInt();

				PotW_4.sumRectangle(arr, M, N).print();
				PotW_4_Lame.sumRectangle(arr, M, N).print();
				System.out.println();
			}
	}
}
