import java.util.*;
import java.io.*;
public class Solution_무선충전 {
    static int M,A, max;
    static int[][][] map;
    static int[][] bc;
    static boolean[][] visited;
    static int[] AMove;
    static int[] BMove;
    static int[] dr = {0,-1, 0, 1, 0};
    static int[] dc = {0,0,1, 0, -1};
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T;
        T=Integer.parseInt(br.readLine());
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            M =  Integer.parseInt(st.nextToken());
            A =  Integer.parseInt(st.nextToken());
            max = 0;
            map = new int[11][11][8];
            bc = new int[A][3];
            AMove = new int[M];
            BMove = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i= 0; i < M; i++) {
                AMove[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i= 0; i < M; i++) {
                BMove[i] = Integer.parseInt(st.nextToken());
            }
            int x,y,c,p;
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());
                bc[i][0] = y;
                bc[i][1] = x;
                bc[i][2] = p; // 충전량
                setChargeArea(i, y, x, c);
            }
            moving();
            sb.append("#"+test_case+" "+max+"\n");
        }
        System.out.println(sb.toString());
    }
    //a,b 움직이기
    public static void moving() {
        int[] a = new int[] {1,1};
        int[] b = new int[] {10,10};
        max += findLargestCharge(a,b);
        for (int i = 0; i < M; i++) {
            a[0] += dr[AMove[i]];
            a[1] += dc[AMove[i]];
            b[0] += dr[BMove[i]];
            b[1] += dc[BMove[i]];
            max += findLargestCharge(a,b);
        }
    }
    public static int findLargestCharge(int[] a, int[] b) {
        List<Integer> aBC = new ArrayList<>(); // a의 현재 위치에서 겹친 bc들
        List<Integer> bBC = new ArrayList<>();// b의 현재 위치에서 겹친 bc들
        for (int j = 0; j < A; j++) {
            if(map[a[0]][a[1]][j] == 1) {
                aBC.add(j);
            }
            if(map[b[0]][b[1]][j] == 1) {
                bBC.add(j);
            }
        }
        int maxCharge = 0;
        int abc, bbc;
        if(aBC.size() == 0) {
            for (int j = 0; j < bBC.size(); j++) {
                bbc = bBC.get(j);
                maxCharge = Math.max(bc[bbc][2], maxCharge);
            }
        }else if(bBC.size() == 0) {
            for (int i = 0; i < aBC.size(); i++) {
                abc = aBC.get(i);
                maxCharge = Math.max(bc[abc][2], maxCharge);
            }
        }else {
            for (int i = 0; i < aBC.size(); i++) {
                abc = aBC.get(i);
                for (int j = 0; j < bBC.size(); j++) {
                    bbc = bBC.get(j);
                    if(abc==bbc) {
                        maxCharge = Math.max(bc[abc][2], maxCharge);
                    }else {
                        maxCharge = Math.max(bc[abc][2]+bc[bbc][2], maxCharge);
                    }
                }
            }
        }
        return maxCharge;
    }
    //충전 영역 설정
    public static void setChargeArea(int idx, int r, int c, int length) {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[11][11];
        q.offer(new int[] {r, c});
        visited[r][c] = true;
        map[r][c][idx] = 1;
        while(!q.isEmpty()) {
            int[] loc = q.poll();
            visited[loc[0]][loc[1]] = true;
            for (int i = 0; i < 5; i++) {
                int nr = loc[0]+dr[i];
                int nc = loc[1]+dc[i];
                if(!check(nr,nc)) continue; //범위밖
                if(visited[nr][nc]) continue;
                if(Math.abs(r-nr)+Math.abs(c-nc) <= length) {
                    q.offer(new int[] {nr,nc});
                    map[nr][nc][idx] = 1;
                    visited[nr][nc] = true;
                }
            }
        }
    }
    public static boolean check(int r, int c) {
        return r > 0 && c > 0 && r < 11 && c < 11;
    }
}
