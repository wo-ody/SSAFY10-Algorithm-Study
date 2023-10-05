import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 달리기경주 {
    public String[] solution(String[] players, String[] callings){
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i<players.length; i++){
            map.put(players[i], i);
        }
        for(String calling : callings){
            int idx = map.get(calling);
            if(idx > 0){
                String tmp = players[idx -1];
                players[idx -1] = players[idx];
                players[idx] = tmp;
                map.put(calling, idx - 1);
                map.put(tmp, idx);
            }
        }
        return players;
    }
}
