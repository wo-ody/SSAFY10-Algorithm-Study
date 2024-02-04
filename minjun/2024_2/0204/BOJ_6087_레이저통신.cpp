#include <bits/stdc++.h>
using namespace std;
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    vector<pair<int,int>> pos;
    int W, H;
    cin >> W >> H;

    char board[101][101];
    for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
            cin >> board[i][j];
            if (board[i][j] == 'C') {
                pos.emplace_back(i, j);
            }
        }
    }

    int visited[4][101][101];
    fill(&visited[0][0][0], &visited[3][100][101], 0x3f3f3f3f);
    // {거울 설치 횟수, d, r, c}
    const int dir[4][2] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    typedef tuple<int,int,int,int> tp;
    queue<tp> q;
    for (int d = 0; d < 4; d++) {
        visited[d][pos[0].first][pos[0].second] = true;
        q.emplace(0, d, pos[0].first, pos[0].second);
    }

    int ans = 0x3f3f3f3f;

    while (!q.empty()) {
        auto [acDist, cd, r, c] = q.front(); q.pop();
        if (r == pos[1].first && c == pos[1].second) {
            ans = min(ans, acDist);
        }
        for (int diff = -1; diff <= 1; diff++) {
            int nd = (cd + diff + 4) % 4;
            int nr = r + dir[nd][0], nc = c + dir[nd][1];
            if (nr < 0 || nc < 0 || nr >= H || nc >= W || board[nr][nc] == '*')
                continue;
            if (visited[nd][nr][nc] <= acDist + abs(diff)) continue;
            visited[nd][nr][nc] = acDist + abs(diff);
            q.emplace(acDist + abs(diff), nd, nr, nc);
        }
    }
    cout << ans;

    return 0;
}