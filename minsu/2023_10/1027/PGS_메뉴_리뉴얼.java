import java.util.*;

class Solution {
    static String[] tgt;
    static String[] src;
    static HashMap<String, Integer> map;
    static List<String> answer = new ArrayList<>();
    
    public List<String> solution(String[] orders, int[] course) {
        
        for (int c : course) {
            map = new HashMap<>();
            // c는 tgt의 길이
            tgt = new String[c];
            for (String order : orders) {
                String[] o = order.split("");
                Arrays.sort(o);
                src = o;
                // System.out.println(Arrays.toString(o));
                comb(0, 0);
                // System.out.println();
                
            }
            // System.out.println();
            // map 정보를 다 담았다면 
            List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
            entryList.sort((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey()));
            int max = Integer.MIN_VALUE;
        
            for (Map.Entry<String, Integer> entry : entryList) {
                max = Math.max(max, entry.getValue());
                // System.out.println(entry.getKey() + " " + entry.getValue());
                if (entry.getValue() < max) continue;
                if (entry.getValue() <= 1) continue; 
                answer.add(entry.getKey());
            }
        }
        
        Collections.sort(answer);
        return answer;
    }
    
    static void comb(int srcIdx, int tgtIdx) {
        if (tgtIdx == tgt.length) {
            // System.out.println(Arrays.toString(tgt));
            StringBuilder sb = new StringBuilder();
            for (String t : tgt) {
                sb.append(t);
            }
            if (map.containsKey(sb.toString())) {
                map.put(sb.toString(), map.get(sb.toString()) + 1);
            } else {
                map.put(sb.toString(), 1);
                }
            return;
        }
        if (srcIdx == src.length) return;
        tgt[tgtIdx] = src[srcIdx];
        comb(srcIdx + 1, tgtIdx + 1);
        comb(srcIdx + 1, tgtIdx);
    }
    
    
}
