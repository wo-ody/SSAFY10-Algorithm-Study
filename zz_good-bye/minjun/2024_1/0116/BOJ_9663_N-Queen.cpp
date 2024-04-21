#include <bits/stdc++.h>
using namespace std;
bool rv[15], cv[15], rc[30], lc[61];
int N, ans;
bool canSet(int r, int c) {
    return !rv[r] && !cv[c] && !rc[r + c] && !lc[r - c + N];
}
void Set(int r, int c) {
    rv[r] = cv[c] = true;
    rc[r + c] = lc[r - c + N] = true;
}
// {dy, dx} = {-1, 1},
// y - r = |x - c|
// y - r = x - c  -> y - x = r - c 또는
// y - r = -x + c -> y + x = r + c
void unSet(int r, int c) {
    rc[r + c] = lc[r - c + N] = false;
    rv[r] = cv[c] = false;
}
void dfs(int row) {
    if (row == N) {
        ans++;
        return;
    }
    for (int i = 0; i < N; i++) {
        if (canSet(row, i)) {
            Set(row, i);
            dfs(row + 1);
            unSet(row, i);
        }
    }
}
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    cin >> N;
    dfs(0);
    cout << ans;
    return 0;
}