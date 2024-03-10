#define FASTIO cin.tie(0)->sync_with_stdio(false), cout.tie(0)
#define FILEMODE freopen("input.txt","r",stdin), freopen("output.txt","w",stdout)
//////////////////////////////////////////////////////////////////
#include <bits/stdc++.h>
using namespace std;
int R, C, area[105][105];
char board[105][105];
bool destroy(int h, int opt){
    int k;
    if(opt == 0){
        k = 0;
        while(k < C && board[h][k] == '.') k++;
    }else{
        k = C-1;
        while(k >= 0 && board[h][k] == '.') k--;
    }
    if(k == -1 || k == C)
        return false;
    board[h][k] = '.';
    return true;
}
void adjust(){
    int id = 0;
    const int dir[4][2] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    map<int, vector<pair<int,int>>> mp;
    auto BFS = [&](pair<int,int> st){
        queue<pair<int,int>> Q;
        Q.push(st);
        area[st.first][st.second] = id;
        mp[id].push_back(st);

        while(!Q.empty()){
            int y, x;
            tie(y, x) = Q.front(); Q.pop();
            for(int d=0; d<4; d++){
                int ny = y + dir[d][0], nx = x + dir[d][1];
                if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                if(area[ny][nx] != -1 || board[ny][nx] == '.') continue;
                area[ny][nx] = id;
                Q.push({ny, nx});
                mp[id].push_back({ny, nx});
            }
        }
    };
    memset(area, -1, sizeof(area));
    for(int i=0; i<R; i++){
        for(int j=0; j<C; j++){
            if(area[i][j] != -1 || board[i][j] != 'x')
                continue;
            BFS({i,j});
            id += 1;
        }
    }

    for(auto &[a, v] : mp){
        sort(v.begin(), v.end(), greater<pair<int,int>>());
        int m = 0; // 평행이동
        bool f = true;
        while(f){
            for(auto [y, x] : v){
                if(y + m >= R || (area[y+m][x] != -1 && area[y+m][x] != a)) {
                    f = false;
                    break;
                }
            }
            if(f) m++;
        }
        m--;

        for(auto &[y,x] : v){
            board[y][x] = '.', board[y+m][x] = 'x';
            area[y][x] = -1, area[y+m][x] = a;
            y += m;
        }
    }

}
int main(void){
#ifndef ONLINE_JUDGE
    FILEMODE;
#endif
    FASTIO;
//////////////////////////////////////////////////////////////////
    cin >> R >> C;

    for(int i=0; i<R; i++){
        for(int j=0; j<C; j++)
            cin >> board[i][j];
    }

    int k;
    cin >> k;
    for(int i=0; i<k; i++){
        int m; cin >> m;
        bool res = destroy(R-m, i % 2);
        if(res)
            adjust();
    }
    for(int i=0; i<R; i++){
        for(int j=0; j<C; j++)
            cout << board[i][j];
        cout << '\n';
    }
    return 0;
}