#include <bits/stdc++.h>
using namespace std;
vector<pair<int, int>> adj[100001];
pair<int,int> dfs(int prev, int cur) {
    // cur -> end까지의 누적거리
    // {가장 먼 거리, 정점}
    pair<int, int> result = {0, cur};
    for (auto [cost, next] : adj[cur]) {
        if (prev == next) continue;
        // 누적 거리를 확인
        auto ret = dfs(cur, next);
        if (result.first < ret.first + cost) {
            result = {ret.first + cost, ret.second};
        }
    }
    return result;
}
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    int V;
    cin >> V;

    for (int i = 0; i < V; i++) {
        int u, v, cost;
        cin >> u;
        while (true) {
            cin >> v;
            if (v == -1) break;
            cin >> cost;
            adj[u].emplace_back(cost, v);
        }
    }

    int u1 = dfs(0, 1).second;
    cout << dfs(0, u1).first;
    return 0;
}
