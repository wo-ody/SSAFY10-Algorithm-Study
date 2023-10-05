package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2512_예산 {
    static int N,M;
    static int[] arr;
    static int max_right;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max_right = Math.max(max_right,arr[i]);
        }
        M = Integer.parseInt(br.readLine());

        System.out.println(fun());
    }

    static int fun(){
        int left = 0;
        int right = max_right;
        
        while(left<=right) {
            int mid = (left+right)/2;
            long budget =0;
            for(int i=0; i<N; i++) {
                if(arr[i]>mid) budget += mid;
                else budget+= arr[i];
            }
            if(budget<=M) {
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        
        return right;
    }
}
