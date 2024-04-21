#include <bits/stdc++.h>
using namespace std;
int N, M, K;
bool isMarket[10001];
typedef long long ll;
vector<pair<int,int>> adj[10001];
vector<int> markets;
constexpr ll INF = 0x3f3f3f3f3f3f3f3fLL;
vector<ll> dijkstra(int nth) {
    vector<ll> dist(N + 1, INF);
    priority_queue<pair<ll,int>, vector<pair<ll,int>>, greater<>> pq;
    dist[markets[nth]] = 0;
    pq.push({0, markets[nth]});
    while (!pq.empty()) {
        auto [acDist, cur] = pq.top(); pq.pop();
        for (const auto& [cost, next]: adj[cur]) {
            if (dist[next] <= dist[cur] + cost) continue;
            dist[next] = dist[cur] + cost;
            pq.push({dist[cur] + cost, next});
        }
    }
    return dist;
}
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    cin >> N >> M >> K;
    markets.resize(K);
    for (auto &elem: markets) {
        cin >> elem;
        isMarket[elem] = true;
    }
    for (int i = 0; i < M; i++) {
        int u, v, l;
        cin >> u >> v >> l;
        adj[u].emplace_back(l, v);
        adj[v].emplace_back(l, u);
    }
    // dist[5][10001] -> i번째 마켓의 위치에서 j위치에 도달하기 위해 필요한 최단거리
    vector<vector<ll>> dist(K, vector<ll>(N + 1, INF));
    for (int i = 0; i < K; i++) {
        dist[i] = dijkstra(i);
    }

    ll ans = INF;
    for (int i = 1; i <= N; i++) {
        if (isMarket[i]) continue;
        vector<int> permutations(K);
        generate(permutations.begin(), permutations.end(), [n = 0]() mutable { return n++; });
        do {
            ll result = 0;
            for (int i = 0; i < K - 1; i++) {
                int v = markets[permutations[i + 1]];
                result += dist[permutations[i]][v];
            }
            result += dist[permutations[0]][i];
            result += dist[permutations[K - 1]][i];
            ans = min(ans, result);
        } while (next_permutation(permutations.begin(), permutations.end()));
    }
    cout << ans;
    return 0;
}