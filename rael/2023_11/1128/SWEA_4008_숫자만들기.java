import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T, N, min, max;
    static int num[];   //숫자 배열 - 숫자는 자리 고정
    static int opt[];   //연산자 배열 - 연산자는 자리 신경 x
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());

            //초기화
            opt = new int[4];
            num = new int[N];
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            //연산자 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++){
                opt[i] = Integer.parseInt(st.nextToken());
            }

            //숫자 입력
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }

            //풀이
            dfs(num[0], 1, opt[0], opt[1], opt[2], opt[3]);
            sb.append("#").append(t).append(" ").append(max-min).append("\n");
        }
        System.out.println(sb);
    }

    //dfs를 사용하여 연산자를 다 쓸 때 까지 깊이 들어가도록
    //이전 결과, 숫자 idx, 연산부호 남은 개수
    static void dfs(int res, int idx, int plus, int minus, int multiple, int divide){
        //기저조건(연산자는 N-1개 존재한다.)
        if(idx == N){
            //최대 최소 업데이트
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }

        //연산 시행
        if(plus > 0){
            dfs(res+num[idx], idx+1, plus-1, minus, multiple, divide);
        }
        if(minus > 0){
            dfs(res-num[idx], idx+1, plus, minus-1, multiple, divide);
        }
        if(multiple > 0){
            dfs(res*num[idx], idx+1, plus, minus, multiple-1, divide);
        }
        if(divide > 0){
            dfs(res/num[idx], idx+1, plus, minus, multiple, divide-1);
        }
    }
}
