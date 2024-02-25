import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    static TreeMap<Integer, Integer> map;
    static int T,k,num;
    static String str;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            map = new TreeMap<>();
            k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                int idx = 0;
                st = new StringTokenizer(br.readLine());
                str = st.nextToken();
                num = Integer.parseInt(st.nextToken());

                if (str.equals("I")){
                    if(map.containsKey(num)){
                        map.put(num, map.get(num) + 1);
                    }else {
                        map.put(num, 1);
                    }
                }else {
                    if (!map.isEmpty()){
                        if (num == -1){
                           int key = map.firstKey();
                           int cnt = map.get(key);
                           if(cnt == 1) map.remove(key);
                           else map.put(key, cnt-1);
                        }else {
                            int key = map.lastKey();
                            int cnt = map.get(key);
                            if(cnt == 1) map.remove(key);
                            else map.put(key, cnt-1);
                        }
                    }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            }else {
                sb.append(map.lastKey()).append(" ");
                sb.append(map.firstKey()).append(" ");
            }
        }
        System.out.println(sb);
    }
}
