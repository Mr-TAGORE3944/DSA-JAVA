#include <bits/stdc++.h>
using namespace std;

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
vector<int> points;
vector<int> low, tin;
int timer = 0;

void dfs(int v, int p = -1) {
    vis[v] = true;
    low[v] = tin[v] = ++timer;
    int child = 0;
    for (auto node : adj[v]) {
        if (p == node) continue;
        if (vis[node]) {
            low[v] = min(tin[node], low[v]);
        } else {
            dfs(node, v);
            low[v] = min(low[v], low[node]);
            if (low[node] >= tin[v] && p != -1) {
                points.push_back(v);
            }
            child++;
        }
    }
    if (p == -1 && child > 1) points.push_back(v);
}

int main() {
    int n, m;
    cin >> n >> m; // Number of nodes and edges
    
    adj.resize(n + 1);
    vis.resize(n + 1, false);
    tin.resize(n + 1, -1);
    low.resize(n + 1, -1);
    
    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    
    for (int i = 1; i <= n; i++) {
        if (!vis[i]) {
            dfs(i);
        }
    }
    
    cout << "Articulation Points: " << "\n";
    for (int point : points) {
        cout << point << " ";
    }
    cout << endl;
    
    return 0;
}
