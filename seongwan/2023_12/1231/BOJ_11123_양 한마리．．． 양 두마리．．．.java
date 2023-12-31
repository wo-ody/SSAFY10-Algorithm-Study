import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int T,H,W;
    static StringBuilder sb = new StringBuilder();
    static char[][] map;
    static boolean[][] visit;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};


    public static void main(String[] args)throws Exception {
        T=Integer.parseInt(br.readLine());
        for (int t = 0; t <T ; t++) {
            int count=0;
            st=new StringTokenizer(br.readLine());
            H=Integer.parseInt(st.nextToken());
            W=Integer.parseInt(st.nextToken());

            map=new char[H][W];
            visit = new boolean[H][W];

            for (int i = 0; i <H ; i++) {
                map[i]=br.readLine().toCharArray();
            }//맵 입력

            for (int i = 0; i <H; i++) {
                for (int j = 0; j < W; j++) {
                    if(map[i][j]=='#'&&!visit[i][j]){
                        count++;
                        bfs(i,j);
                    }
                }
            }
            sb.append(count+"\n");
        }
        System.out.println(sb);
    }
    static void bfs(int r,int c){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {r,c});
        visit[r][c]=true;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];
            for (int dir = 0; dir < 4; dir++) {
                int nr =cr+dr[dir];
                int nc =cc+dc[dir];
                if(cango(nr,nc)){
                    visit[nr][nc]=true;
                    queue.add(new int[]{nr,nc});
                }
            }
        }
    }
    static boolean cango(int r,int c){
        if(r>=0&&r<H&&c>=0&&c<W&&!visit[r][c]&&map[r][c]=='#')
            return true;
        return false;
    }
}