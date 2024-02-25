import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//사과 정보는 list에 넣기
//뱀 위치 Deque에 머리부터 꼬리 순으로 넣기
//뱡향 전환 정보 Queue에 넣기
//boolean[][] 으로 뱀 몸통이 있는 곳 표시
public class Main {
    static ArrayList<int[]> apple = new ArrayList<>();
    static Deque<int[]> snake = new ArrayDeque<>();
    static Queue<Node> dir = new ArrayDeque<>();
    static int[] dy = {0, 1, 0, -1}; //우, 하, 좌, 상
    static int[] dx = {1, 0, -1, 0};
    static boolean[][] visit;
    static int N,K,L,ans;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N][N];
        //사과 정보 저장
        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            apple.add(new int[]{y-1,x-1});
        }
        //방향 정보 저장
        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            char c = st.nextToken().toCharArray()[0];
            dir.add(new Node(s,c));
        }


        int y = 0;
        int x = 0;
        snake.add(new int[]{y,x});
        visit[0][0] = true;
        int time = 0;
        int dIdx = 0; //현재 방향
        while(true) {
            //이동할 위치
            y += dy[dIdx];
            x += dx[dIdx];
            if(y < 0 || x < 0 || y >= N || x >= N || visit[y][x]) {
                ans = time;
                break;
            }

            boolean flag = false; //사과가 없으면 false;
            for (int i=0; i<apple.size(); i++) {
                int[] a = apple.get(i);
                if(a[0] == y && a[1] == x) {
                    flag = true;
                    apple.remove(i); //사과 지워주기
                    break;
                }
            }
            //사과를 먹은 경우 : 꼬리는 그대로 두고 머리만 더하기
            if(!flag){
                //안먹은 경우 : 꼬리 빼고 머리 옮기기
                int[] tail = snake.pollLast();
                visit[tail[0]][tail[1]] = false;
            }

            snake.addFirst(new int[]{y,x});
            visit[y][x] = true;
            time++;
            //방향이 바뀌어야 한다면
            if (!dir.isEmpty() && dir.peek().s == time) {
                char c = dir.poll().d;
                if (c == 'D') { //오른쪽
                    dIdx = (dIdx + 1) % 4;
                } else { //왼쪽
                    dIdx = (dIdx + 3) % 4;
                }
            }
        }

        System.out.println(ans+1);

    }

    public static class Node {
        int s;
        char d;
        public Node (int s, char d) {
            this.s = s;
            this.d = d;
        }
    }
}
