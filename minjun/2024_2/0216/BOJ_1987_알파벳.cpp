#include <bits/stdc++.h>

using namespace std;
int R, C;
char board[21][21];
bool chk(int bitmask, char target) {
    return bitmask & (1 << (target - 'A'));
}
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    cin >> R >> C;
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cin >> board[i][j];
        }
    }

    // 현재 어느 알파벳을 밟고 진행하였는가?
    // 알파벳의 개수 = 거리, 거리의 max
    // [r][c] 에 도달하기 위한 max
    // {r, c, bitmask}

    typedef tuple<int,int,int> tp;
    queue<tp> q;
    q.emplace(0, 0, 1 << (board[0][0] - 'A'));

    const int dir[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int ans = 1;
    while (!q.empty()) {
        auto [r, c, bitmask] = q.front(); q.pop();
        ans = max(ans, __builtin_popcount(bitmask));
        for (int d = 0; d < 4; d++) {
            int nr = r + dir[d][0], nc = c + dir[d][1];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C || chk(bitmask, board[nr][nc])) continue;
            int nbitmask = bitmask | (1 << (board[nr][nc] - 'A'));
            q.emplace(nr, nc, nbitmask);
        }
    }
    cout << ans;
    return 0;
}