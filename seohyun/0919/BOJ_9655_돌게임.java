package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj_9655_돌게임 {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int result = (N/3) + (N - (3*(N/3)));

        if(result % 2 == 0){
            System.out.println("CY");
        }
        else{
            System.out.println("SK");
        }
    }
}
