#include <iostream>
#include <vector>
using namespace std;

vector<vector<int>> adj;
int N, M;

void dfs(int u, int v, vector<vector<bool>> &vis) {
    if (u < 0 || v < 0 || u >= N || v >= M || adj[u][v] != 1 || vis[u][v]) 
        return;

    vis[u][v] = true;  // Mark as visited

    dfs(u + 1, v, vis);
    dfs(u - 1, v, vis);
    dfs(u, v + 1, vis);
    dfs(u, v - 1, vis);
}

int main() {
    int t;
    cin >> t;

    while (t--) {
        int K, Q;
        cin >> N >> M >> Q >> K;

        adj.assign(N, vector<int>(M, 0));

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cin >> adj[i][j];
            }
        }

        vector<vector<bool>> vis(N, vector<bool>(M, false));

        int ans = 0;

        while (Q--) {
            int u, v;
            cin >> u >> v;

            if (u < 0 || v < 0 || u >= N || v >= M) continue; // Avoid out-of-bounds input

            if (adj[u][v] == 1 && !vis[u][v]) {
                dfs(u, v, vis);
                ans++;
            }
        }

        cout << ans-1 << "\n";
    }

    return 0;
}
