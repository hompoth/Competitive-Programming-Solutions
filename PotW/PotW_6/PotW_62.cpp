#include <vector>
#include <iostream>
#include <list>
#include <stack>
#include <cstring>
using namespace std;

class Graph{
	int V; 
	list<int> *adj;
	public:
	Graph(int V){
		this->V = V;
		adj = new list<int>[V*2];
	}

	void setV(int V){
		this->V = V;
	}

	void addEdge(int v, int w){
		adj[v].push_back(w); 
	}

	void topologicalSortUtil(int v, bool visited[], stack<int> &Stack, vector<string> list_){
		visited[v] = true;
		list<int>::iterator i;
		for (i = adj[v].begin(); i != adj[v].end(); ++i)
			if (!visited[*i])
				topologicalSortUtil(*i, visited, Stack, list_);

		cout << list_[v] << endl; 
		Stack.push(v);
	}

	void topologicalSort(vector<string> list){
		stack<int> Stack;

		bool *visited = new bool[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				topologicalSortUtil(i, visited, Stack, list);

		while (Stack.empty() == false){
			cout << list[Stack.top()]<< " ";
			Stack.pop();
		}
		cout << endl;
	}
};

int min(int x, int y){
	return (x < y)? x : y;
}

int main()
{
	int T,i,j,k;
	cin >>T;
	Graph g(T);
	string s1, s2;
	int n1, n2;
	vector<string> list;
	while(T--){
		n1 = -1;
		n2 = -1;
		cin >> s1 >> s2;
		for(int i = 0; i < list.size(); ++i){
			if(list[i].compare(s1)==0) n1 = i;
			if(list[i].compare(s2)==0) n2 = i;
		}
		if(n1 == -1) {
			list.push_back(s1);
			n1 = list.size()-1;
		}
		if(n2 == -1) {
			list.push_back(s2);
			n2 = list.size()-1;
		}
		g.addEdge(n1, n2);
	}
	g.setV(list.size());
	g.topologicalSort(list);
	stack<int> Stack;
	Stack.push(1);
	Stack.push(2);
	Stack.push(3);
	Stack.push(4);
	cout << Stack.top() << endl;
	Stack.pop();
	cout << Stack.top() << endl;
	Stack.pop();
	cout << Stack.top() << endl;
	Stack.pop();
	cout << Stack.top() << endl;
	Stack.pop();
	return 0;
} 

