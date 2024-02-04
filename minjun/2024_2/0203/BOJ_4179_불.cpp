#include <bits/stdc++.h>
using namespace std;
int main(void) {

    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);


    // 1000 * 1000 번 iteration
    // 10^6
    // 매번 bfs?
    // n초의 불이 어느 위치로 전이되는지에 대한 정보를 미리 저장
    // t초에 [i][j]칸에 도달할 수 있는가에 대한 여부
    // 움직이고, 불이 전이된다.

    char board[1001][1001];
    int R, C;
    cin >> R >> C;

    queue<pair<int,int>> jq, fq;
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cin >> board[i][j];
            if (board[i][j] == 'J') {
                jq.push({i, j});
            } else if (board[i][j] == 'F') {
                fq.push({i, j});
            }
        }
    }

    // 큐에는 k 시점의 지난뒤에 지훈이의 위치들을 보관
    // F에는 k 시점의 불의 위치들을 보관
    const int dir[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int ans = 0;

    while (true) {
        int size = jq.size();
        if (size == 0) break;
        for (int i = 0; i < size; i++) {
            auto [jy, jx] = jq.front();
            jq.pop();
            if (board[jy][jx] == 'F') continue;
            for (int d = 0; d < 4; d++) {
                int njy = jy + dir[d][0], njx = jx + dir[d][1];
                if (njy < 0 || njx < 0 || njy >= R || njx >= C) {
                    cout << ans + 1;
                    exit(0);
                }
                if (board[njy][njx] == 'F' || board[njy][njx] == 'J' || board[njy][njx] == '#') continue;
                board[njy][njx] = 'J';
                jq.push({njy, njx});
            }
        }
        size = fq.size();
        for (int i = 0; i < size; i++) {
            auto [y, x] = fq.front();
            fq.pop();
            for (int d = 0; d < 4; d++) {
                int ny = y + dir[d][0], nx = x + dir[d][1];
                if (ny < 0 || nx < 0 || ny >= R || nx >= C || board[ny][nx] == 'F' || board[ny][nx] == '#')
                    continue;
                board[ny][nx] = 'F';
                fq.push({ny, nx});
            }
        }

        ans++;
    }
    cout << "IMPOSSIBLE";
    return 0;
}