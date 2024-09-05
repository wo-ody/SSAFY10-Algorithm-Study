import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Map<String, Integer> map = new HashMap<String, Integer>();
    static int N, count = 1;
    static StringBuilder sb = new StringBuilder();
    static String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
    static StringBuilder temp = new StringBuilder();
    static boolean[] visit = new boolean[9];

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        perm(0);

        for (int i = 0; i < N; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }

    static void perm(int idx) {
        if (idx == 9) {
            map.put(temp.toString(), count++);
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!visit[i]) {
                visit[i] = true;
                temp.append(alphabet[i]);
                perm(idx + 1);
                temp.delete(temp.length() - 1, temp.length());
                visit[i] = false;
            }
        }
    }
}
