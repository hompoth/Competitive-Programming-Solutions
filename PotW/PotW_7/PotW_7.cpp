#include <iostream>
#include <vector>
using namespace std;

unsigned int get_hash(unsigned int x, int n) {
    x = ((x >> 16) ^ x) * 0x45d9f3b;
    x = ((x >> 16) ^ x) * 0x45d9f3b;
    x = ((x >> 16) ^ x);
    return x%n;
}
// didn't add a linked list at each array position to save space but it increased collision
// didn't add more memory to array to save space but it increased collision
int main() {
	int n, i, j;
	cin >> n;
	unsigned int tmp, tmp_hash, array[n];
	vector<bool> bits(n), avail(n); // dynamic bitset
	for(i = 0; i < n; ++i){
		cin >> tmp;
		tmp_hash = get_hash(tmp, n);
		if(!avail[tmp_hash])
			array[tmp_hash] = tmp;
		else {
			for(j = 1;; ++j){
				if(avail[tmp_hash]) break;
				else if(array[tmp_hash] == tmp) break;
				tmp_hash=(tmp_hash+1)%n;
			}
			if(array[tmp_hash] == tmp) bits[tmp_hash] = true;
			else array[tmp_hash] = tmp;
		}
		avail[tmp_hash] = true;
	}
	for(i = 0; i < n; ++i)
		if(bits.at(i)) cout << array[i] << endl;
	return 0;
}
