package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2805_나무자르기 {
    static int N,M;
    static int[] tree;
    static int max_high = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max_high = Math.max(tree[i], max_high);
        }

        // 이분탐색
        System.out.println(BSearch());
    }
    static long cut(int height){
        long sum = 0;
        for (int i = 0; i < N; i++) {
            if(tree[i] > height) sum += (tree[i] - height);
        }
        return sum;
    }
    static int BSearch(){
        Arrays.sort(tree);
        int low = 0;
        int high = max_high;

        while(low <= high){
            int mid = (low + high)/2;
            long value = cut(mid);

            if(value < M) high = mid - 1;
            else low = mid + 1;
        }

        return high;
    }
}
