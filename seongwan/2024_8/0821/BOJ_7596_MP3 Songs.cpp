#include <bits/stdc++.h>
using namespace std;

int main(){
   ios_base::sync_with_stdio(0); 
   cin.tie(0);    
   int T=1;

    while(true){
       int N;
       cin>>N;

       if(N==0)
        break;

    string * input = new string[N];
    cin.ignore();
    for (int i = 0; i < N; i++){
       getline(cin, input[i]);
    }
    sort(input,input+N);

    cout<<T++<<endl;
    for (int i = 0; i < N; i++){
        cout<<input[i]<<endl;
    }
 }
    
    return 0;
}