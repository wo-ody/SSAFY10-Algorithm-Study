#include <bits/stdc++.h>
using namespace std;
const int dir1[8][2] = {{-1, 2},
                        {-1, -2},
                        {2,  -1},
                        {-2, -1},
                        {1,  2},
                        {1, -2},
                        {2, 1},
                        {-2, 1}};
const int dir2[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
int dist[31][200][200];
int K, W, H, board[201][201];
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    cin >> K >> W >> H;
    for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
            cin >> board[i][j];
        }
    }


    // {dist, r, c, k}
    typedef tuple<int,int,int,int> tp;
    priority_queue<tp, vector<tp>, greater<>> pq;
    fill(&dist[0][0][0], &dist[30][199][200], 0x3f3f3f3f);
    pq.emplace(0, 0, 0, K);
    dist[K][0][0] = 0;
    while (!pq.empty()) {
        auto [acDist, r, c, k] = pq.top(); pq.pop();

        if (k > 0) {
            for (int d = 0; d < 8; d++) {
                int nr = r + dir1[d][0], nc = c + dir1[d][1];
                if (nr < 0 || nc < 0 || nr >= H || nc >= W || dist[k-1][nr][nc] <= dist[k][r][c] + 1)
                    continue;
                if (board[nr][nc] == 1) continue;
                dist[k-1][nr][nc] = dist[k][r][c] + 1;
                pq.emplace(dist[k - 1][nr][nc], nr, nc, k - 1);
            }
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dir2[d][0], nc = c + dir2[d][1];
            if (nr < 0 || nc < 0 || nr >= H || nc >= W || dist[k][nr][nc] <= dist[k][r][c] + 1)
                continue;
            if (board[nr][nc] == 1) continue;
            dist[k][nr][nc] = dist[k][r][c] + 1;
            pq.emplace(dist[k][nr][nc], nr, nc, k);
        }
    }

    int ans = 0x3f3f3f3f;
    for (int k = 0; k <= K; k++) {
        ans = min(ans, dist[k][H-1][W-1]);
    }
    cout << ((ans == 0x3f3f3f3f) ? -1 : ans);
    return 0;
}