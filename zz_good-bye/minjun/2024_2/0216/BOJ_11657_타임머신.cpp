#include <bits/stdc++.h>

using namespace std;
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    // 음수 사이클이 존재한다면 무조건 -1 출력
    // 음수 사이클이 존재하지 않는다는 가정하에서, 특정 마을에 도달하는 경로가 없다면 -1 출력

    int N, M, A, B, C;
    cin >> N >> M;

    typedef tuple<int,int,int> tp;
    vector<tp> edges;

    long long dist[501];
    fill(&dist[0], &dist[501], 0x3f3f3f3f3f3f3f3fL);
    for (int i = 0; i < M; i++) {
        cin >> A >> B >> C;
        edges.emplace_back(A, B, C);
    }

    dist[1] = 0;
    // 최대 N - 1번만 반복하면 최단거리가 나온다.
    bool has_neg_cycle = false;
    for (int i = 0; i <= N - 1; i++) {
        // 모든 edge들에 대해서 검사
        for (const auto& [u, v, cost] : edges) {
            // 현재 edge를 이용해서 도달하는 경로가 더 짧을 경우 갱신한다.
            if (dist[u] != 0x3f3f3f3f3f3f3f3fL && dist[v] > dist[u] + cost) {
                dist[v] = dist[u] + cost;
                if (i == N - 1) has_neg_cycle = true;
            }
        }
    }
    if (has_neg_cycle && any_of(&dist[2], &dist[N + 1], [](auto c) { return c < 0x3f3f3f3f3f3f3f3fL; })) {
        cout << -1;
    } else {
        for (int i = 2; i <= N; i++) {
            if (dist[i] >= 0x3f3f3f3f3f3f3f3fL) {
                cout << -1 << '\n';
            } else {
                cout << dist[i] << '\n';
            }
        }
    }
    return 0;
}