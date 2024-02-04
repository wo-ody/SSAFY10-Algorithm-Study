package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_4179_불 {
    static int row, col, count;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static int[][] jTime, fTime;
    static char[][] maze;
    static Deque<Node> dq = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        int jihunX = 0;
        int jihunY = 0;
        maze = new char[col][row];
        jTime = new int[col][row];
        fTime = new int[col][row];

        for(int c = 0; c < col; c++){
            String str = br.readLine();
            for(int r = 0; r < row; r++){
                char ch = str.charAt(r);
                maze[c][r] = ch;
                if(ch == 'F') dq.addLast(new Node(c, r, ch, 0));
                if(ch == 'J'){
                    jihunX = r;
                    jihunY = c;
                }
            }
        }
        escape(jihunY, jihunX);
    }
    static void escape(int y, int x){
        dq.addLast(new Node(y, x, 'J', 0));
        while(!dq.isEmpty()){
            Node node = dq.pollFirst();
            int px = node.x;
            int py = node.y;
            char isFire = node.isFire;
            int count = node.count;

            if((px == 0 || py == 0 || px == row-1 || py == col - 1) && isFire == 'J'){
                System.out.println(count+1);
                return;
            }

            for(int d = 0; d < 4; d++){
                int ny = py + dy[d];
                int nx = px + dx[d];
                if(nx < 0 || ny < 0 || nx >= row || ny >= col || maze[ny][nx] == '#' || maze[ny][nx] == 'F') continue;
                if(isFire == 'J' && maze[ny][nx] != 'J'){
                    maze[ny][nx] = 'J';
                    dq.addLast(new Node(ny, nx, 'J', count+1));
                }
                else{
                    maze[ny][nx] = 'F';
                    dq.addLast(new Node(ny, nx, 'F', count+1));
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
    static class Node{
        int y, x, count;
        char isFire;

        public Node(int y, int x, char isFire, int count){
            this.y = y;
            this.x = x;
            this.isFire = isFire;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }
}
