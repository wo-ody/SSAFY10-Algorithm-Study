#include <bits/stdc++.h>
using namespace std;
bool dfs(const string& s, string t) {
    // t에서 앞 뒤로 확인하여 뺀 다음, s를 만들 수 있는지 확인
    // s에서 t를 구성하는 것은 어렵다. 최적 부분 구조를 만들기 어렵기 때문
    // t -> s로 가는 것은 최적 부분 구조를 구성한다.
    if (s.size() == t.size()) {
        return s == t;
    }
    bool result = false;
    if (t.back() == 'A') {
        int sz = t.size();
        result = result || dfs(s, t.substr(0, sz - 1));
    }
    if (t[0] == 'B') {
        string nxt = t.substr(1);
        reverse(nxt.begin(), nxt.end());
        result = result || dfs(s, nxt);
    }
    return result;
}
int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    string S, T;
    cin >> S >> T;

    cout << (int)dfs(S, T);
    return 0;
}