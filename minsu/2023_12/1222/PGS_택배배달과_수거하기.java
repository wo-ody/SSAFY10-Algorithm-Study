import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int d=0;
        int p=0;
        
        int size=cap;
        
        for(int i=n-1;i>=0;i--){
            if(deliveries[i]!=0){
                d=i+1;
                break;
            }
        }
        
         for(int i=n-1;i>=0;i--){
            if(pickups[i]!=0){
                p=i+1;
                break;
            }
        }
        
        while(true){  
            // 종료조건
            if(d==0&&p==0){
                break;
            }       
            //거리 계산
            answer+=(Math.max(d,p))*2;
               
            //배달하기
            while(true){
                if(d==0||cap==0&&deliveries[d-1]!=0){
                    break;
                }          
                if(cap>=deliveries[d-1]){
                    cap-=deliveries[d-1];
                    deliveries[d-1]=0;
                    d--;
                }
                else{
                    deliveries[d-1]-=cap;
                    cap=0;
                }             
                if(d==0){
                    break;
                }
                
                if(cap==0&&deliveries[d-1]==0){
                    d--;
                }
            }
            
            cap=size;
            
            //픽업하기
            while(true){
                if(p==0||cap==0&&pickups[p-1]!=0){
                    break;
                }
                
                if(cap>=pickups[p-1]){
                    cap-=pickups[p-1];
                    pickups[p-1]=0;
                    p--;
                }
                else{
                    pickups[p-1]-=cap;
                    cap=0;
                }
                
                if(p==0){
                    break;
                }
                
                if(cap==0&&pickups[p-1]==0){
                    p--;
                }
                      
            }
            
            cap=size;
        }
       
        
        
        return answer;
    }
}
