package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1026_보물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer stA = new StringTokenizer(br.readLine());
        StringTokenizer stB = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        for(int ab = 0; ab < n; ab++){
            A[ab] = Integer.parseInt(stA.nextToken());
            B[ab] = Integer.parseInt(stB.nextToken());
        }
        A = Arrays.stream(A).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        Arrays.sort(B);

        int result = 0;

        for(int ab = 0; ab < n; ab++){
            result += A[ab] * B[ab];
        }
        System.out.println(result);
    }
}
