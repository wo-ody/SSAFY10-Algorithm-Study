package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1748_수_이어_쓰기_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer N = Integer.parseInt(br.readLine());

        int len = 0;
        
        int plus = 1;
        int compare = 10;
        
        int cnt = 0;
        for(int i = 1 ; i <= N ; i ++){
            
            if (i == compare){
                plus ++;
                compare *= 10;
                
            }
            
            cnt += plus;
        }
        System.out.println(cnt);
    }
}
