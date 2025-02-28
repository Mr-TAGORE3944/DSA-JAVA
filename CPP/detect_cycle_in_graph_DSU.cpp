#include <bits/stdc++.h>
using namespace std;

#define vi vector<int>

vector<int> parent, sz;

void init(int n) {
    parent.assign(n + 1, 0);
    sz.assign(n + 1, 1);
    for (int i = 1; i <= n; i++) {
        parent[i] = i;
    }
}

int find(int x) {
    if (parent[x] == x) return x;
    return parent[x] = find(parent[x]); // Path compression
}

bool uni(int u, int v) {
    int pu = find(u);
    int pv = find(v);
    if (pu != pv) {
        if (sz[pu] > sz[pv]) {
            parent[pv] = pu;
            sz[pu] += sz[pv];
        } else {
            parent[pu] = pv;
            sz[pv] += sz[pu];
        }
        return false; // No cycle found
    }
    return true; // Cycle detected
}

bool detect_cycle(int n, vector<vector<int>> &edges) {
    init(n);
    for (auto &i : edges) {
        if (uni(i[0], i[1])) return true; // Cycle found
    }
    return false; // No cycle found
}

int main() {
    int n, m;
    cin >> n >> m;
    
    vector<vector<int>> edges(m, vector<int>(2));
    for (int i = 0; i < m; i++) {
        cin >> edges[i][0] >> edges[i][1];
    }

    if (detect_cycle(n, edges)) {
        cout << "Cycle Detected\n";
    } else {
        cout << "No Cycle\n";
    }

    return 0;
}
