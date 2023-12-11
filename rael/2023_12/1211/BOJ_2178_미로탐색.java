import java.io.*;
import java.util.*;

public class Main {

    static int row,col, map[][];
    static boolean[][] isVisited;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new int[row][col];
        isVisited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
			String[] s = br.readLine().split("");
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}

        bfs();
        System.out.println(map[row-1][col-1]);
    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        isVisited[0][0] = true;

        while(!q.isEmpty()){
            int[] position = q.poll();

            for(int i = 0; i<4; i++){
                int mr = position[0] + dr[i];
                int mc = position[1] + dc[i];

                if(mr<0 || mc<0 || mr>=row || mc >= col ) continue;
                if(isVisited[mr][mc] || map[mr][mc] == 0) continue;

                q.add(new int[] {mr, mc});
                map[mr][mc] = map[position[0]][position[1]] + 1;
                isVisited[mr][mc] = true;
            }
        }
    }
}
