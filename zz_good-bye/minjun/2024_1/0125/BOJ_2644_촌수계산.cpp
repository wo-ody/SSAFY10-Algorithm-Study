#include <bits/stdc++.h>
using namespace std;
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    int n, a, b, m;
    cin >> n >> a >> b >> m;

    vector<int> adj[101];
    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    // a -> b
    queue<pair<int,int>> q;
    bool visited[101] = {false};
    visited[a] = true;
    q.push({0, a});
    int ans = -1;
    while (!q.empty()) {
        auto [dist, cur] = q.front();
        q.pop();
        if (cur == b) {
            ans = dist;
            break;
        }
        for (auto next : adj[cur]) {
            if (visited[next]) continue;
            visited[next] = true;
            q.push({dist + 1, next});
        }
    }
    cout << ans;
    return 0;
}