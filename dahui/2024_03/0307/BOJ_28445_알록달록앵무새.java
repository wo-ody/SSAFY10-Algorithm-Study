import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class BOJ_28445 {
    static HashMap<String, HashSet<String>> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] parent = new String[4];

        parent[0] = st.nextToken();
        parent[1] = st.nextToken();
        st = new StringTokenizer(br.readLine());
        parent[2] = st.nextToken();
        parent[3] = st.nextToken();

        for (int i=0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                if (map.containsKey(parent[i])){
                    HashSet<String> set = map.get(parent[i]);
                    set.add(parent[j]);
                    map.put(parent[i], set);
                }else {
                    HashSet<String> set = new HashSet<>();
                    set.add(parent[j]);
                    map.put(parent[i], set);
                }
            }
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            ArrayList<String> value = new ArrayList<>(map.get(list.get(i)));
            Collections.sort(value);
            for (int j = 0; j < value.size(); j++) {
                sb.append(list.get(i)).append(" ").append(value.get(j)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
