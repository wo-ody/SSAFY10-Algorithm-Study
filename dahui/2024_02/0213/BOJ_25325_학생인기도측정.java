import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_25325_학생인기도측증 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());;
        for (int i = 0; i < n; i++) {
            map.put(st.nextToken(), 0);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                String str = st.nextToken();
                map.put(str, map.get(str)+1);
            }
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> {
            Integer value1 = map.get(o1);
            Integer value2 = map.get(o2);
            if (value1.equals(value2)) {
                return o1.compareTo(o2);
            }
            return value2.compareTo(value1);
        });

        StringBuilder sb = new StringBuilder();
        for (String key : list) {
            sb.append(key).append(" ").append(map.get(key)).append("\n");
        }
        System.out.println(sb);

    }
}
