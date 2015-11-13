public class PotW_9 {
	static boolean isPrimutation(boolean[] isPrime, int a, int b, int c) {
		if(isPrime[a] && isPrime[b] && isPrime[c]) {
			int[] countSorta = new int[10],
				countSortb = new int[10],
				countSortc = new int[10];
			for(int i = 0; i < 4; ++i, a/=10, b/=10, c/=10){
				++countSorta[a%10];
				++countSortb[b%10];
				++countSortc[c%10];
			}
			for(int i = 0; i < 10; ++i)
				if(countSorta[i] != countSortb[i] || countSortb[i] != countSortc[i])
					return false;
			return true;
		}
		else return false;
	}
	public static void main(String[] args) { 
		int N = 10000;
		boolean[] isPrime = new boolean[N + 1];
		for (int i = 2; i <= N; i++)
			isPrime[i] = true;

		for (int i = 2; i*i <= N; i++)
			if (isPrime[i])
				for (int j = i; i*j <= N; j++)
					isPrime[i*j] = false;

		for (int i = 7660; i <= N; i++)
			if(isPrimutation(isPrime, i, i-3330, i-6660))
				System.out.println(i+" "+(i-3330)+" "+(i-6660));
	}
}
