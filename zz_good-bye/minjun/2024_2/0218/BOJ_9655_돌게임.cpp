#include <bits/stdc++.h>

using namespace std;
vector<int> dp;
int dfs(int x) {
    int& ret = dp[x];

    if (ret != -1) {
        return ret;
    }

    if (x == 0) {
        return ret = 0;
    }


    ret = 0;
    if (x - 1 >= 0 && !ret) {
        if (dfs(x - 1) == 0) {
            ret = 1;
        }
    }
    if (x - 3 >= 0 && !ret) {
        if (dfs(x - 3) == 0) {
            ret = 1;
        }
    }

    return ret;
}
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    int N;
    cin >> N;
    dp.resize(N + 1, -1);

    if (dfs(N) == 1) {
       cout << "SK";
    } else {
        cout << "CY";
    }

    return 0;
}