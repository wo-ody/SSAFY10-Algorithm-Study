public class 삼총사 {
    public int solution(int[] number) {
        int answer = 0;
        int len = number.length;
        for(int i = 0; i<len-2; i++){
            for(int j = i+1; j<len-1; j++){
                for(int k = j+1; k<len; k++){
                    if(number[i]+number[j]+number[k] == 0){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

}
