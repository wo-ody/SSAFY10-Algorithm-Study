#include <bits/stdc++.h>
using namespace std;
int N, M, V, matrix[1001][1001];
bool visited[1001];
void dfs(vector<int>& trace, int cur) {
    for (int i = 1; i <= N; i++) {
        if (!visited[i] && matrix[cur][i]) {
            visited[i] = true;
            trace.push_back(i);
            dfs(trace, i);
        }
    }
}
void bfs(int start) {
    memset(visited, false, sizeof(visited));
    queue<int> q;
    q.push(start);
    visited[start] = true;
    vector<int> result = {start};
    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && matrix[cur][i]) {
                visited[i] = true;
                result.push_back(i);
                q.push(i);
            }
        }
    }
    for (const auto &elem: result) {
        cout << elem << ' ';
    }
}
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    cin >> N >> M >> V;
    for (int i = 0; i < M; i++) {
        int u, v;
        cin >> u >> v;
        matrix[u][v] = matrix[v][u] = true;
    }

    vector<int> trace = {V};
    visited[V] = true;
    dfs(trace, V);
    for (auto c: trace) {
        cout << c << ' ';
    }
    cout << '\n';
    bfs(V);
    return 0;
}