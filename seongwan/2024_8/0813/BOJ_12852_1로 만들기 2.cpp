#include <bits/stdc++.h>
using namespace std;

int N;
int* dp;


int search(){
    queue<int> q;

    q.push(N);
    int count =1;

    while(!q.empty()){
        int size = q.size();
       for (int i = 0; i < size; i++) {
        int now = q.front();
        q.pop();
        int next;

        if(now%3==0){
            next=now/3;
            if(next>=1&&dp[next]==0){
                dp[next]=3;
                q.push(next);
                  if(next==1){
                     return count;
                }
            }   
        }

        if(now%2==0){
            next=now/2;
            if(next>=1&&dp[next]==0){
                dp[next]=2;
                q.push(next);
                  if(next==1){
                     return count;
                }
            }   
        }
            next=now-1;
            if(dp[next]==0){
                dp[next]=1;
                q.push(next);
                  if(next==1){
                     return count;
                }
            }   
       }
       count++;
    }

    return 0;
}

int main()
{   cin>>N;
    dp= new int[N]();
    stack<int> stack;

    cout<<search()<<endl;
    
    int ans=1;
    while(true){
        stack.push(ans);
         if(ans==N)
           break;

        if(dp[ans]==1)
        ans+=1;
        else
        ans*=dp[ans];   
    }

    while (!stack.empty()){
    cout<<stack.top();
    cout<<" ";
    stack.pop();
    }
    

    ios_base::sync_with_stdio(0); 
    cin.tie(0);
    
    return 0;
}