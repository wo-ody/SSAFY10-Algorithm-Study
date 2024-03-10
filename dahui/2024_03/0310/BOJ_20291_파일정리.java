import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20291_파일정리 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, ".");
            st.nextToken();
            String str1 = st.nextToken();

            if (map.containsKey(str1)) {
                map.put(str1, map.get(str1) + 1);
            }else {
                map.put(str1, 1);
            }
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ").append(map.get(list.get(i))).append("\n");
        }
        System.out.println(sb);

    }

}
