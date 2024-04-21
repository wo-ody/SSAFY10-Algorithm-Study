#include <bits/stdc++.h>
using namespace std;
void trace(vector<int>& result, int visited[], int cur) {
    result.push_back(cur);
    if (visited[cur] == cur) return;
    trace(result, visited, visited[cur]);
}
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    int N, K;
    cin >> N >> K;

    // {누적 시간, 현재 위치, 이전 위치}
    typedef tuple<int,int,int> tp;
    priority_queue<tp, vector<tp>, greater<>> pq;

    int visited[200001]; // 이전에 방문했던 좌표를 기록 (default: -1)
    fill(&visited[0], &visited[200001], -1);

    visited[N] = N;
    pq.emplace(0, N, -1);

    function<int(int)> op[] = {
            [](int x){return x - 1;},
            [](int x){return x + 1;},
            [](int x){return x * 2;}
    };

    int ans = -1;

    while (!pq.empty()) {
        // 항상 x에 이전에 방문한 것이 최단 거리임이 보장됨
        auto [ac_dist, cur_pos, prev_pos] = pq.top(); pq.pop();
        if (cur_pos == K) {
            ans = ac_dist;
            break;
        }

        for (const auto& fn : op) {
            int nxt = fn(cur_pos);
            if (0 <= nxt && nxt <= 200000 && visited[nxt] == -1) {
                visited[nxt] = cur_pos;
                pq.emplace(ac_dist + 1, nxt, cur_pos);
            }
        }

    }
    cout << ans << '\n';

    vector<int> result;
    trace(result, visited, K);
    reverse(result.begin(), result.end());
    for (auto path : result) cout << path << ' ';

    return 0;
}