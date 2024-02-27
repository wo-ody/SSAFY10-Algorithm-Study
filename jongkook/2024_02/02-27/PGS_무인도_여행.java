import java.util.*;
import java.io.*;

class Solution {
    static char[][] island;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static Queue<Node> queue = new ArrayDeque<>();
    static int mapRow, mapCol;
    static ArrayList<Integer> answer;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public ArrayList<Integer> solution(String[] maps) {
        answer = new ArrayList<>();
        mapRow = maps[0].length();
        mapCol = maps.length;
        island = new char[mapCol][mapRow];
        visited = new boolean[mapCol][mapRow];
        
        for(int i = 0; i < mapCol; i++) island[i] = maps[i].toCharArray();
        
        for(int y = 0; y < mapCol; y++){
            for(int x = 0; x < mapRow; x++){
                if(island[y][x] == 'X') continue;
                if(visited[y][x]) continue;
                getFood(y, x);
            }
        }
        if(pq.isEmpty()) answer.add(-1);
        while(!pq.isEmpty()) answer.add(pq.poll());
        return answer;
    }
    
    void getFood(int y, int x){
        visited[y][x] = true;
        queue.add(new Node(y, x));
        int result = island[y][x] - '0';
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int d = 0; d < 4; d++){
                int ny = dy[d] + node.y;
                int nx = dx[d] + node.x;
                if(isRange(ny, nx) || visited[ny][nx] || island[ny][nx] == 'X') continue;
                visited[ny][nx] = true;
                queue.add(new Node(ny, nx));
                // char로 만들었기 때문에 문자를 숫자로 만들어주는 작업
                result = result + (island[ny][nx] - '0');
                // System.out.println(result);
            }
        }
        // System.out.println(pq);
        
        System.out.println("=====================================");
        System.out.println(y + " " + x);
        System.out.println(result);
        if(result == 0) return;
        pq.add(result);
    }
    /*
    1X2
    XXX
    3X4
    */
    
    // true라면 범위를 넘어간 것
    boolean isRange(int y, int x){
        return y < 0 || x < 0 || y >= mapCol || x >= mapRow;
    }
    
    class Node{
        int y, x;
        
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}
