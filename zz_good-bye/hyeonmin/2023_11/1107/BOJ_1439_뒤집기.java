package Algorithm_2023.src.month11.day07;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1439_뒤집기 {

    static int min, ans;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int one = 0;	//전부 1로 바뀔때
        int zero = 0;	//전부0으로 바뀔때

        if(str.charAt(0) == '1') one++;
        else zero++;

        int len = str.length();

        for(int i = 1; i < len; i++) {
            if(str.charAt(i) != str.charAt(i - 1)){
                if(str.charAt(i) == '1') one++;
                else zero++;
            }
        }
        ans = Math.min(one, zero);
        System.out.println(ans);
    }
}