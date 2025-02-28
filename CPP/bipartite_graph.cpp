#include <bits/stdc++.h>
using namespace std;

/* clang-format off */

/* TYPES  */
#define ll long long
#define pii pair<int, int>
#define pll pair<long long, long long>
#define vi vector<int>
#define vll vector<long long>
#define mii map<int, int>
#define si set<int>
#define sc set<char>

int n, m; // Number of nodes and edges
vector<vi> adj; // Adjacency list

bool bipartite(){
	vector<int> vis(n , 0);
	
	for(int i = 1 ; i <= n ; i++){
		if(!vis[i]){
			vis[i] = 1; // 1 for blue color and 2 for black color
			queue<int> q;
			q.push(i);
			while(!q.empty()){
				int node = q.front();
				q.pop();
				for(auto v : adj[node]){
					if(vis[v] == vis[node]) return false;
					if(!vis[v]){
						q.push(v);
						if(vis[node] == 1) vis[v] = 2;
						else vis[v] = 1;
					} 
				}
			}
		}
	}
	return true;
}

int main() {
    cout << "Enter number of nodes, edges, and edge list in one line:\n";
    
    cin >> n >> m;
    adj.assign(n + 1, vi()); // Resize adjacency list

    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u); // Since it's an undirected graph
    }

    cout << (bipartite() ? "The graph is Bipartite.\n" : "The graph is NOT Bipartite.\n");

    return 0;
}