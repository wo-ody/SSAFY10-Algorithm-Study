package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_3758_KCPC {
    static int T,N,K,ID,M;
    static Node[] info;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            ID = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            info = new Node[N+1];
            for (int i = 0; i <= N ; i++) info[i] = new Node(i,0,0,0,new int[K+1]);

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                info[id].cnt += 1;
                info[id].problem[j] = Math.max(info[id].problem[j], s);
                info[id].time = i;
            }

            // simulation
            simulation();
        }
        System.out.println(sb);
    }

    static void simulation(){
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.score == o2.score && o1.cnt == o2.cnt) return o1.time - o2.time;
                else if(o1.score == o2.score) return o1.cnt - o2.cnt;
                else return o2.score - o1.score;
            }
        });

        for (int i = 1; i <= N ; i++) {
            int[] p = Arrays.copyOf(info[i].problem, K+1);

            int sum = 0;
            for (int j = 0; j <= K; j++) sum += p[j];

            pq.add(new Node(info[i].id,info[i].cnt,sum,info[i].time));
        }

        int rank = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            rank++;

            if(cur.id == ID){
                sb.append(rank).append("\n");
                return;
            }

        }
    }

    static class Node{
        int id,cnt,score,time;
        int[] problem = new int[K+1];

        public Node(int id, int cnt, int score, int time, int[] problem) {
            this.id = id;
            this.cnt = cnt;
            this.score = score;
            this.time = time;
            this.problem = problem;
        }

        public Node(int id, int cnt, int score, int time) {
            this.id = id;
            this.cnt = cnt;
            this.score = score;
            this.time = time;
        }
    }
}
