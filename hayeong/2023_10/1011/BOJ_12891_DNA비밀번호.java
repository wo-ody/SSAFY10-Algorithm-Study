import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891_DNA비밀번호 {
    static int S, P, answer;
    static String str;
    static int[] cnt = new int[4];// a c g t

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        str = br.readLine();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cnt[i] = Integer.parseInt(st.nextToken());
        }

        int[] tmpCnt = new int[4];


        for (int i = 0; i < P; i++) {

            switch (str.charAt(i)) {
                case 'A':
                    tmpCnt[0]++;
                    break;
                case 'C':
                    tmpCnt[1]++;
                    break;
                case 'G':
                    tmpCnt[2]++;
                    break;
                case 'T':
                    tmpCnt[3]++;
                    break;
            }
        }

        if (check(tmpCnt)) answer++;

        for (int i = 1; i <= S - P; i++) {
            int prev = i - 1;
            switch (str.charAt(prev)) {
                case 'A':
                    tmpCnt[0]--;
                    break;
                case 'C':
                    tmpCnt[1]--;
                    break;
                case 'G':
                    tmpCnt[2]--;
                    break;
                case 'T':
                    tmpCnt[3]--;
                    break;
            }
            int next = i + P - 1;
            switch (str.charAt(next)) {
                case 'A':
                    tmpCnt[0]++;
                    break;
                case 'C':
                    tmpCnt[1]++;
                    break;
                case 'G':
                    tmpCnt[2]++;
                    break;
                case 'T':
                    tmpCnt[3]++;
                    break;
            }
            if (check(tmpCnt)) answer++;
        }
        System.out.println(answer);

    }

    static boolean check(int[] arr) {
        for (int i = 0; i < 4; i++) {
            if (cnt[i] > arr[i]) return false;
        }
        return true;
    }
}
