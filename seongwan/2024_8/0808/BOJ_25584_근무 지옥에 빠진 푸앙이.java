import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static Map<String, Integer> workTime = new HashMap<>();
    static StringTokenizer st;
    static int[] time = {4, 6, 4, 10};

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 7; k++) {
                    String now = st.nextToken();
                    if (now.equals("-"))
                        continue;

                    if (workTime.containsKey(now)) {
                        workTime.put(now, workTime.get(now) + time[j]);
                    } else {
                        workTime.put(now, time[j]);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int max = 0;
        List<Integer> emp = new ArrayList<>(workTime.values());
        for (Integer i : emp) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        if (max - min <= 12) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}