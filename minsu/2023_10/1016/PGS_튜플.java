import java.util.*;
// System.out.println();
class Solution {
    static List<Integer> list = new ArrayList<>();
    
    public List<Integer> solution(String s) {
        int[] answer = {};
        s = s.substring(2, s.length() - 2);
        s = s.replace("},{", "-");
        String [] arr = s.split("-");
        // 문자열 길이가 짧은 순으로 정렬
        Arrays.sort(arr, (o1, o2) -> o1.length() - o2.length()); 
        
        for(String s1 : arr) {
            String[] x = s1.split(",");
            for (String x1 : x) {
                int n = Integer.parseInt(x1);
                if(list.contains(n)) continue;
                list.add(n);
            }
        }
        return list;
    }
}
