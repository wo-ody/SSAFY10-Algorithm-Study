import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 한번만등장한문자 {
    public String solution(String s){
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<chars.length; i++){
            map.put(chars[i], map.getOrDefault(chars[i], 0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(char c : map.keySet()){
            if(map.get(c) == 1){
                sb.append(c);
            }
        }
        char[] ans = sb.toString().toCharArray();
        Arrays.sort(ans);
        return String.valueOf(ans);
    }
}
