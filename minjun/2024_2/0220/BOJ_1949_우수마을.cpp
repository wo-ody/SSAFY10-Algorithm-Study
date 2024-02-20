#include <bits/stdc++.h>

using namespace std;
int N, dp[2][10001];
vector<int> v, adj[10001];
int dfs(int prev, int cur, int state) {
    int &ret = dp[state][cur];
    if (ret != -1) return ret;

    if (state == 1) {
        ret = v[cur - 1];
        for (auto nxt : adj[cur]) {
            if (nxt == prev) continue;
            ret += dfs(cur, nxt, 0);
        }
    } else if (state == 0) {
        ret = 0;
        for (auto nxt : adj[cur]) {
            if (nxt == prev) continue;
            ret += max(dfs(cur, nxt, 1), dfs(cur, nxt, 0));
        }
    }
    return ret;
}
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    cin >> N;
    v.resize(N);
    for (auto &elem: v) cin >> elem;

    for (int i = 0; i < N - 1; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    // 우수마을 선정
    // 적어도 하나의 우수 마을과는 인접해있어야함
    // root 가 일반 마을일 때, 자식이 모두 일반 마을일 경우는?
    // root가 우수 마을일 때에 block된다. pruning
    // 상위 문제는 부분 문제의 최적해로 구성되는 '최적 부분 구조'를 가지고 있다.

    fill(&dp[0][0], &dp[1][10001], -1);
    cout << max(dfs(-1, 1, 0), dfs(-1, 1, 1));


    return 0;
}