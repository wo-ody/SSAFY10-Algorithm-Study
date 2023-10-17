import java.util.*;
// System.out.println();
class Solution {
    static HashMap<Integer, String> map = new HashMap<>();
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int a = 10;
        for (char i = 'A'; i <= 'F'; i++) {
            map.put(a++, i + "");
        }
        // list에 담겨 있는 요소들을 n진수로 변환
        String sc = change(n, t, m, p);
        // t번만큼 answer에 넣어주면 된다.
        for (int i = p-1; answer.length() < t; i += m) {
            answer.append(sc.charAt(i));
        }
        return answer.toString().toUpperCase();
    }
    
    // n진법을 넘겨준다면 그거에 맞춰서 num에 넣어주고
    static String change(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        sb.append("0"); // 먼저 0을 넣어주고
        for (int i = 1; i <= t*m; i++) {
            sb.append(Integer.toString(i, n));
            // s를 역순으로해서 sb에 넣어주고
        }
        return sb.toString();
    }
}
