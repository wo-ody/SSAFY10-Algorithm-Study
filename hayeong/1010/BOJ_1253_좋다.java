import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        int cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬
        Arrays.sort(arr);

        // 타겟 수를 for문으로 정함
        //      투포인터
        for (int idx = 0; idx < N; idx++) {
            int target = arr[idx];
            int start = 0;
            int end = N - 1;
            while (start < end) {
                int sum = arr[start] + arr[end];
                if (sum == target) { // 타깃과 합이 같을때
                    if (start != idx && end != idx) { // 두 수의 위치가 타깃의 인덱스와 같지 않을때맨 개수를 세어줌
                        cnt++;
                        break;
                    } else if (start == idx) { // start인덱스가 타깃 인덱스와 같다면 이동
                        start++;
                    } else if (end == idx) { // end 인덱스가 타깃 인덱스와 같다면 이동
                        end--;
                    }

                } else if (sum < target) { // 타깃보다 합이 작을때
                    start++;
                } else { // 타깃보다 합이 클 때
                    end--;
                }
            }
        }
        System.out.println(cnt);
    }
}
