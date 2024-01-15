#include <bits/stdc++.h>
using namespace std;

map<char, int> pr = {{'+', 1}, {'-', 1}, {'*', 2}, {'/', 2}};
int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(0), cout.tie(0);

    string s, ans;
    cin >> s;

    stack<char> stk;

    for (auto c : s) {
        if ('A' <= c && c <= 'Z') {
            ans.push_back(c);
        } else {
            if (c != '(' && c != ')') {
                while (!stk.empty() && (pr[c] <= pr[stk.top()])) {
                    ans.push_back(stk.top());
                    stk.pop();
                }
            }
            if (c == ')') {
                while (!stk.empty() && stk.top() != '(') {
                    ans.push_back(stk.top());
                    stk.pop();
                }
                if (stk.top() == '(') stk.pop();
            } else {
                stk.push(c);
            }
        }
    }
    while (!stk.empty()) {
        ans.push_back(stk.top());
        stk.pop();
    }
    cout << ans;
    return 0;
}
