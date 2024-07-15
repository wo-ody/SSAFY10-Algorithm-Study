import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> count = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cityCode = st.nextToken().substring(0, 2);
            String stateCode = st.nextToken();

            if (!stateCode.equals(cityCode) && count.containsKey(stateCode + cityCode)) {
                ans += count.get(stateCode + cityCode);
            }

            String temp = cityCode + stateCode;
            if (count.containsKey(temp)) {
                count.put(temp, count.get(temp) + 1);
            } else {
                count.put(temp, 1);
            }
        }

        System.out.println(ans);
    }
}