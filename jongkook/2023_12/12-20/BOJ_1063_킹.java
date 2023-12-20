package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1063_킹 {
    static int ky, kx, ry, rx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String rock = st.nextToken();
        int T = Integer.parseInt(st.nextToken());
        int[][] map = new int[8][8];

        ky = king.charAt(1)-'1';
        kx = king.charAt(0)-'A';
        ry = rock.charAt(1)-'1';
        rx = rock.charAt(0)-'A';

        for(int t = 0; t < T; t++) operator(br.readLine());

        System.out.printf("%c%c\n", (char)('A'+kx), (char) ('1' + ky) );
        System.out.printf("%c%c\n",(char) ('A'+rx),  (char) ('1'+ry));

    }
    static void printMap(int[][] map){
        for(int[] maps : map) System.out.println(Arrays.toString(maps));
    }
    static void operator(String oper){
        if(oper.equals("R") && rangeCheck(ky, kx+1)) {
            kx += 1;
            if(ky == ry && kx == rx){
                if(rangeCheck(ry, rx+1)) rx += 1;
                else {
                    kx -= 1;
                    return;
                }
            }
        }
        else if(oper.equals("L") && rangeCheck(ky, kx-1)) {
            kx -= 1;
            if(ky == ry && kx == rx) {
                if(rangeCheck(ry, rx-1)) rx -= 1;
                else {
                    kx += 1;
                    return;
                }
            }

        }
        else if(oper.equals("B") && rangeCheck(ky-1, kx)) {
            ky -= 1;
            if(ky == ry && kx == rx){
                if(rangeCheck(ry-1, rx))ry -= 1;
                else {
                    ky += 1;
                    return;
                }
            }

        }
        else if(oper.equals("T") && rangeCheck(ky+1, kx)){
            ky += 1;
            if(ky == ry && kx == rx){
                if(rangeCheck(ry+1, rx)) ry += 1;
                else {
                    ky -= 1;
                    return;
                }
            }

        }
        else if(oper.equals("RT") && rangeCheck(ky+1, kx+1)){
            kx += 1;
            ky += 1;
            if(ky == ry && kx == rx) {
                if(rangeCheck(ry+1, rx+1)){
                    rx += 1;
                    ry += 1;
                }
                else {
                    ky -= 1;
                    kx -= 1;
                    return;
                }

            }

        }
        else if(oper.equals("LT") && rangeCheck(ky+1, kx-1)){
            kx -= 1;
            ky += 1;

            if(ky == ry && kx == rx) {
                if(rangeCheck(ry+1, rx-1)){
                    rx -= 1;
                    ry += 1;
                }
               else {
                    kx += 1;
                    ky -= 1;
                   return;
                }
            }

        }
        else if(oper.equals("RB") && rangeCheck(ky-1, kx+1)) {
            kx += 1;
            ky -= 1;
            if(ky == ry && kx == rx) {
                if(rangeCheck(ry-1, rx+1)){
                    rx += 1;
                    ry -= 1;
                }
                else {
                    kx -= 1;
                    ky += 1;
                    return;
                }
            }

        }
        else if(oper.equals("LB") && rangeCheck(ky-1, kx-1)){
            kx -= 1;
            ky -= 1;
            if(ky == ry && kx == rx) {
                if(rangeCheck(ry-1, rx-1)){
                    rx -= 1;
                    ry -= 1;
                }
                else {
                    kx += 1;
                    ky += 1;
                    return;
                }
            }

        }

    }
    static boolean rangeCheck(int y, int x){
        // 범위를 벗어나면 false;
        // 범위를 벗어나지 않았다면 true;
//        System.out.println("-----------------------------------");
//        System.out.println(kingY + " " + kingX);
//        System.out.println(rockY + " " + rockX);
//        System.out.println("-----------------------------------");
        return y < 8 && x < 8 && y >= 0 && x >= 0;
    }
}
