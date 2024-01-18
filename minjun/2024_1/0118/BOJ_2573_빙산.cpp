#include <bits/stdc++.h>
using namespace std;
int N, M;
const int dir[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

void melt(int board[][301]) {
    queue<tuple<int,int,int>> q; // {r, c, dec}
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (board[i][j] > 0) {
                int k = 0;
                for (int d = 0; d < 4; d++) {
                    int ny = i + dir[d][0], nx = j + dir[d][1];
                    if (ny < 0 || nx < 0 || ny >= N || nx >= M || board[ny][nx] != 0) continue;
                    k++;
                }
                q.push({i, j, k});
            }
        }
    }
    while (!q.empty()) {
        auto [r, c, k] = q.front();
        q.pop();
        board[r][c] = max(0, board[r][c] - k);
    }
}

int check(int board[][301]) {
    // 덩어리의 개수
    int result = 0;
    bool visited[301][301] = {false,};
    bool isAllMelted = true;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (board[i][j] == 0 || visited[i][j]) continue;
            isAllMelted = false;
            visited[i][j] = true;
            result++;
            queue<pair<int,int>> q;
            q.push({i, j});
            while (!q.empty()) {
                auto [y, x] = q.front();
                q.pop();
                for (int d = 0; d < 4; d++) {
                    int ny = y + dir[d][0], nx = x + dir[d][1];
                    if (ny < 0 || nx < 0 || ny >= N || nx >= M || board[ny][nx] == 0 || visited[ny][nx]) continue;
                    visited[ny][nx] = true;
                    q.push({ny, nx});
                }
            }
        }
    }
    if (isAllMelted) return -1;
    return result;
}
int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);

    int board[301][301];
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> board[i][j];
        }
    }

    int counter = 0, res;
    while (true) {
        res = check(board);
        if (res == -1 || res >= 2) break;
        counter++;
        melt(board);
    }

    if (res != -1) cout << counter;
    else cout << 0;
    return 0;
}