#include <bits/stdc++.h>
using namespace std;

const int MAXN = 100005;  // Maximum number of nodes
const int LOG = 20;       // Log base 2 of MAXN

vector<int> adj[MAXN];    // Adjacency list
int up[MAXN][LOG];        // Binary Lifting table
int tin[MAXN], tout[MAXN]; // Entry and Exit time for Euler Tour
int timer = 0;
int depth[MAXN];         // Depth of nodes

// Precompute Binary Lifting Table using DFS
void dfs(int node, int parent) {
    tin[node] = ++timer;  // Start time of the node
    up[node][0] = parent; // Immediate parent
    for (int i = 1; i < LOG; i++) {
        if (up[node][i - 1] != -1)
            up[node][i] = up[up[node][i - 1]][i - 1];
        else
            up[node][i] = -1;
    }

    for (int neighbor : adj[node]) {
        if (neighbor != parent) {
            depth[neighbor] = depth[node] + 1;
            dfs(neighbor, node);
        }
    }

    tout[node] = ++timer; // End time of the node
}

// Check if `u` is an ancestor of `v`
bool is_ancestor(int u, int v) {
    return tin[u] <= tin[v] && tout[u] >= tout[v];
}

// Find LCA using Binary Lifting
int lca(int u, int v) {
    if (is_ancestor(u, v))
        return u;
    if (is_ancestor(v, u))
        return v;

    for (int i = LOG - 1; i >= 0; i--) {
        if (!is_ancestor(up[u][i], v))
            u = up[u][i];
    }
    return up[u][0];  // Parent of `u` is the LCA
}

int main() {
    int n, q;
    cin >> n;

    // Build adjacency list
    for (int i = 0; i < n - 1; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    memset(up, -1, sizeof(up));
    depth[1] = 0;  // Assuming node 1 is the root
    dfs(1, -1);    // Precompute ancestors

    cin >> q;  // Number of queries
    while (q--) {
        int u, v;
        cin >> u >> v;
        cout << "LCA(" << u << ", " << v << ") = " << lca(u, v) << "\n";
    }

    return 0;
}
