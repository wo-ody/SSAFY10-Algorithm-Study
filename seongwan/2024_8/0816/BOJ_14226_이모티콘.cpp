#include <bits/stdc++.h>
using namespace std;

int S;

int search(){
queue<pair<int, int>> queue;
bool (*check)[2000] = new bool[2000][2000];
memset(check, false, sizeof(bool) * 2000 * 2000);  // 배열을 false로 초기화

queue.push({1,0});//화면 속 이모티콘 수, 클립보드의 이모티콘 수
check[1][0]=true;
int count =1;
while(!queue.empty()){
  int size =queue.size();
  for (int i = 0; i < size; i++){
  auto  now = queue.front();
        queue.pop();

  int monitor = now.first;
  int clip = now.second;

//클립보드에서 화면에 붙여넣기 하는 경우
  if(clip!=0){
int nextMontior = monitor+clip;
if(nextMontior==S)
   return count;
if(nextMontior<2000&&!check[nextMontior][clip]){
check[nextMontior][clip]=true;
queue.push({nextMontior,clip});
      }
     }

//화면에서 이모티콘 1개를 빼는 경우
  if(monitor>2){
    int nextMontior = monitor-1;

    if(nextMontior==S)
       return count;
    if(nextMontior>=1&&!check[nextMontior][clip]){
      check[nextMontior][clip]=true;
      queue.push({nextMontior,clip});
      }
      }

//클립보드로 복사하는 경우
    if(!check[monitor][monitor]){
      check[monitor][monitor]=true;
      queue.push({monitor,monitor});
    }

   
    }
    count++;
  }
  return -1;
}

int main(){   
  cin>>S;

  cout<< search();
  ios_base::sync_with_stdio(0); 
  cin.tie(0);
    
    return 0;
}