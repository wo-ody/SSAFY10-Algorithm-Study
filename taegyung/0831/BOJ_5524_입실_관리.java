package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5524_입실_관리 {
public static void main(String[]args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    for(int i = 0 ; i < N ; i ++){
        String s = br.readLine();
        System.out.println(s.toLowerCase());
    }
}


}
