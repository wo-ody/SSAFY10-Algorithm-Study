import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String str1=input[0];
        String str2=input[1];
        
        
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= str2.length() - str1.length(); i++) {
            int cnt = 0;
            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(j) != str2.charAt(j + i)) {
                    cnt++;
                }
            }
            if (min > cnt) {
                min = cnt;
            }
        }

        System.out.println(min);
    }
}
