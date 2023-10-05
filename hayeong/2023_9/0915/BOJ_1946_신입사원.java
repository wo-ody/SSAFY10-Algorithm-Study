import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1946_신입사원 {
    static int T, N;
    static ArrayList<int[]> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new ArrayList<>();
            int ans = 1;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int[] tmp = new int[2];
                tmp[0] = Integer.parseInt(st.nextToken());
                tmp[1] = Integer.parseInt(st.nextToken());
                arr.add(tmp);
            }

            Collections.sort(arr, (x, y) -> x[0] - y[0]);
            int min = arr.get(0)[1];
            for(int i = 1; i<N; i++){

                if(arr.get(i)[1]<min){
                    ans++;
                    min = arr.get(i)[1];
                }
            }
            System.out.println(ans);

        }

    }
}
