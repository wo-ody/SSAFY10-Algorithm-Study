#define FASTIO cin.tie(0)->sync_with_stdio(false), cout.tie(0)
#define FILEMODE freopen("input.txt","r",stdin), freopen("output.txt","w",stdout)
//////////////////////////////////////////////////////////////////
#include <bits/stdc++.h>
using namespace std;
int N, K, M;
int ans[100'001], tmp[100'001];
vector<int> adjHypertube[100'001];
vector<int> adjNodes[100'001];
int main(void){
#ifndef ONLINE_JUDGE
    FILEMODE;
#endif
    FASTIO;
//////////////////////////////////////////////////////////////////
    // mesh topology를 구성하는 것은 메모리 초과 (최악의 경우, 10^12에 근사)
    cin >> N >> K >> M;
    // adjHypertube[i] := i번 역에서 연결되어 있는 하이퍼튜브의 vector
    // adjNodes[i] := i번 하이퍼튜브에서 갈 수 있는 정점들의 집합

    for (int i = 1; i <= M; i++) {
        for (int j = 0; j < K; j++) {
            int node;
            cin >> node;
            adjNodes[i].push_back(node);
            adjHypertube[node].push_back(i);
        }
    }

    // {passedBy, 현재 노드, 현재 노드가 hyperTube인가?}
    priority_queue<tuple<int, int, bool>, vector<tuple<int,int,bool>>, greater<>> PQ;
    PQ.push({1, 1, false});
    fill(ans, ans + 100'001, 1e9);
    fill(tmp, tmp + 100'001, 1e9);
    while (!PQ.empty()) {
        auto[passedBy, cur, isHypertube] = PQ.top(); PQ.pop();
        const vector<int>* adj;
        if (isHypertube) {
            adj = adjNodes;
        } else {
            adj = adjHypertube;
        }
        for (auto next: adj[cur]) {
            bool nxtIsHypertube = !isHypertube;
            if (!nxtIsHypertube && ans[next] <= passedBy + 1)
                continue;
            if (nxtIsHypertube && tmp[next] <= passedBy)
                continue;
            if (!nxtIsHypertube) {
                ans[next] = passedBy + 1;
            } else {
                tmp[next] = passedBy;
            }
            PQ.push({passedBy + !nxtIsHypertube, next, nxtIsHypertube});
        }
    }
    if (ans[N] == 1e9) ans[N] = -1;
    if (N == 1) ans[N]--;
    cout << ans[N];
    return 0;
}
