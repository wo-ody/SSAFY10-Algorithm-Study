package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2638_치즈 {
    static int col, row, count;
    static int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    static boolean[][] cheese, air, cheeseVisited, airVisited;
    static ArrayList<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());

        cheese = new boolean[col][row];
        air = new boolean[col][row];
        cheeseVisited = new boolean[col][row];
        airVisited = new boolean[col][row];

        for(int c = 0; c < col; c++){
            st = new StringTokenizer(br.readLine());
            for(int r = 0; r < row; r++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    cheese[c][r] = true;
                }

            }
        }
        /*
        * 1. 공기의 상태를 저장하기 위한 배열을 만든다.
        * 2. 공기를 기준으로 가장자리부터 BFS 돌려서 돌릴수있는 모든 곳을 돌린다.
        * 3. 그리고 해당 배열에서 BFS로 도달하지 못하는 곳은 내부에 공기가 막혀있는 곳이다.
        * 4. 그러므로 공기 배열과 치즈 배열 두 개를 만들어야 한다!
        * */
        while(remainCheese()){
            airBFS();
            list = new ArrayList<>();
            for(int c = 0; c < col; c++){
                for(int r = 0; r < row; r++){
                    if(cheese[c][r]){
                        cheeseBFS(c, r);
                    }
                }
            }
            for(boolean[] v : air){
                Arrays.fill(v, false);
            }

            for(Node node : list){
                cheese[node.y][node.x] = false;
            }
            
            count++;
        }
//        printArray(air);
        System.out.println(count);
//        airBFS();
//        printArray(air);
    }

    static void airBFS(){
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0));
        air[0][0] = true;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            for(int d = 0; d < 4; d++){
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];
                if(ny < 0 || nx < 0 || ny >= col || nx >= row || air[ny][nx] || cheese[ny][nx]) continue;
                air[ny][nx] = true;
                queue.offer(new Node(ny, nx));
            }
        }
    }

    // air 는 false 라면 공기가 닿지 않는 곳이다.
    // cheese 는 true라면 현재 치즈가 있는 곳이다.
    static void cheeseBFS(int y, int x){
        int cnt = 0;
        for(int d = 0; d < 4; d++){
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny < 0 || nx < 0 || ny >= col || nx >= row || !air[ny][nx] || cheese[ny][nx]) continue;
            cnt++;
        }
        if (cnt >= 2) list.add(new Node(y, x));
    }

    static boolean remainCheese(){
        for(boolean[] v : cheese)
            for(boolean b : v)
                if(b) return true;

        return false;
    }
    static void printArray(boolean[][] ary){
        for(boolean[] v : ary){
            System.out.println(Arrays.toString(v));
        }
    }
    static class Node{
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
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
