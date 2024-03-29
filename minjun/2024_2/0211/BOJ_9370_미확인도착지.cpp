#include <bits/stdc++.h>
using namespace std;
int T, n, m, t, s, g, h, adj[2001][2001];
vector<vector<int>> dijkstra(int start) {
    // {현재 누적거리, 방문 여부, current}
    vector<vector<int>> result(2, vector<int>(2001, 0x3f3f3f3f));
    typedef tuple<int,int,int> tp;
    priority_queue<tp, vector<tp>, greater<>> pq;
    result[0][start] = 0;
    pq.emplace(0, 0, start);
    while (!pq.empty()) {
        auto [acDist, flag, current] = pq.top(); pq.pop();
        for (int nxt = 1; nxt <= n; nxt++) {
            if (adj[current][nxt] == 0x3f3f3f3f) continue;
            int nFlag = flag || (current == g && nxt == h) || (current == h && nxt == g);
            if (result[nFlag][nxt] <= result[flag][current] + adj[current][nxt]) continue;
            result[nFlag][nxt] = result[flag][current] + adj[current][nxt];
            pq.emplace(result[nFlag][nxt], nFlag, nxt);
        }
    }
    return result;
}
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    cin >> T;
    while (T--) {
        // initialize
        fill(&adj[0][0], &adj[2000][2001], 0x3f3f3f3f);
        // input
        cin >> n >> m >> t >> s >> g >> h;
        for (int i = 0; i < m; i++) {
            int a, b, d;
            cin >> a >> b >> d;
            adj[a][b] = adj[b][a] = d;
        }

        vector<int> candidates(t);
        for (auto &elem : candidates) {
            cin >> elem;
        }

        // solve
        // s에서 시작하여 g-h를 들려서 방문한 최단거리 or no
        vector<vector<int>> dist = dijkstra(s);
        // dist[1][target] == dist[0][target]이여야, 최단거리로 방문한 것이 된다.
        sort(candidates.begin(), candidates.end());
        for (const auto& target : candidates) {
            if (dist[1][target] != 0x3f3f3f3f && dist[1][target] <= dist[0][target]) {
                cout << target << ' ';
            }
        }
        cout << '\n';
    }
}
