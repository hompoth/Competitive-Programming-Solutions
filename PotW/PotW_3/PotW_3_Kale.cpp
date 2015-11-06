#include <map>
#include <iostream>
#include <string>

using namespace std;

struct Node{
	map<char, Node *> trie;
	bool isWord;

	bool checkSentence(string sentence, Node *root){
		Node *curPos { this };

		while (!sentence.empty()){
			string::iterator i  { begin(sentence) };
			if (curPos->trie.count(*i)){
				curPos = curPos->trie[*i];
				sentence.erase(i);

				if (curPos->isWord)	
					if (checkSentence(sentence, root)) return true;
			}
			else return false;

		}
		if(!curPos->isWord) return false;
		return true;
	}
};

class Trie {
	Node *root;
	public:
		Trie() { root = new Node(); }
		void insert(string str){
			Node *curPos = root;
			for (char c : str){
				if (curPos->trie.count(c) == 0)
					curPos->trie[c] = new Node();
				curPos = curPos->trie[c];
			}
			curPos->isWord = true;
		}
		bool checkSentence(string sentence) {
			return root->checkSentence(sentence, root);
		}
};



int main(){
	int N {};
	string str{};
	Trie trie {};
	cin >> N;
	for (int i = 0; i < N; ++i){
		cin >> str;
		trie.insert(str);
	}
	cin >> N;
	for (int i = 0; i < N; ++i){
		cin >> str;
		cout << trie.checkSentence(str) << endl;
	}
	return 0;
}
