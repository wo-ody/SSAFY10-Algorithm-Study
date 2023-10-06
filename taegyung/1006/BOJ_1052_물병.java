package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1052_물병 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 비트마스킹으로 1이 몇개가 있는지 파악.
        // 1. K의 갯수보다 비트마스킹이 많은 경우 -> 어떤 수와 더해서 K개만큼을 만들 수 있어야 한다.
        // 2. K의 갯수보다 비트마스킹이 적은 경우 -> 이대로 끝
                // ->
        // 3. 같은 경우는 말할 필요도 없다.

        // 4. 불가능한 경우는 사실 없다고 봐도 되지 않나.

        // K 가 1000까지면 1이 1000만큼 들어있다는 건데
        // 상당히 크긴 해도 안될건 없을듯?

//        Integer.toBinaryString()

//        StringBuilder sb = new StringBuilder();
//        for(int i = 0 ; i < 50 ; i ++){
//            sb.append(1);
//        }
//        System.out.println(Long.parseLong(sb.toString(),2));

        // 불가능은 없다고 판명

        int cnt = 0;

        while (Integer.bitCount(N) > K){
            N += 1;
            cnt += 1;
        }
        System.out.println(cnt);


    }
}
