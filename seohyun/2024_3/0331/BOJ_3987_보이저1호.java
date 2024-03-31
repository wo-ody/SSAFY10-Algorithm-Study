import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M,px,py;
    static char[][] map;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static char[] ch = {'U' , 'R', 'D', 'L'};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        st = new StringTokenizer(br.readLine());

        px = Integer.parseInt(st.nextToken()) - 1;
        py = Integer.parseInt(st.nextToken()) - 1;


        simulation();

    }
    static int change_dir(char c, int d){
        int nd = 0;

        if(c == '/'){
            if(d == 0) nd = 1;
            else if(d == 1) nd = 0;
            else if(d == 2) nd = 3;
            else if(d == 3) nd = 2;
        }
        else if(c == '\\'){
            if(d == 0) nd = 3;
            else if(d == 1) nd = 2;
            else if(d == 2) nd = 1;
            else if(d == 3) nd = 0;
        }

        return nd;
    }

    static Node start(int dir){
       Node result = new Node(dir, 0);
       boolean[][][] visited = new boolean[N][M][4];

       int cx = px;
       int cy = py;
       int cd = dir;
       //visited[cx][cy][dir] = true;

       while(true){
            cx += dx[cd];
            cy += dy[cd];

            if(cx < 0 || cx >= N || cy < 0 || cy >= M || map[cx][cy] == 'C'){
                result.cnt++;
                break;
            }

            if(visited[cx][cy][cd] && map[cx][cy] == '.'){
                result.cnt = Integer.MAX_VALUE;
                break;
            }

            if(map[cx][cy] != '.') cd = change_dir(map[cx][cy],cd);
            result.cnt++;
            visited[cx][cy][cd] = true;

       }

       return result;
    }
    static void simulation(){
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.cnt == o2.cnt) return o1.dir - o2.dir;
                return o2.cnt - o1.cnt;
            }
        });
        for (int k = 0; k < 4; k++) {
            Node cur = start(k);
            pq.add(cur);
        }

        Node cur = pq.poll();
        System.out.println(ch[cur.dir]);

        if(cur.cnt == Integer.MAX_VALUE) System.out.println("Voyager");
        else System.out.println(cur.cnt);

    }

    static class Node{
        int dir, cnt;
        Node(int dir, int cnt){
            this.dir = dir;
            this.cnt = cnt;
        }
    }
}
