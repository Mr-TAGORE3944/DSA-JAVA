#include <iostream>
#include<bits/stdc++.h>
using namespace std;

vector<vector<int>> adj;



int dfs(int n , vector<bool> &vis){
    vis[n] = true;
    for(auto i : adj[n]){
        if(!vis[i]){
            dfs(i , vis);
        }
    }
}


void solve(){
    int N , M;
    cin >> N >> M;
    
    
    
    while(M--){
        int u , v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    
    int ans = 0;
    
    vector<bool> vis(N , false);
    
    for(int i = 1 ; i <= N; i++){
        if(!vis[i]){
            dfs(i , vis);
            ans++;
        }
    }
    
    cout << ans << "\n";
    
    
}




int main() {
	
	
	int t = 1; cin >> t;
	
	while(t--){
	    solve();
	}
	
	return 0;
}