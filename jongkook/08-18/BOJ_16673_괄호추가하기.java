package codingstudy;

import java.util.*;
import java.io.*;

public class BOJ_16673_괄호추가하기 {
    static int MAX = Integer.MIN_VALUE, n;
    static char[] chr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        chr = new char[n];
        chr = br.readLine().toCharArray();

        badget(2, chr[0] - '0');
        System.out.println(MAX);

    }
    static void badget(int i, int sum){
        if(i >= n){
            MAX = MAX > sum? MAX : sum;
            return;
        }
        badget(i+2, calc(sum, chr[i]-'0', chr[i-1]));

        // 오른쪽에 괄호 친 경우
        if (i + 2< n) {
            // 옆 괄호 먼저 계산
            int right = calc(chr[i]-'0', chr[i+2]-'0' , chr[i+1]);
            // 지금까지 결과와 합하기
            int left = calc(sum, right, chr[i-1]);
            badget(i+4, left);
        }

    }
    static int calc(int i, int j, char operator){
        if(operator == '+') return i + j;
        else if(operator == '-') return i - j;
        else return i * j;
    }
}
