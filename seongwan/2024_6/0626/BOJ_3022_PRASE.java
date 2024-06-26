import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();

            if (!map.containsKey(temp)) {
                map.put(temp, 1);
            } else {
                int count = map.get(temp);

                if (count > i - count)
                    ans++;

                map.put(temp, count + 1);
            }
        }

        System.out.println(ans);
    }
}