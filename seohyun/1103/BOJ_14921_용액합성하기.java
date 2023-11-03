package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14921_용액합성하기 {
    static int N;
    static int[] input;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        simulation();


    }

    static void simulation(){
        int left = 0;
        int right = N - 1;

        int result = Integer.MAX_VALUE;

        while(left < right){

            int value = input[left] + input[right];
            if(Math.abs(result) > Math.abs(value)) result = value;

            if(value == 0){
                result = 0;
                break;
            }
            if(value < 0) left++;
            else right--;
        }

        System.out.println(result);
    }
}
