#include <bits/stdc++.h>
using namespace std;

int main()
{   int N;

    cin>>N;
    long* dp=new long[N + 1];
    dp[1]=1;
    dp[2]=1;
    
    for(int i = 3; i<=N; i++){
        dp[i]=dp[i-2]+dp[i-1];
    }
    
    cout<<4*dp[N]+2*dp[N-1];
    ios_base::sync_with_stdio(0); 
    cin.tie(0);
    
    return 0;
}