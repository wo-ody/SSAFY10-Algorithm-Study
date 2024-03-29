#include <bits/stdc++.h>

using namespace std;
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    char board[8][8];
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            cin >> board[i][j];
        }
    }

    queue<pair<int,int>> q;
    q.emplace(7, 0);
    const int dir[9][2] = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, -1}, {1, 1}, {-1, 1}, {-1, -1}};
    bool ans = false;

    while (!q.empty() && !ans) {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            auto [y, x] = q.front(); q.pop();
            if (board[y][x] == '#')
                continue;
            if (y == 0 && x == 7) {
                ans = true;
                break;
            }
            for (int d = 0; d < 9; d++) {
                int ny = y + dir[d][0], nx = x + dir[d][1];
                if (ny < 0 || nx < 0 || ny >= 8 || nx >= 8 || board[ny][nx] == '#')
                    continue;
                q.emplace(ny, nx);
            }
        }
        // 모든 벽이 내려간다.
        vector<pair<int,int>> walls;
        char new_board[8][8];
        fill(&new_board[0][0], &new_board[7][8], '.');
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == '#') {
                    walls.emplace_back(i, j);
                }
            }
        }
        for (const auto& [r, c] : walls) {
            if (r + 1 >= 8) continue;
            new_board[r + 1][c] = '#';
        }
        memcpy(board, new_board, sizeof(new_board));
    }

    cout << (int)ans;
    return 0;
}
