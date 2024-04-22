import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1062 {
    static int n;
    static int k;
    static boolean[] visited;
    static String[] word;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        visited = new boolean[26];
        word = new String[n];

        if (k < 5) {
            System.out.println(0);
            return;
        } else if (k == 26) {
            System.out.println(n);
            return;
        }

        /* 무조건 배워야하는 단어 */
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        for (int i = 0; i < n; i++) {
            String str = br.readLine().replaceAll("anta|tica", "");

            word[i] = str;
        }

        check(0, 0);
        System.out.println(answer);
    }

    static void check(int alpha, int count) {
        if (count == k - 5) {
            int temp = 0;
            for (int i = 0; i < n; i++) {
                boolean flag = true;

                for (int j = 0; j < word[i].length(); j++) {
                    /* 배우지않은 알파벳이 있는 경우 */
                    if (!visited[word[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    temp++;
                }
            }
            answer = Math.max(temp, answer);
            return;
        }

        for (int i = alpha; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                check(i, count + 1);
                visited[i] = false;
            }
        }
    }

}
