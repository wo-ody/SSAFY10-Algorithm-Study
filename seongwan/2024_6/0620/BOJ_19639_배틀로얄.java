import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int X, Y, M, danger;
    static int[] enemy, drug;
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        danger = M / 2;

        enemy = new int[X];
        drug = new int[Y];

        for (int i = 0; i < X; i++) {
            enemy[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < Y; i++) {
            drug[i] = Integer.parseInt(br.readLine());
        }

        int drugidx = 0;
        for (int i = 0; i < X; i++) {
            M -= enemy[i];

            if (M <= 0) {
                System.out.println(0);
                return;
            }

            ans.append(-1 * (i + 1)).append("\n");

            while (M <= danger) {
                if (drugidx < Y) {
                    M += drug[drugidx++];
                    ans.append(drugidx).append("\n");
                } else {
                    break;
                }
            }
        }

        while (drugidx < Y) {
            ans.append(++drugidx).append("\n");
        }

        System.out.println(ans);
    }
}
