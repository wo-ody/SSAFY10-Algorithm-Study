#include <bits/stdc++.h>
using namespace std;

int main()
{   int N;

    cin>>N;
 
    if(N<=3)
        cout<<1;
    else{    
    long* dp=new long[N + 1];
    dp[1]=1;
    dp[2]=1;
    dp[3]=1;
 
    for(int i = 4; i<=N; i++){
        dp[i]=dp[i-3]+dp[i-1];
    }
    
    cout<<dp[N];
     }   
    ios_base::sync_with_stdio(0); 
    cin.tie(0);
    
    return 0;
}
