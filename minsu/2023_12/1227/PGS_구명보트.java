// 무게 제한 limit
// 보트는 최대한 적게, 모든 승객을 구출
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int index = 0;
        
        for (int i = people.length - 1; i >= index; i--) {
            if (people[i] + people[index] <= limit) { // 최대 2명밖에 못탄다는 점을 고려
                index++;
                answer++;
            } else {
                answer ++;
            }
        }
        return answer;
    }
}
