#include <iostream>
#include <string>
using namespace std;
int matchSimilar(unsigned int a, unsigned int b){
	unsigned int diff = a^b, valueOfSame;
	diff=(diff&0x55555555) + ((diff&0xAAAAAAAA)>>1);
	diff=(diff&0x33333333) + ((diff&0xCCCCCCCC)>>2);
	diff=(diff&0x0F0F0F0F) + ((diff&0xF0F0F0F0)>>4);
	diff=(diff&0x00FF00FF) + ((diff&0xFF00FF00)>>8);
	diff=(diff&0x0000FFFF) + ((diff&0xFFFF0000)>>16);
	//for(unsigned int i = 1; i != 0; i<<=1){
	//	if((diff&i) == 0)
	//		++valueOfSame;
	//}
	return diff;
}
int main(){
	int N;
	cin >> N;
	if(N < 2) return 0;
	string str[N];
	unsigned int dat[N]; 
	int cur, min = 32, max = 0;
	pair<int,int> minIndex, maxIndex;
	
	for(int c = 0; c < N; ++c){
		cin >> str[c] >> dat[c];
	}

	for(int i = 0; i < N; ++i){
		for(int j = i+1; j < N; ++j){
			cur = matchSimilar(dat[i],dat[j]);		
			//cout << cur << endl;
			if(cur <= min) {
				min = cur;
				minIndex.first = i;
				minIndex.second = j;
			}
			if(cur >= max) {
				max = cur;
				maxIndex.first = i;
				maxIndex.second = j;
			}
		}
	}
	//cout << max << " " << min << endl;
	cout << str[maxIndex.first] << " " << str[maxIndex.second] << endl;
	cout << str[minIndex.first] << " " << str[minIndex.second] << endl;
	return 0;
}
