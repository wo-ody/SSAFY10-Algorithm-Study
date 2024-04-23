import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class BOJ_10546_배부른마라토너 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> set = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (set.containsKey(str)) {
                set.put(str, set.get(str)+1);
            }else{
                set.put(str, 1);
            }
        }

        for (int i = 0; i < N-1; i++) {
            String str = br.readLine();
            set.put(str, set.get(str)-1);
        }

        StringBuilder sb = new StringBuilder();
        for (String key : set.keySet()) {
            if (set.get(key) > 0) {
                sb.append(key);
                break;
            }
        }
        System.out.println(sb);
    }
}
