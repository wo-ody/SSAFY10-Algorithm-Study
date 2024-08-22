#include <bits/stdc++.h>
using namespace std;

int main(){
   ios_base::sync_with_stdio(0); 
   cin.tie(0);    
   long long N,M,X;

    cin >> N >> M >> X;

    long long * price =new long long[M];
    for (int i = 0; i < M; i++){
        cin>> price[i];
        
    }

    long long remain = X-N*price[M-1];
    long long count=0;

    for (int i = 0; i < M-1; i++){
        long long temp = remain/(price[i]-price[M-1]);
        if(temp+count>N){
            temp=N-count;
            count=N;
            remain=0;
        }
        else{
        count+=temp;

        }
        
        cout<<temp;
        cout<<" ";
        
        remain%=(price[i]-price[M-1]);
    }

    cout<<N-count;
    
    return 0;
}