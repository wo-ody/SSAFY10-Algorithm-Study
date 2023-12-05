import java.util.*;
import java.io.*;

class Main{
  static int n,m;
  static int[][] map;
  static Node start;
  
  static int[][] result;
  
  static int[] dx = {-1,1,0,0};
  static int[] dy = {0,0,-1,1};
  
  public static void main(String args[]) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    
    map = new int[n][m];
    result = new int[n][m];
    
    for(int i=0; i<n; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<m; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
        result[i][j] = -1;
        if(map[i][j] == 2){
          start = new Node(i,j);
        }
        if(map[i][j] == 0){
          result[i][j] = 0;
        }
      }
    }
    
    // 시작
    bfs();
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        System.out.print(result[i][j] + " ");
      }
      System.out.println();
    }
    
  }
  static void bfs(){
    Queue<Node> q = new ArrayDeque<>();
    boolean[][] visited = new boolean[n][m];
    
    q.add(start);
    visited[start.x][start.y] = true;
    result[start.x][start.y] = 0;
    
    while(!q.isEmpty()){
      Node cur = q.poll();
      for(int k=0; k<4; k++){
        int nx = cur.x + dx[k];
        int ny = cur.y + dy[k];
        
        if(nx<0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
        if(map[nx][ny] == 0){
          
          continue;
        }
        
        q.add(new Node(nx,ny));
        visited[nx][ny] = true;
        result[nx][ny] = result[cur.x][cur.y] + 1;
      }
    }
    
  }
  
  
  static class Node{
    int x,y;
    Node(int x, int y){
      this.x = x;
      this.y = y;
    }
  }
}
