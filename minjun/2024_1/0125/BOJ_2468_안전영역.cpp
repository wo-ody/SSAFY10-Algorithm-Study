#include <bits/stdc++.h>
using namespace std;
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    int N;
    cin >> N;
    vector<vector<int>> board(N, vector<int>(N));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> board[i][j];
        }
    }

    const int dir[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int ans = 0;
    for (int h = 0; h <= 100; h++) {
        // 강수량이 h라고 가정하였을 때
        vector<vector<bool>> canGo(N, vector<bool>(N, false));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] > h) canGo[i][j] = true;
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!canGo[i][j]) continue;
                result++;
                // (i, j)이 offset
                queue<pair<int,int>> q;
                q.push({i, j});
                canGo[i][j] = false;
                while (!q.empty()) {
                    auto [y, x] = q.front();
                    q.pop();
                    for (int d = 0; d < 4; d++) {
                        int ny = y + dir[d][0], nx = x + dir[d][1];
                        if (ny < 0 || nx < 0 || ny >= N || nx >= N || !canGo[ny][nx]) continue;
                        canGo[ny][nx] = false;
                        q.push({ny, nx});
                    }
                }
            }
        }
        ans = max(ans, result);
    }
    cout << ans;
    return 0;
}