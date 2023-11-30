import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            // 짝수면 바로 다음 수
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String s = Long.toString(numbers[i], 2);
                int zeroIdx = s.lastIndexOf("0");
                // 1. 1로만 구성된 홀수
                if (zeroIdx == -1) {
                    s = "10" + s.substring(1, s.length());
                    answer[i] = Long.parseLong(s, 2);
                } else { // 2. 1과 0이 섞여있는 홀수
                    s = s.substring(0, zeroIdx) + "10" + s.substring(zeroIdx + 2, s.length());
                    answer[i] = Long.parseLong(s, 2);
                }
            }
        }
        return answer;
    }
}
