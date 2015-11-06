#include <iostream>
#include <list>
using namespace std;

class Node {
	char content;
	bool marker;
	list<Node*> children;
public:
	Node(char c):content(c){}
	~Node(){ for(auto &n : children) delete n; }
	bool wordMarker() { return marker; }
	void setWordMarker() { marker = true; }
	void appendChild(Node* child) { children.push_back(child); }
	Node* findChild(char c){
		for(auto &n : children) if(n->content==c) return n;
		return NULL;
	}
};

class Trie {
	Node* root;
public:
	Trie(){ root = new Node(' '); }
	~Trie(){ delete root; }
	void addWord(string s){
		Node* current = root;
		for ( int i = 0; i < s.length(); i++ ){        
			Node* child = current->findChild(s[i]);
			if ( child != NULL ) current = child;
			else {
				Node* tmp = new Node(s[i]);
				current->appendChild(tmp);
				current = tmp;
			}
		}
		current->setWordMarker();
	}
	bool searchSentence(string s){
		Node* current = root;
		list<pair<string, Node*>> q;
		string str;
		q.push_front({s, current});
		while(!q.empty()){
			current=q.back().second;
			str=q.back().first;
			q.pop_back();
			if(str.size()==0) return true;
			for(int i = 0; i < s.length(); ++i){
				Node* tmp = current->findChild(str[i]);
				if(tmp==NULL) break;
				if(tmp->wordMarker()) q.push_front({str.substr(i+1), root});
				current = tmp;
			}
		}
		return false;
	}
};

int main(){
	Trie trie = Trie();
	int N;
	string str;
	cin >> N;
	while(N--){
		cin >> str;
		trie.addWord(str);
	}
	cin >> N;
	while(N--){
		cin >> str;
		cout << trie.searchSentence(str) << endl;
	}
}
