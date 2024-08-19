#include <bits/stdc++.h>
#include <map>
using namespace std;

int main(){   
    int N;
    long odd = 0;
    long even = 0;
    cin>>N;
    
    for (int i = 0; i < N; i++){
        int num;
        cin>>num; 
        if(i%2==0){
            even+=num;
        }else{
            odd+=num;
        }
    }
    
    if(N==3&&even>odd)
        cout<<-1;
    else{
        cout<<abs(odd-even);
    }


    ios_base::sync_with_stdio(0); 
    cin.tie(0);
    
    return 0;
}