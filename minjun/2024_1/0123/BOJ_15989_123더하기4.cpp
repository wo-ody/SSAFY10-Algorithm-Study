#include <bits/stdc++.h>
using namespace std;
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    int T;
    cin >> T;
    while (T--) {
        int N, answer = 0;
        cin >> N;
        // a + 2b + 3c = n
        for (int c = 0; c <= (N + 1) / 3; c++) {
            for (int b = 0; 2 * b + 3 * c <= N; b++) {
                // int a = N - 2 * b - 3 * c;
                // assert(a >= 0);
                answer++;
            }
        }
        cout << answer << '\n';
    }

    return 0;
}