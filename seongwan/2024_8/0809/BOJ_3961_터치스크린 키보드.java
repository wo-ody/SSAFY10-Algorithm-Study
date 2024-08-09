import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T;
    static Map<Character, int[]> keyboard = new HashMap<>();


    public static void main(String[] args) throws Exception {
        init();

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            Map<String, Integer> ans = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            String origin = st.nextToken();
            int N = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                int dis = 0;
                for (int j = 0; j < origin.length(); j++) {
                    char a = origin.charAt(j);
                    char b = input.charAt(j);

                    if (a == b)
                        continue;

                    int[] aa = keyboard.get(a);
                    int[] bb = keyboard.get(b);

                    dis += Math.abs(aa[0] - bb[0]) + Math.abs(aa[1] - bb[1]);
                }

                ans.put(input, dis);
            }

            List<String> keys = new ArrayList<>(ans.keySet());
            keys.sort((e1, e2) -> ans.get(e1).equals(ans.get(e2)) ? e1.compareTo(e2) : ans.get(e1) - ans.get(e2));

            for (String key : keys) {
                sb.append(key).append(" ").append(ans.get(key)).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void init() {
        keyboard.put('q', new int[]{0, 0});
        keyboard.put('w', new int[]{0, 1});
        keyboard.put('e', new int[]{0, 2});
        keyboard.put('r', new int[]{0, 3});
        keyboard.put('t', new int[]{0, 4});
        keyboard.put('y', new int[]{0, 5});
        keyboard.put('u', new int[]{0, 6});
        keyboard.put('i', new int[]{0, 7});
        keyboard.put('o', new int[]{0, 8});
        keyboard.put('p', new int[]{0, 9});

        keyboard.put('a', new int[]{1, 0});
        keyboard.put('s', new int[]{1, 1});
        keyboard.put('d', new int[]{1, 2});
        keyboard.put('f', new int[]{1, 3});
        keyboard.put('g', new int[]{1, 4});
        keyboard.put('h', new int[]{1, 5});
        keyboard.put('j', new int[]{1, 6});
        keyboard.put('k', new int[]{1, 7});
        keyboard.put('l', new int[]{1, 8});

        keyboard.put('z', new int[]{2, 0});
        keyboard.put('x', new int[]{2, 1});
        keyboard.put('c', new int[]{2, 2});
        keyboard.put('v', new int[]{2, 3});
        keyboard.put('b', new int[]{2, 4});
        keyboard.put('n', new int[]{2, 5});
        keyboard.put('m', new int[]{2, 6});
    }
}