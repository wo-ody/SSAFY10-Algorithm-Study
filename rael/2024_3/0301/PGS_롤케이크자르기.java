import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> map_1 = new HashMap<>(); // 형
        Map<Integer, Integer> map_2 = new HashMap<>(); // 동생
        
        for (int e : topping) {
            map_2.put(e, map_2.getOrDefault(e, 0) + 1);
        }
        
        for (int e : topping) {
            map_1.put(e, map_1.getOrDefault(e, 0) + 1);
            
            if (map_2.get(e) - 1 == 0)
                map_2.remove(e);
            else
                map_2.put(e, map_2.get(e) - 1);  
            
            if (map_1.size() == map_2.size())
                answer++;
        }

        return answer;
    }
}
