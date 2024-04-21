#include <bits/stdc++.h>
using namespace std;
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    int G, P;
    cin >> G >> P;

    // P, G <= 10^5
    // 상수 시간에 근사하게 P를 도킹
    vector<int> parent(G + 1);
    generate(parent.begin(), parent.end(), [n = 0]() mutable { return n++; });
    function<int(int)> find = [&](int u) { return (u == parent[u]) ? u : parent[u] = find(parent[u]); };

    auto merge = [&](int u, int v) {
        u = find(u), v = find(v);
        if (u == v) return false;
        parent[u] = v;
        return true;
    };

    int ans = 0;
    for (int i = 0; i < P; i++) {
        int g;
        cin >> g;

        g = find(g);
        // find(g) 와 find(g) - 1 을 merge
        if (g == 0) break;
        ans++;
        merge(g, g - 1);
    }
    cout << ans;
    return 0;
}