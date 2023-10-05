import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int t = 0; t < 5; t++){
            char[][] map = new char[5][5];
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    map[i][j] = places[t][i].charAt(j);
                }
            }
            answer[t] = isIsolate(map);
        }
        return answer;
    }

    int isIsolate(char[][] map){
        for(int k = 0; k < 5; k++) for(int l = 0; l < 5; l++) if(map[k][l] == 'P' && !bfs(l, k, map)) return 0;
        return 1;
    }

    boolean bfs(int y, int x, char[][] map){
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(y, x));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int d = 0; d < 4; d++){
                int nx = dx[d] + node.x;
                int ny = dy[d] + node.y;
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || map[ny][nx] == 'X' || map[ny][nx] == ',' || distance(nx, ny, y, x) > 2) continue;
                map[ny][nx] = ',';
                if(map[ny][nx] == 'P') return false;
                else queue.offer(new Node(ny, nx));
            }
        }
        return true;
    }

    static int distance(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }


    static class Node{
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

