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



vector<vector<int>> adj;
vector<bool> vis;


void dfs(int v ){
	vis[v] = true;
	for(auto i : adj[v]){
		if(!vis[i]){
			dfs(i);
		}
	}
}


void solve(){
	int n , e;
	cin >> n >> e;
	adj.assign(n+1);
	vis.assign(n+1 , false); 
	
	while(e--){
		int u , v;
		cin >> u >> v;
		adj[v].push_back(u);
		adj[u].push_back(v);
	}
	dfs(1);
	
}

int main(){
	int T = 1;
	cin >> T;
	while(T--){
		solve();
	}
}