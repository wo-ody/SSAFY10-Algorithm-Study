#include <bits/stdc++.h>
using namespace std;
int N;
char board[6][6];
const int dir[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
bool check(int r, int c) {
    for (int d = 0; d < 4; d++) {
        int y = r, x = c;
        while (0 <= y && y < N && 0 <= x && x < N && board[y][x] != 'O') {
            if (board[y][x] == 'S') return false;
            y += dir[d][0], x += dir[d][1];
        }
    }
    return true;
}
bool dfs(int r, int c, int k) {
    if (k == 0) {
        bool result = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'T') {
                    result = result && check(i, j);
                }
            }
        }
        // todo: 범위 체크
        return result;
    }
    if (r == N) {
        return false;
    }
    bool ret = false;
    if (board[r][c] == 'X') {
        board[r][c] = 'O';
        ret = dfs(r + (c + 1) / N, (c + 1) % N, k - 1);
        board[r][c] = 'X';
    }
    ret = ret || dfs(r + (c + 1) / N, (c + 1) % N, k);
    return ret;
}
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    cin >> N;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> board[i][j];
        }
    }

    // 방해물을 'X'에 둔다. 'T'를 중심으로 방해물 전까지의 모든 학생들은 감시당함
    // (0, 0, 3);
    if (dfs(0, 0, 3)) {
        cout << "YES";
    } else {
        cout << "NO";
    }

    return 0;
}