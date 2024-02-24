#include <bits/stdc++.h>
using namespace std;
char board[1001][1001];
int dist[11][1001][1001];
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    int N, M, K;
    cin >> N >> M >> K;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> board[i][j];
        }
    }

    fill(&dist[0][0][0], &dist[10][1000][1001], 0x3f3f3f3f);

    const int dir[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // {acDist, acBreak, y, x}
    typedef tuple<int,int,int,int> tp;
    priority_queue<tp, vector<tp>, greater<>> pq;
    pq.emplace(1, 0, 0, 0);
    dist[0][0][0] = 1;

    while (!pq.empty()) {
        auto [ac_dist, ac_break, y, x] = pq.top(); pq.pop();
        if (ac_dist > dist[ac_break][y][x]) continue;
        for (int d = 0; d < 4; d++) {
            int ny = y + dir[d][0], nx = x + dir[d][1];
            if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue; // out of bounds
            if (ac_break == K && board[ny][nx] == '1') continue; // can't break wall
            int new_ac_break = ac_break + (board[ny][nx] == '1');
            if (dist[new_ac_break][ny][nx] <= dist[ac_break][y][x] + 1) continue; // avoid cycle
            dist[new_ac_break][ny][nx] = dist[ac_break][y][x] + 1;
            pq.emplace(dist[new_ac_break][ny][nx], new_ac_break, ny, nx);
        }
    }

    int ans = 0x3f3f3f3f;
    for (int i = 0; i <= K; i++) {
        ans = min(ans, dist[i][N - 1][M - 1]);
    }
    if (ans == 0x3f3f3f3f) cout << -1;
    else cout << ans;

    return 0;
}