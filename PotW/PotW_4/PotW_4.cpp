#include <iostream>
using namespace std;
void findBest(int **arr, int M, int N){

}

int main(){
	//const int M = [](int t){ return cin>>t, t;};
	//cin >> M >> N;
	const int M=5, N=5;
	int **arr = new int[M][N];
	for(int i = 0; i < M; ++i)
		for(int j = 0; j < N; ++j)
			cin >> arr[i][j];
	findBest(arr, M, N);
	//delete arr;
	return 0;
}
