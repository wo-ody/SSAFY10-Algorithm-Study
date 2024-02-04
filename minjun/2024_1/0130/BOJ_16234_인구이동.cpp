#include <bits/stdc++.h>

using namespace std;
int N, L, R, board[50][50];
const int dir[4][2] = {{-1, 0},
                       {1,  0},
                       {0,  -1},
                       {0,  1}};

bool check(const pair<int, int> &a, const pair<int, int> &b) {
    return L <= abs(board[a.first][a.second] - board[b.first][b.second]) &&
           abs(board[a.first][a.second] - board[b.first][b.second]) <= R;
}

vector <pair<int, int>> bfs(int r, int c, vector <vector<bool>> &visited) {
    vector <pair<int, int>> result = {make_pair(r, c)};
    visited[r][c] = true;

    queue <pair<int, int>> q;
    q.push({r, c});
    while (!q.empty()) {
        auto[y, x] = q.front();
        q.pop();
        for (int d = 0; d < 4; d++) {
            int ny = y + dir[d][0], nx = x + dir[d][1];
            if (ny < 0 || nx < 0 || ny >= N || nx >= N || !check({y, x}, {ny, nx}) || visited[ny][nx]) continue;
            visited[ny][nx] = true;
            result.emplace_back(ny, nx);
            q.push({ny, nx});
        }
    }

    return result;
}

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr), cout.tie(nullptr);

    cin >> N >> L >> R;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> board[i][j];
        }
    }

    int ans = 0;
    while (true) {
        vector <vector<bool>> visited(N, vector<bool>(N, false));
        bool cont = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                vector <pair<int, int>> v = bfs(i, j, visited);
                if (v.size() == 1) continue;
                cont = true;
                int sum = 0;
                for_each(v.begin(), v.end(), [&](const auto &p) { sum += board[p.first][p.second]; });
                for_each(v.begin(), v.end(), [&](const auto &p) { board[p.first][p.second] = sum / v.size(); });
            }
        }
        if (!cont) break;
        ans++;
    }
    cout << ans;
    return 0;
}