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
    return parent[x] = find(parent[x]);
}

void uni(int u, int v) {
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
    }
}

int connected_components(int n, vector<vector<int>> &edges) {
    init(n);
    // int cnt = 0;
    for (auto &i : edges) {
        uni(i[0], i[1]);
    }
    unordered_set<int> unique_parents;
    for (int i = 1; i <= n; i++) {
        unique_parents.insert(find(i));
    }
    return unique_parents.size();
}

int main() {
    int n = 5;
    vector<vector<int>> edges = {{1, 2}, {3, 4}, {2, 3}};

    cout << "Find(1): " << find(1) << endl;
    cout << "Find(4): " << find(4) << endl;
    cout << "Find(5): " << find(5) << endl;
    
    int ans = connected_components(n, edges);
    cout << ans << "\n";
    
    return 0;
}
