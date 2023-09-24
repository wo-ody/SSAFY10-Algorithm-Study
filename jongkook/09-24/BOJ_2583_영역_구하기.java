package graph;

import java.io.*;
import java.util.*;

public class BOJ_2583_영역_구하기 {
    static final int dx[] = {0,0,1,-1};
    static final int dy[] = {1,-1,0,0};
    static int n,m,count;
    static int map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int y=y1; y<y2; y++) {
                for(int x=x1; x<x2; x++){
                    map[y][x] = 1;
                }
            }
        }

        ArrayList<Integer> aList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0) {
                    count = 0;
                    dfs(i,j);
                    aList.add(count);
                }
            }
        }

        Collections.sort(aList);

        sb.append(aList.size()).append('\n');
        for(int i : aList)  {
            sb.append(i + " ");
        }

        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        map[x][y] = 1;
        count ++;

        for(int k=0; k<4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(0<=nx && nx<n && 0<=ny && ny < m) {
                if(map[nx][ny] == 0) {
                    dfs(nx,ny);
                }
            }
        }
    }

}
