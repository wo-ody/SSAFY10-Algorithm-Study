import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1744_수묶기 {
    static int N;
    static ArrayList<Integer> arrP = new ArrayList<>();
    static ArrayList<Integer> arrN = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if (tmp > 0) {
                arrP.add(tmp);
            } else {
                arrN.add(tmp);
            }
        }
        Collections.sort(arrP, Collections.reverseOrder());
        Collections.sort(arrN);
        int ans = 0;
        int idx = 0;
        while (idx < arrP.size()) {
            if (idx + 1 < arrP.size() && arrP.get(idx) != 1 && arrP.get(idx + 1) != 1) {
                ans += arrP.get(idx) * arrP.get(idx + 1);
                idx += 2;
            } else {
                ans += arrP.get(idx);
                idx++;
            }
        }
        idx = 0;
        while (idx < arrN.size()) {
            if (idx + 1 < arrN.size()) {
                ans += arrN.get(idx) * arrN.get(idx + 1);
                idx += 2;
            } else {
                ans += arrN.get(idx);
                idx++;
            }

        }

        System.out.println(ans);

    }
}
