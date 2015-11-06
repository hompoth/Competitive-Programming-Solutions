#include <set>
#include <vector>
#include <algorithm>
#include <unordered_map>
#include <iostream>
#include <string>
using namespace std;

struct compare {
	std::string c;
	compare(std::string s): c(s) {};
	bool operator()(pair<string, int> p) {
		return p.first == c;
	}
};

void fillDistance(vector<pair<string, int> > &v, unordered_map<string, set<string> > &m, string s, int d){
    	set<string> str_set = m[s];
	if (find_if(v.begin(), v.end(), compare(s))== v.end()) v.push_back({s, d});
	for (auto i : str_set) {
		if (find_if(v.begin(), v.end(), compare(i))== v.end()) {
			v.push_back({i, d+1});
			fillDistance(v, m, i, d+1);
		}
    	}
	m.erase(s);
}

int main(){
        int N;
        string str1, str2;
        unordered_map<string, set<string> > m;
	vector<pair<string, int> > v;
        cin >> N;
        while(N--){
                cin >> str1 >> str2;
                if (m.count(str1)) {
                        //m.emplace(str1, set<string>());
                        m[str1].insert(str2);
                }
                else m[str1].insert(str2);
                if (m.count(str2)) {
                        //m.emplace(str2, set<string>());
                        m[str2].insert(str1);
                }
                else m[str2].insert(str1);
        }
        fillDistance(v, m, "Quinn", 0);
	for(auto i : m) {
		v.push_back({i.first, -1});
	}
	sort(v.begin(), v.end(), [](const pair<string, int> &a, const pair<string, int> &b) -> bool {return (a.first.compare(b.first)<0);});
	for(pair<string, int> i : v){
		int val = i.second;
		if(val == -1) cout << i.first << " " << "uncool" << endl;
		else cout << i.first << " " << val << endl;
	}
        return 0;
}

