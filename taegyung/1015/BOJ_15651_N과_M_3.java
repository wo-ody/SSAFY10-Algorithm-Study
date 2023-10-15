package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15651_N과_M_3 {
    static int [] nums;
    static int N,M;
    static int [] permList;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        permList = new int[M];
        for(int i = 1; i <= N ; i ++)
            nums[i-1] = i;
        perm(0);
        System.out.println(sb);
    }

    public static void perm(int cnt){
        if (cnt == M) {
//            System.out.println();
            for(int i = 0 ; i < M ; i ++){
//                System.out.print(permList[i]+ " ");
                sb.append(permList[i]).append(" ");
            }
            sb.append("\n");
//            System.out.println();
            return;
        }

        for(int i = 0 ; i < N ; i ++){
//            System.out.print(nums[i]+" ");
            permList[cnt] = nums[i];
            perm(cnt +1);
        }

    }
}
