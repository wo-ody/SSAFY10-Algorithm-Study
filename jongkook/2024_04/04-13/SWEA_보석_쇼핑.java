import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int kind = new HashSet<>(List.of(gems)).size();
        int length = Integer.MAX_VALUE, start = 0;
        Map<String, Integer> map = new HashMap<>();
        
        // i를 start라고 생각하고 진행
        for(int i = 0; i < gems.length; i++){
            // 보석이 없으면 1, 있다면 += 1
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            
            // gem가 1 이상 있다면 1을 줄이고 
            // 다음 gem을 본다
            while(map.get(gems[start]) > 1){
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            // System.out.println(map);
            
            if(map.size() == kind && length > (i - start)){
                length = i - start;
                answer[0] = start + 1;
                answer[1] = i + 1;
            }
        }
        
        return answer;
    }
}
