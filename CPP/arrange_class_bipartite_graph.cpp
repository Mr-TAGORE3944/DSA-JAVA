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


vector<vi> adj;
int n;

bool bipartite(){
	vector<int> vis(n+1, 0);
	// bfs code
	for(int i = 1 ; i <= n ; i++){
		if(!vis[i]){
			vis[i] = 1; // default group 1
			queue<int> q;
			q.push(i);
			while(!q.empty()){
				int node = q.front();
				q.pop();
				for(auto i : adj[node]){
					if(vis[i] == vis[node]) return false;
					if(!vis[i]){
						q.push(i);
						if(vis[node] == 1) vis[i] = 2;
						else vis[i] = 1;
					}
				}
			}
		}
	}
	return true;
}

void solve(){
	int  m;
	cin >> n >> m;
	adj.assign(n+1 , vector<int>());
	
	for(int i = 0 ; i < m ; i++){
		int u , v;
		cin >> u >> v;
		adj[v].push_back(u);
		adj[u].push_back(v);
	}
	
	bool ans = bipartite();
	if(ans) cout << "Yes" << "\n";
	else cout << "No" << "\n";
}

int main(){
	int t = 1;
	cin >> t;
	while(t--){
		solve();
	}
	
	return 0;
}