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
vector<int> low , tin;
vector<pair<int,int>> store;


int timer = 0;
void dfs(int v , int p = -1){
	vis[v] = true;
	low[v] = tin[v] = ++timer;
	for(auto node : adj[v]){
		if(p == node) continue;
		if(vis[node]){
			low[v] = min(low[v] , tin[node]);
		}else{
			dfs(node , v);
			low[v] = min(low[v] , low[node]);
			if(low[node] > tin[v]){
				store.push_back({v , node});
			}
		}
	}
}


int main() {
    int n = 5; // Number of nodes
    // int m = 5; // Number of edges

    adj.assign(n , vector<int>());
    vis.assign(n, false);
    low.assign(n, 0);
    tin.assign(n, 0);

    vector<pair<int, int>> edges = {
        {0, 1}, {1, 2}, {2, 0}, {1, 3}, {3, 4}
    };

    for (auto it : edges) {
        adj[it.first].push_back(it.second);
        adj[it.second].push_back(it.first);
    }

    for (int i = 0; i < n; i++) {
        if (!vis[i]) {
            dfs(i);
        }
    }

    cout << "Bridges in the graph:\n";
    for (auto &p : store) {
        cout << p.first << " " << p.second << "\n";
    }
    
    return 0;
}
