package boj;

import java.io.*;
import java.util.*;

public class boj_1253_좋아 {
    static int N;
    static int[] arr;
    static int result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        simulation();
        System.out.println(result);
    }

    static void simulation(){
        // 오름차순 정렬
        Arrays.sort(arr);

        // 투포인터
        for (int i = 0; i < N; i++) {
            int num = arr[i];
            int left = 0, right = N-1;

            while(true){
                if(left == i) left++;
                if(right == i) right--;

                if(left >= right) break;

                if(arr[left] + arr[right] == num){
                    result++;
                    break;
                }

                if(arr[left] + arr[right] < num) left++;
                else if(arr[left] + arr[right] > num) right--;
            }
        }
    }
}
