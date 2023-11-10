public class 부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long sum = 0;
        for(int i = 1; i<=count; i++){
            sum += price *i;
        }

        long tmp = money - sum;
        if(tmp > 0) answer = 0;
        else answer = Math.abs(tmp);

        return answer;
    }
}
