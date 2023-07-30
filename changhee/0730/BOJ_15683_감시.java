/*
 *	7.30 김창희
 *	BOJ_15683_감시
 *
 *	[풀이]
 *	1. cctv가 있는 위치를 따로 저장하는 배열을 만든다.
 *	2. 위 배열의 크기만큼 상,하,좌,우 dir을 가진 배열을 만들어 모든 경우의 수를 따진다.
 *	3. cctv가 감시하는 동선이 중복되어도 카운트를 하지 않기 때문에 공용 방문 배열을 만들어 bfs를 진행한다.
 *	4. bfs실행 후 공용 방문 배열에서 아직 방문하지 않는 값들을 카운트한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static List<Node> cctvPoint = new ArrayList<>();
    static int[][] map;
    static int[] dx = {-1,0,1,0},dy={0,1,0,-1};
    static boolean[][] hurdle;
    static int n,m,cctvPointSize,answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st =new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map =new int[n][m];
        hurdle = new boolean[n][m];
        for(int i =0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >0 && map[i][j]<6) cctvPoint.add(new Node(i,j));
                if(map[i][j]!=0) hurdle[i][j] = true;
            }
        }

        cctvPointSize = cctvPoint.size();
        combDir(new int[cctvPointSize],0);
        System.out.println(answer);

    }

    public static void combDir(int[] output, int depth){
        if(depth == cctvPointSize){
            answer = Math.min(combLook(output),answer);
            return;
        }
        for(int i = 0; i<4; i++){
            output[depth]=i;
            combDir(output,depth+1);
        }
    }

    private static int combLook(int[] dirs) {
        boolean[][] lookPoint= new boolean[n][];
        for(int i =0; i<n; i++) lookPoint[i] = hurdle[i].clone();

        for (int i=0; i<cctvPointSize; i++) {
            Node node = cctvPoint.get(i);
            int cctv = map[node.x][node.y];
            int dir = dirs[i];

            if(cctv == 1){
                look(lookPoint,node,dir);
            }else if(cctv == 2){
                look(lookPoint,node,dir);
                look(lookPoint,node,(dir+2)%4);
            }else if(cctv == 3){
                look(lookPoint,node,dir);
                look(lookPoint,node,(dir+1)%4);
            }else if(cctv == 4){
                look(lookPoint,node,dir);
                look(lookPoint,node,(dir+1)%4);
                look(lookPoint,node,(dir+2)%4);
            }else if(cctv == 5){
                look(lookPoint,node,0);
                look(lookPoint,node,1);
                look(lookPoint,node,2);
                look(lookPoint,node,3);
            }
        }

        int result = 0;
        for(boolean[] points : lookPoint){
            for(boolean point : points) if(!point) result++;
        }
        return result;
    }

    private static void look(boolean[][] v, Node start, int dir) {
        Queue<Node> q= new LinkedList<>();

        q.offer(start);
        v[start.x][start.y] =true;

        while (!q.isEmpty()){
            Node node = q.poll();

            int nx= node.x+dx[dir];
            int ny= node.y+dy[dir];

            if(nx<0||ny<0||nx>=n||ny>=m||map[nx][ny] == 6) continue;

            v[nx][ny] = true;
            q.offer(new Node(nx,ny));
        }

    }

    static class Node{
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
