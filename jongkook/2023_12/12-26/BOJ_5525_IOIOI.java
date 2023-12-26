package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_5525_IOIOI {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int len = Integer.parseInt(br.readLine());
        char[] chr = br.readLine().toCharArray();

        int result = 0;
        int count = 0;

        for(int i=1; i < len - 1; i++) {
            if(chr[i - 1] == 'I' && chr[i] == 'O' && chr[i + 1] == 'I') {
                count++;

                if(count == n) {
                    count--;
                    result++;
                }
                i++;
            }
            else {
                count = 0;
            }
        }

        System.out.println(result);

    }
}
