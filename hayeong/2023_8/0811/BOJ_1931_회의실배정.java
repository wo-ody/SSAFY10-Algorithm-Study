import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 회의실배정_1931 {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        Arrays.sort(arr, (o1, o2) ->o1[1] ==o2[1]? o1[0]-o2[0]: o1[1] - o2[1]);


        int curEnd = arr[0][1];
        int ans = 1;
        for (int i = 1; i < N; i++) {
            if (curEnd > arr[i][0]) continue;
            curEnd = arr[i][1];
            ans++;
        }
        System.out.println(ans);
    }
}
