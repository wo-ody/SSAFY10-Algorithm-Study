import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int T,N;
    static Node sanggeun = new Node(0,0);
    static Node[] conv;
    static Node rock = new Node(0,0);

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            sanggeun.x = Integer.parseInt(st.nextToken());
            sanggeun.y = Integer.parseInt(st.nextToken());

            conv = new Node[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                conv[i] = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            rock.x = Integer.parseInt(st.nextToken());
            rock.y = Integer.parseInt(st.nextToken());

            // simulation
            simulation();
        }
        System.out.println(sb);
    }
    static void get_distance(int[][] arr){
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                arr[i][j] = Math.abs(conv[i].x - conv[j].x) + Math.abs(conv[i].y - conv[j].y);
            }
        }
    }

    static String bfs(int[][] arr){
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            int d = Math.abs(conv[i].x - sanggeun.x) + Math.abs(conv[i].y - sanggeun.y);
            if(d > 1000) continue;
            else {
                q.add(i);
                visited[i] = true;
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();

            //visited[cur] = true;
            if(Math.abs(conv[cur].x - rock.x) + Math.abs(conv[cur].y - rock.y) <= 1000){
                return "happy";
            }
            for (int i = 0; i < N; i++) {
                if(cur == i || visited[i]) continue;
                int d = Math.abs(conv[i].x - conv[cur].x) + Math.abs(conv[i].y - conv[cur].y);
                if(d > 1000) continue;
                else {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return "sad";
    }


    static void simulation(){
        int[][] dis = new int[N][N];

        // 편의점, 락 사이의 거리 저장
        get_distance(dis);

        // bfs
        // 상근 - 락 or 상근 - 편의점 - 락
        if(Math.abs(sanggeun.x - rock.x) + Math.abs(sanggeun.y - rock.y) <= 1000)
            sb.append("happy").append("\n");
        else sb.append(bfs(dis)).append("\n");
    }


    static class Node{
        int x,y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
