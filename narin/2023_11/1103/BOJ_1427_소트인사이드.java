import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();

        int len = n.length();

        char[] num = new char[len];

        for (int i = 0; i < len; i++) {
            num[i] = n.charAt(i);
        }

        Arrays.sort(num);

        for (int i = len - 1; i >= 0; i--) {
            System.out.print(num[i]);
        }
    }

}
