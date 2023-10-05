package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj_1744_수묶기 {
    static int N;
    static ArrayList<Integer> minus = new ArrayList<>();
    static ArrayList<Integer> plus = new ArrayList<>();
    static int isOne;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num <= 0) minus.add(num);
            else if(num > 1) plus.add(num);
            else if(num == 1 ) isOne++;
        }


        Collections.sort(minus);
        Collections.sort(plus , Collections.reverseOrder());
        int result = 0;

        for (int i = 0; i < plus.size(); i+=2) {
            if(i+1 < plus.size()) result += (plus.get(i) * plus.get(i+1));
            else result += plus.get(i);
        }

        for (int i = 0; i < minus.size(); i+=2) {
            if(i+1 < minus.size()) result += (minus.get(i) * minus.get(i+1));
            else result += minus.get(i);
        }

        System.out.println(result + isOne);
    }


}
