package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_1515_수이어쓰기 {
    static String input = "";

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();

        int num_1 = 0;
        String num_2 = "";

        int p = 0;
        for (int i = 0; i < input.length(); i++) {
            char kijun = input.charAt(i);

            while(true){
                if(p == 0){
                    num_1++;
                    num_2 = String.valueOf(num_1);
                }

                char cur = num_2.charAt(p);

                if(cur == kijun){
                    p++;
                    if(p == num_2.length()) p = 0;
                    break;
                }else{
                    p = (p + 1) % num_2.length();
                }
            }
        }
        System.out.println(num_1);
    }
}
