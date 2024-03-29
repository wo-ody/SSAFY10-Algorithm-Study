#include <bits/stdc++.h>
using namespace std;
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    int N, S;
    cin >> N >> S;

    vector<int> v(N);
    for (auto& elem : v) cin >> elem;

    int i = 0, j = 0, ans = 0x3f3f3f3f;
    long long sum = 0L;
    while (i <= j) {
        while (j < N && sum < S) {
            sum += v[j++];
        }
        if (sum >= S) {
            ans = min(ans, j - i);
        }
        sum -= v[i++];
    }
    ans = (ans == 0x3f3f3f3f) ? 0 : ans;
    cout << ans;
    return 0;
}
