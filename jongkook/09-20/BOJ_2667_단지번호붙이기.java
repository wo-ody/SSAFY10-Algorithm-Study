package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_2667_단지번호붙이기 {
    static int size, count, continuous;
    static int[][] xy = {{-1, 0} , {1, 0}, {0, -1}, {0, -2}};
    static char[][] lst;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        lst = new char[size][size];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < size; i++) lst[i] = br.readLine().toCharArray();

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                count = 0;
                if(lst[i][j] == '1') {
                    postNumber(i, j);
                    pq.add(count);
                    continuous++;
                }
            }
        }

        System.out.println(count);
        for(int i = 0; i <pq.size(); i++) System.out.println(pq.poll());
    }
    static void postNumber(int y, int x){
        for(int d = 0; d < 4; d++){
            int nx =  x + xy[d][0];
            int ny = y + xy[d][1];
            if(nx < 0 || ny < 0 || ny >= size || nx >= size || lst[ny][nx] != 1) continue;
            lst[ny][nx] = 1;
            count++;
            postNumber(ny, nx);


        }
    }
}
