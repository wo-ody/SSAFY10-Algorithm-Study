import java.io.*;
import java.util.*;

// hmap<player, location>
// calling 순서대로 location 뽑아서, 자리 갱신 후 -> hmap 변경
// 1등인 선수의 이름은 불리지 않음
class Solution {
    static HashMap<String, Integer> hmap = new HashMap<>();
    
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        for(int i = 0; i< players.length; i++){
            String p = players[i];
            hmap.put(p,i);
        }
        
        for(int i = 0; i< callings.length; i++){
            String p = callings[i];
            int location = hmap.get(p);
            
            String beforeP = players[location - 1];
            players[location - 1] = p;
            players[location] = beforeP;
            
            hmap.put(p, location - 1);
            hmap.put(beforeP, location);
        }
        
        for(int i=0;i<players.length;i++){
            answer[i] = players[i];
        }
        
        
        return answer;
    }
}
