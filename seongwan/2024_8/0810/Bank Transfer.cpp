#include <bits/stdc++.h>
using namespace std;

int main()
{   double k;

    cin>>k;
    double ans= k/100+25;
    
    if(ans<100)
        ans=100;
    
    if(ans>2000)
      ans=2000;
    
    cout<<fixed;
    cout.precision(2);
    cout<<ans;
    ios_base::sync_with_stdio(0); 
    cin.tie(0);
    
    return 0;
}