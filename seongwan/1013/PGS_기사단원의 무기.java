import java.util.*;

class Solution {
    static int[] num;
    public int solution(int number, int limit, int power) {
       num=new int[number+1];
        Arrays.fill(num,1);//약수 1은 항상 포함하므로 1로 먼저 채워줌
        
        find(number,limit,power);
        int answer = 0;
        for(int i=1;i<=number;i++){
         answer+=num[i];
        }
        
        
       
        return answer;
    }
    static void find(int number,int limit,int power){
        for(int i=2; i<=number;i++){
        int max=i;
            for(int j=2; j<=max;j++){
                if(i%j==0){
                    num[i]++;
                    if(max!=j)
                        num[i]++;
                    max=i/j;
                }
            }
            if(num[i]>limit)
                num[i]=power;
        }
    }    
}
