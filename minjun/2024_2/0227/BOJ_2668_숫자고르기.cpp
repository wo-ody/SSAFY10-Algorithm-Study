#include <bits/stdc++.h>
using namespace std;
vector<int> v;
bool visited[101] = {false};
bool dfs(const int start, int current) {
    // cycle여부를 반환
    int nxt = v[current];
    bool result = false;
    if (nxt == start) {
        result = true;
    } else if (!visited[nxt]){
        visited[nxt] = true;
        result = result || dfs(start, nxt);
        if (!result) visited[nxt] = false;
    }
    return result;
}
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    int N;
    cin >> N;
    v.resize(N + 1);

    for (int i = 1; i <= N; i++) cin >> v[i];

    for (int i = 1; i <= N; i++) {
        if (visited[i]) continue;
        visited[i] = true;
        if (!dfs(i, i)) visited[i] = false;
    }

    vector<int> ans;
    for (int i = 1; i <= N; i++) {
        if (visited[i]) ans.push_back(i);
    }
    cout << ans.size() << '\n';
    for (auto elem : ans) cout << elem << '\n';

    return 0;
}