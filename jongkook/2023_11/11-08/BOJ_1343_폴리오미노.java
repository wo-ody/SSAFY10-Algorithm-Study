package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1343_폴리오미노 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        str = str.replace("XXXX", "AAAA");
        str = str.replace("XX", "BB");

        if(str.contains("X")) System.out.println(-1);
        else System.out.println(str);
    }
}
