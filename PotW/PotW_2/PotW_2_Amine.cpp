#include <iostream>
#include <unordered_set>
#include <utility>
#include <string>
#include <vector>
#include <algorithm> 

using namespace std;

void add2FriendsList(string Q, vector< pair<string,string> > friendships, unordered_set<string>& list, int QDist, vector<pair<string,int> >& scores) {
	for(auto it : friendships) {
		if((it.first) == Q && list.find(it.second)!=list.end()) {
			scores.push_back({it.second, QDist});
			list.erase(it.second);
		}
		else if((it.second) == Q && list.find(it.first)!=list.end()) {
			scores.push_back({it.first, QDist});
			list.erase(it.first);
		}
	}
}
void theQuinnThang(vector< pair<string, string> > friendships, int n) {
	unordered_set<string> list;
	
	for(auto & it : friendships) {
		list.insert(it.first);
		list.insert(it.second);
	}

	vector<pair<string,int> > scoresCool;
	vector<pair<string,string> > finalScore;
	scoresCool.push_back({"Quinn", 0}); 
	list.erase("Quinn");
	
	add2FriendsList("Quinn", friendships, list, 1, scoresCool);
/***********************************************************************************/	
	for(int QDist = 1; QDist < n; QDist++)
		for(int i = 0; i < scoresCool.size(); ++i) { 
			if(scoresCool[i].second == QDist)
			add2FriendsList(scoresCool[i].first, friendships, list, QDist+1, scoresCool);
		}
/***********************************************************************************/	
	for(auto e : scoresCool) finalScore.push_back({e.first, to_string(e.second)});
	for(auto f : list) finalScore.push_back({f, "uncool"});

	sort(finalScore.begin(), finalScore.end(),
	[](const pair<string,string>& l, const pair<string,string>& r) 
		{return l.first < r.first;} );

	for(auto e : finalScore) 
		cout << e.first << " " << e.second << endl;
}

int main() {
	int n;
	
	cin >> n;

	vector< pair<string, string> > friendships(n);
	
	for(auto& it : friendships) {
		auto i = &it - &friendships[0];
		cin >> it.first >> it.second;
		//cout << endl;
	}
	
	theQuinnThang(friendships, n); 
}

