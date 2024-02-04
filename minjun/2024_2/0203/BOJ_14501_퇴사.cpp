#include <bits/stdc++.h>
using namespace std;
int N, ans = 0;
vector<pair<int,int>> v;
void dfs(int k, int acTime, int acSum) {
    if (k == N) {
        ans = max(ans, acSum);
        return;
    }
    auto [t, p] = v[k];
    if (acTime <= k + 1 && k + t + 1 <= N + 1) {
        dfs(k + 1, k + 1 + t, acSum + p);
    }
    dfs(k + 1, acTime, acSum);
}
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    cin >> N;
    v.resize(N);
    for (auto &elem : v) {
        cin >> elem.first >> elem.second;
    }

    // i번째 작업을 진행할 수 있는 경우, 현재까지의 누적 시간보다 더 i + 1이 크거나 같아야함
    // 누적 시간은 (i + 1) + v[i].first
    // 누적된 시간이 N+1을 초과해선 안된다.
    // 시작할 작업번호, 이전까지의 누적 시간, 이전까지의 누적 합
    dfs(0, 0, 0);
    cout << ans;
    return 0;
}