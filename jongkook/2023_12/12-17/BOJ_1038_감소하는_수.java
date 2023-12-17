package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_1038_감소하는_수 {
    static ArrayList<Integer> lst = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n > 1022) System.out.println(-1);
        else if(n <= 10) System.out.println(n);
        else{
            for(int i = 0; i < 10; i++) dec(i, 1);
            Collections.sort(lst);

            System.out.println(lst.get(n));
        }
    }
    static void dec(int num, int idx){
        if(idx > 10) return;

        lst.add(num);
        for(int i = 0; i < num % 10; i++) {
            dec((num * 10) + i, idx + 1);
        }
    }

}
