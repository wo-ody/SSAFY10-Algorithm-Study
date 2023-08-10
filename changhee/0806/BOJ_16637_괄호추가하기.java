/*
 *	08.06 김창희
 *	BOJ_16637_괄호추가하기
 *
 *  [틀린 풀이]
 *  1. 괄호가 들어 갈수 있는 모든 경우의 수를 따져 식을 새롭게 구성한다.
 *  2. 스택으로 계산을 수행
 *  3. 가독성뿐만 아니라 코드가 너무 길어진다.
 *
 *	[맞는 풀이]
 *  1. 재귀를 통해 현재 식을 바로 실행 할 것인지 나중에 실행할것인지로 괄호의 유무를 판단한다.
 *  2. 즉, A+B*C이면 한번은 (A+B)*C로 한번은 A+(B*C)로 계산을 하며 결과값을 재귀로 넘겨준다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] exp;
    static boolean[] v;
    static int n,answer=Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        exp = br.readLine().toCharArray();
        v = new boolean[n];
        dfs(1, exp[0]-48);
        System.out.println(answer);
    }

    public static void dfs(int start,int result) {
        if(start>=n) {
            answer=Math.max(answer,result);
            return;
        }
        dfs(start+2, cal(result,exp[start+1]-48,exp[start]));

        if(start<n-2){
            int prev = cal(exp[start+1]-48,exp[start+3]-48,exp[start+2]);
            dfs(start+4, cal(result,prev,exp[start]));
        }



    }

    public static int cal(int op1, int op2, int operation){
        int result = 0;
        switch (operation){
            case '+' : result= op1+op2; break;
            case '-' : result= op1-op2; break;
            case '*' : result= op1*op2; break;
        }
        return result;
    }
}
