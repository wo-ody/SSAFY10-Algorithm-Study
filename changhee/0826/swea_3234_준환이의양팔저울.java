/*
 *  08.26 김창희
 *  swea_3234_준환이의양팔저울
 *
 *  [풀이]
 *  1. 순열로 추를 올릴 순서를 찾는다
 *  2. 순서대로 오른쪽, 왼쪽에 올릴 모든 경우릐 수를 찾다 오른쪽이 더 커지면 return하고 depth가 n이 되면 결과값 증가
 *  
 *  [주의]
 *  모든 추를 올렸을때 합을 비교하는것 아니라 올릴때마다 무게를 비교하여 오른쪽이 더 커지면 안된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int n, result;
    static int[] chew,output;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            chew = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) chew[i] = Integer.parseInt(st.nextToken());

            result = 0;
            output=new int[n];
            v = new boolean[n];
            comb(0);
            answer.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(answer);
    }

    public static void comb(int depth) {
        if(depth == n){
            cal(0,0,0);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!v[i]){
                v[i] = true;
                output[depth] = chew[i];
                comb(depth + 1);
                v[i] = false;
            }
        }
    }

    public static void cal(int depth, int left, int right){
        if(left<right) return;
        if(depth == n){
            result++;
            return;
        }
        cal(depth+1,left+output[depth],right);
        cal(depth+1,left,right+output[depth]);
    }
}
