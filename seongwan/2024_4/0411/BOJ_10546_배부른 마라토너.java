import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Map<String, Integer> count = new HashMap<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (!count.containsKey(s))
                count.put(s, 1);
            else
                count.put(s, count.get(s) + 1);
        }

        for (int i = 0; i < N - 1; i++) {
            String s = br.readLine();
            count.put(s, count.get(s) - 1);
        }

        for (String s : count.keySet()) {
            if (count.get(s) != 0) {
                System.out.println(s);
                return;
            }
        }
    }
}