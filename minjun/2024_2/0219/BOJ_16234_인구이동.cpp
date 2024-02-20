#include <bits/stdc++.h>
using namespace std;
int N, L, R, board[51][51];
bool has_counted[51][51] = {false };
map<int,vector<pair<int,int>>> mp;
const int dir[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
void bfs(int sr, int sc, const int k) {
    // L <= diff <= R 인 모든 칸들을 mp에 저장
    has_counted[sr][sc] = true;
    mp[k].emplace_back(sr, sc);
    queue<pair<int,int>> q;
    q.emplace(sr, sc);

    while (!q.empty()) {
        auto [r, c] = q.front();
        q.pop();
        for (int d = 0; d < 4; d++) {
            int nr = r + dir[d][0], nc = c + dir[d][1];
            if (nr < 0 || nc < 0 || nr >= N || nc >= N || has_counted[nr][nc]) continue;
            int diff = abs(board[r][c] - board[nr][nc]);
            if (diff < L || diff > R) continue;
            has_counted[nr][nc] = true;
            mp[k].emplace_back(nr, nc);
            q.emplace(nr, nc);
        }
    }
}
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    cin >> N >> L >> R;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> board[i][j];
        }
    }

    int ans = 0;
    while (true) {
        // 국경선을 연다
        // {count, vecor<int>}
        memset(has_counted, false, sizeof(has_counted));
        mp.clear();

        int k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (has_counted[i][j]) continue;
                bfs(i, j, ++k);
            }
        }

        bool has_moved = false;
        // 각각의 연합에 대해서, 인구 이동을 진행한다.
        for (const auto& [id, v] : mp) {
            int size = v.size();
            if (size > 1) has_moved = true;
            int sum = 0;
            for (const auto& [y, x] : v) {
                sum += board[y][x];
            }

            int m = sum / size;
            for (const auto& [y, x] : v) {
                board[y][x] = m;
            }
        }
        // end phase
        if (!has_moved) {
            break;
        }
        ans++;
    }
    cout << ans;

    return 0;
}