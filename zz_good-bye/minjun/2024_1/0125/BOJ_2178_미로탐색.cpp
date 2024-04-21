#include <bits/stdc++.h>
using namespace std;
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    int N, M;
    cin >> N >> M;
    char board[101][101];
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> board[i][j];
        }
    }

    queue<tuple<int,int,int>> q;
    q.push({1, 0, 0});
    int ans = -1, dir[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    while (!q.empty()) {
        auto [dist, y, x] = q.front();
        q.pop();
        if (y == N - 1 && x == M - 1) {
            ans = dist;
            break;
        }
        for (int d = 0; d < 4; d++) {
            int ny = y + dir[d][0], nx = x + dir[d][1];
            if (ny < 0 || nx < 0 || ny >= N || nx >= M || board[ny][nx] != '1') continue;
            board[ny][nx] = '0';
            q.push({dist + 1, ny, nx});
        }
    }
    cout << ans;
    return 0;
}