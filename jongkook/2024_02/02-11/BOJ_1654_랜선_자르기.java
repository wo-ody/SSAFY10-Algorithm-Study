package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654_랜선_자르기 {
    static int num, minimum;
    static long lanMax;
    static int[] lines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        minimum = Integer.parseInt(st.nextToken());
        lines = new int[num];
        int max = 0;
        for(int n = 0; n < num; n++) {
            int value = Integer.parseInt(br.readLine());
            lines[n] = value;
            max = Math.max(max, value);
        }
        binarySearch(1, max);
        System.out.println(lanMax);

    }
    static void binarySearch(long start, long end){
        long mid = (start + end)/2;

        if(start > end) {
            return;
        }

        int key = 0;
        for(int line : lines) key += line/mid;

        if(key < minimum) binarySearch(start, mid-1);
        else {
            lanMax = Math.max(lanMax, mid);
            binarySearch(mid+1, end);
        }

    }
}
