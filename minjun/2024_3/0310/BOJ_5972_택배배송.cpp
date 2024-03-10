#define FASTIO cin.tie(0)->sync_with_stdio(false), cout.tie(0)
#define FILEMODE freopen("input.txt","r",stdin), freopen("output.txt","w",stdout)
//////////////////////////////////////////////////////////////////
#include <bits/stdc++.h>
using namespace std;

int T, W, dp[3][1001][31];
int val[1001];
int dfs(int p, int t, int w) {
    int& ret = dp[p][t][w];
    if (ret != -1)
        return ret;
    if (t == T) {
        return ret = (val[t] == p);
    }
    ret = (val[t] == p);
    int temp = 0;
    if (w >= 1)
        temp = max(temp, dfs(p % 2 + 1, t + 1, w - 1));
    temp = max(temp, dfs(p, t + 1, w));

    return ret = ret + temp;
}
int main(void){
#ifndef ONLINE_JUDGE
    FILEMODE;
#endif
    FASTIO;
//////////////////////////////////////////////////////////////////
    cin >> T >> W;

    for (int i = 1; i <= T; i++) {
        cin >> val[i];
    }
    fill(&dp[0][0][0], &dp[2][1000][31], -1);
    cout << dfs(1, 0, W);

    return 0;
}
