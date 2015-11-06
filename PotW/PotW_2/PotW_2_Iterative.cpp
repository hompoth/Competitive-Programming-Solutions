#include <set>
#include <utility>
#include <vector>
#include <algorithm>
#include <unordered_map>
#include <iostream>
#include <string>
using namespace std;
using pssb = pair<set<string>, bool>;
using psi = pair<string, int>;

void fillDistance(vector<psi> &v, set<string> &name_set, unordered_map<string, pssb > m){
	int &&d = 0;
	string &&s = "Quinn";
	m[s].second = true;
	name_set.erase(s);
	v.push_back({s, d});
	cout << s << endl;
	set<string> last_set, total_set, tmp_set;
	last_set = m[s].first;
	// Works like BFS; 
	// Quinn (0) -> Quinn's Friends (1) -> Quinn's Friends of Friends (2) -> etc.
	for(++d;!last_set.empty(); ++d){
		for(auto &&str : last_set){
			if(m[str].second) continue;
			m[str].second = true;
			name_set.erase(str);
			v.push_back({str, d});
			tmp_set.clear();
			for(string new_str : m[str].first) tmp_set.insert(new_str);
			total_set.insert(tmp_set.begin(), tmp_set.end());
		}
		last_set = move(total_set);
	}

}

int main(){
        int N;
        string str1, str2;
        unordered_map<string, pssb> m;
	vector<psi> v;
	set<string> name_set;
        
	// fill a map for constant lookup across a graph
	cin >> N;
        while(N--){
                cin >> str1 >> str2;
                m[str1].first.insert(str2);
                m[str2].first.insert(str1);
		name_set.insert(str1);
		name_set.insert(str2);
        }
        fillDistance(v, name_set, m);
	
	// push all uncool people
	for(auto &i : name_set) v.push_back({i, -1});

	sort(v.begin(), v.end());
	for(auto &i : v)
		if(i.second == -1) cout << i.first << " " << "uncool" << endl;
		else cout << i.first << " " << i.second << endl;
}

