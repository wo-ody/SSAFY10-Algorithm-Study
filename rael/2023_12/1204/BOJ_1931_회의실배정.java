import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class Main {
    public static int n;
    public static int cnt;
    public static int[][] arr;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
 
        }
 
        // 종료시간을 기준으로 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    // 종료시간이 같을 경우 시작시간이 더 빠른 애
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            }
        });
        int std = arr[0][1];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i][0] >= std) {
                // 어차피 정렬되어있어서 상관없음
                cnt++;
                std = arr[i][1];
            }
        }
        System.out.println(cnt);
 
    }
 
}
