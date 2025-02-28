#include <iostream>
#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> adj;
int n = 0;


void dfs(int node , vector<bool> &vis){
    n++;
    //if(vis[node]) return ;
    vis[node] = true;
    for(int i : adj[node]){
        if(!vis[i]){
            dfs(i , vis);
        }
    }
}



/*
#include <bits/stdc++.h>
using namespace std;

#define int int64_t

class Solution {
  public:
    void dfs(int i, vector<vector<int>> graph, vector<bool> &vis) {
        if (vis[i]) return;
        vis[i] = 1;
        for (auto u : graph[i]) {
            dfs(u, graph, vis);
        }
    }
    bool CheckConnection(int N, vector<vector<int>> Edges) {
        vector<vector<int>> graph(N + 1);
        for (auto i : Edges) graph[i[0]].push_back(i[1]);
        vector<bool> vis(N + 1, false);
        dfs(1, graph, vis);
        for (int i = 1; i <= N; i++) {
            if (vis[i] == 0) return false;
        }
        return true;
    }
};
int32_t main() {

    int tc;
    cin >> tc;
    while (tc--) {
        int n, m;
        cin >> n >> m;

        vector<vector<int>> edges;
        for (int i = 0; i < m; i++) {
            int u, v;
            cin >> u >> v;
            edges.push_back({u, v});
        }
        Solution obj;

        if (obj.CheckConnection(n, edges))
            cout << "Yes" << endl;
        else
            cout << "No" << endl;
    }
    return 0;
}



*/




int main() {
	
	
	int t = 1; 
	cin >> t;
	
	while(t--){
	    int N , M;
	    cin >> N >> M;
	    n =0;
	    
	    adj.assign(N+1 , vector<int>());
	    
	    while(M--){
	        int u , v;
	        cin >> u >> v;
	        adj[u].push_back(v);
	        adj[v].push_back(u);
	    }
	    
	    int cnt = 0;
	    vector<bool> vis(N+1 , false);
	    
	    for(int i = 1 ; i <= N; i++){
	        if(!vis[i]){
	            dfs(i , vis);
	            cnt++;
	        }
	    }
	    bool c = true;
	    
	    for(int  i = 1 ; i <= N; i++){
	        if(!vis[i]) c = false; 
	    }

	    
	    if(cnt == 1 and c) cout << "Yes" << "\n";
	    else cout << "No" << "\n";
	}
	
	return 0;
}