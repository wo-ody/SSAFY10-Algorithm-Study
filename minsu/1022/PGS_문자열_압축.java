import java.util.*;
/*
1. 자르는 단위를 1부터 s길이까지 늘려나가고
2. map에 a : 1 첫 문자는 넣어두고, 인덱스1부터 탐색해서 같은 값이면 value + 1해주고 
3. 다른값이 나오면 value랑 key를 sb에 append해주고
4. 탐색이 다 끝나면 sb.toString()으로ㅓ length구해주고
*/
class Solution {
    static HashMap<String, Integer> map;
    static int min = Integer.MAX_VALUE;
    
    public int solution(String s) {
        int answer = 0;
        int size = s.length();
        
        int cut = 0;
        for (int i = 1; i < size; i++) { // 1부터 size단위까지
            map = new HashMap<>();
            int oneSize = 0;
            StringBuilder sb = new StringBuilder();
            map.put(s.substring(0, i), 1); // i단위로 먼저 자른 값은 넣고
            String st = s.substring(0, i); // 비교 기준을 잡고
            for (int j = i; j < size; j+=i) {
                if (j + i > size) {
                    // 잘린 문자열이 있을 수 있어서
                    sb.append(s.substring(j, size));
                    break;
                }
                String cur = s.substring(j, j + i);
                if (map.containsKey(cur)) {
                    map.put(cur, map.get(cur) + 1);
                    cut++;
                } else {
                    if (map.get(st) == 1) { // map에 value가 1일때는 st만append
                        sb.append(st);
                        oneSize++;
                    } else{
                        sb.append(map.get(st)).append(st);
                    }
                    map.remove(st);
                    st = cur;
                    map.put(st, 1);
                    // System.out.println(st);
                }
            }
            if (map.get(st) == 1) { // map에 value가 1일때는 st만append
                sb.append(st);
                oneSize++;
            } else {
                sb.append(map.get(st)).append(st);
            }
            String alpha = sb.toString();
            min = Math.min(min, alpha.length());
        }
        
        if (cut == 0) {
            return size;
        }
        return min;
    }
}
