package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805_나무_자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int line = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        int[] tree = new int[line];
        int max = 0;
        int min = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < line; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(tree[i], max);
        }

         while(min < max){
            int mid = (min + max)/2;
            long sum = 0;
            for(int h : tree){
                if(h - mid > 0) sum += h- mid;
            }

            if(sum >= destination){
                min = mid+1;
            }
            else{
                max = mid;
            }
        }
        System.out.println(min-1);
    }
}
