package backtracking;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_15650_N과_M_2 {
    static int[] target;
    static int n, m;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        target = new int[m];
        recursive(1, 0);
    }
    static void recursive(int elem, int size){
        if(size == m) {
            for(int value : target) System.out.print(value + " ");
            System.out.println();
            return;
        }
        for(int i = elem; i <= n; i++){
            target[size] = i;
            recursive(i+1, size+1);
        }
    }
}
