#include <bits/stdc++.h>
using namespace std;
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    int T;
    cin >> T;

    int parent[200002], rnk[200002], popul[200002];
    function<int(int)> find = [&](int u) {return (u == parent[u]) ? u : parent[u] = find(parent[u]);};
    auto merge = [&](int u, int v) {
        u = find(u), v = find(v);
        if (u == v) {
            cout << popul[u] << '\n';
            return false;
        }
        if (rnk[u] > rnk[v]) swap(u, v);
        else if (rnk[u] == rnk[v]) rnk[v]++;
//        cout << "u <- v: " << u << ", " << v << "\n";
//        cout << popul[v] << " -> " << popul[u] << "\n";
        parent[u] = v;
        popul[v] += popul[u];
        popul[u] = 0;
        cout << popul[v] << '\n';
        return true;
    };

    while (T--) {
        int F;
        cin >> F;

        generate(&parent[0], &parent[200002], [n = 0]() mutable {return n++;});
        fill(&rnk[0], &rnk[200002], 0);
        fill(&popul[0], &popul[200002], 0);

        map<string, int> mp;
        int cnt = 1;

        for (int i = 0; i < F; i++) {
            string u, v;
            cin >> u >> v;

            if (mp[u] == 0) { mp[u] = cnt++, popul[mp[u]] = find(mp[u]) ? 1 : 0; }
            if (mp[v] == 0) { mp[v] = cnt++, popul[mp[v]] = find(mp[v]) ? 1 : 0; }
            merge(mp[u], mp[v]);
        }
    }

    return 0;
}