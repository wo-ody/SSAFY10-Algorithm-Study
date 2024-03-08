#include <bits/stdc++.h>
using namespace std;
int N, M, board[101][101];
const int dir[4][2] = {{-1,0},{1,0},{0,-1},{0,1}};
int hit[101][101];
bool melt() {
    int melted = 0;

    memset(hit, 0, sizeof(hit));
    queue<pair<int,int>> q;
    q.emplace(0, 0);

    while (!q.empty()) {
        auto [y, x] = q.front(); q.pop();
        for (int d = 0; d < 4; d++) {
            int ny = y + dir[d][0], nx = x + dir[d][1];
            if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
            if (board[ny][nx] == 0 && hit[ny][nx] > 0) continue;
            hit[ny][nx] += 1;
            if (board[ny][nx] == 1) continue;
            q.emplace(ny, nx);
        }
    }

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (hit[i][j] >= 2) {
                board[i][j] = 0;
                melted++;
            }
        }
    }

    return melted > 0;
}

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> board[i][j];
        }
    }

    int ans = 0;
    while (melt()) {
        ans++;
    }
    cout << ans;

    return 0;
}