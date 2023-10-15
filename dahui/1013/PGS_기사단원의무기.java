class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 1;
        
        for(int i=2; i<=number; i++){ //모든 기사들의 약수 개수 구하기
            int nightPower = 0;
            int max = i;
            for(int j=1; j<max; j++){ //한 수의 약수 개수 구하기
                if(i%j == 0){
                    if((i/j) == j ) {
                        nightPower += 1;
                        max = i/j;
                    }else {
                       max = i/j;
                        nightPower += 2; 
                    }
                }
            }
            if(nightPower > limit) answer += power;
            else answer += nightPower;
        }
        return answer;
    }
}
