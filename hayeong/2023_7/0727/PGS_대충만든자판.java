import java.util.HashMap;
import java.util.Map;

public class 대충만든자판 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<keymap.length; i++){
            for(int j = 0; j<keymap[i].length(); j++){
                map.put(keymap[i].charAt(j), Math.min(map.getOrDefault(keymap[i].charAt(j), j+1), j+1));
            }
        }
      
        for(int i = 0; i< targets.length; i++){
            int sum = 0;
            boolean isPossible = true;
            for(int j =0; j<targets[i].length(); j++){
                if(!map.containsKey(targets[i].charAt(j))){
                    answer[i] = -1;
                    isPossible = false;
                    break;
                }
                sum += map.get(targets[i].charAt(j));
            }
            if(isPossible)
                 answer[i] = sum;
        }
        return answer;
    }
}
