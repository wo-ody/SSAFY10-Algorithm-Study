import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    int n = 5;
    int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            char[][] map = new char[n][n];

            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    map[x][y] = places[i][x].charAt(y);
                }
            }

            answer[i] = check(map);
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }
    public int check(char [][] map){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 'P' && !isPossible(map,i,j)){
                    return 0;
                }
            }
        }
        return 1;
    }
    public boolean isPossible(char[][] map,int x, int y){
        Queue<Node> q= new ArrayDeque<>();
        boolean[][] v= new boolean[n][n];

        q.offer(new Node(x,y));
        v[x][y] = true;

        while(!q.isEmpty()){
            Node node = q.poll();
            for(int i =0; i<4; i++){
                int nx= node.x+ dx[i];
                int ny= node.y+ dy[i];

                if(nx<0||ny<0||nx>=n||ny>=n ||map[nx][ny]=='X'|| v[nx][ny] ||getDistance(x,y,nx,ny)>2) continue;

                v[nx][ny] = true;
                if(map[nx][ny] == 'P'){
                    return false;
                }else{
                    q.offer(new Node(nx,ny));
                }
            }
        }
        return true;
    }
    public int getDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
