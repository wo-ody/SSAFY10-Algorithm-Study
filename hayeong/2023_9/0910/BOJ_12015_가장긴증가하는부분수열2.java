import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12015_가장긴증가하는부분수열2 {
    static int N, ans;
    static int[] arr;

    static int[] LIS;

    public static void main(String[] args) throws NumberFormatException, IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        LIS = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이
        LIS[0] = arr[0];
        int len = 1;
        for (int i = 1; i < arr.length; i++) {
            if (LIS[len - 1] < arr[i]) {
                LIS[len] = arr[i];
                len++;
            } else {
                int start = 0;
                int end = len;
                while (start < end) {
                    int mid = (start + end) / 2;
                    if (LIS[mid] < arr[i]) start = mid + 1;
                    else end = mid;
                }
                LIS[start] = arr[i];
            }
        }
        System.out.println(len);
    }
}
