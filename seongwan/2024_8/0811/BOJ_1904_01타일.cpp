#include <bits/stdc++.h>
using namespace std;

int main()
{   int N;

    cin>>N;
    vector<int> dp(N + 1);
    dp[0]=1;
    dp[1]=1;
    
    for(int i = 2; i<=N; i++){
        dp[i]=(dp[i-2]+dp[i-1])%15746;
    }
    
    cout<<dp[N];
    ios_base::sync_with_stdio(0); 
    cin.tie(0);
    
    return 0;
}