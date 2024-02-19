package programmers.Lv2;

public class PGS_이진변환반복하기 {
	
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int time = 0; // 횟수
        int sum = 0; // 0의 개수
        int len = s.length(); // 처음 개수
        
        while (s.length() != 1) {
            int zero_cnt = 0;
            time++;
            for(int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') zero_cnt++;
            }
            sum += zero_cnt; // 합계에 더해주고
            len -= zero_cnt; 
            
            // len의 길이를 갖고 이진변화해서 s로 대체\ -> Integer.toBinaryString() 사용
            s = Integer.toBinaryString(len);
            len = s.length();
            System.out.println(s);
        }
        
        answer[0] = time;
        answer[1] = sum;
        return answer;
        
    }
    
}

