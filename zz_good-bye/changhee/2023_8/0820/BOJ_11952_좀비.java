/*
 *  08.20 김창희
 *  BOJ_11952_좀비
 *
 *  [풀이]
 *  1. bfs탐색으로 점령당한 도시로 부터 위험거리에 있는 도시들을 체크한다.
 *  2. 다익스트라로 점령당한 도시는 방문하지 않으며, 위헙도시 여부에 따라 가중치를 다르게 부여하며 탐색한다.
 *  3. 자료형 범위를 주의하자!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph=new ArrayList<>();
    static int[] zombieCity;
    static boolean[] isDanger;
    static boolean[] isZombie;
    static int n,m,k,s,p,q;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        s=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        p=Integer.parseInt(st.nextToken());
        q=Integer.parseInt(st.nextToken());

        //좀비에게 점령당한 도시는 숙박이 불가능하고
        //점령당한 도시로 부터 s로 갈수 있는 도시는 q원을 지불해야한다.
        zombieCity=new int[k];
        isZombie=new boolean[n+1];
        for(int i =0; i<k; i++) {
            zombieCity[i] = Integer.parseInt(br.readLine());
            isZombie[zombieCity[i]] =true;
        }

        for(int i =0; i<n+1; i++) graph.add(new ArrayList<>());

        for(int i =0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        isDanger=new boolean[n+1];
        for(int i =0; i<k; i++) findDangerousCity(zombieCity[i]);

        long answer = findRoute(1);
        System.out.println(answer);


    }
    public static long findRoute(int start){
        PriorityQueue<Node> queue =new PriorityQueue<>((o1,o2)->Long.co(o1.cost,o2.cost));
        long[] dist = new long[n+1];

        queue.offer(new Node(start,0));

        for(int i =0; i<n+1; i++) Arrays.fill(dist,Long.MAX_VALUE);
        dist[start]=0;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.x ==n)break;
            if(dist[node.x] < node.cost )continue;

            for (int nx : graph.get(node.x)) {
                if(isZombie[nx]) continue;

                int fee= isDanger[nx]?q:p;
                if(nx == n) fee=0;
                if(dist[nx] > node.cost+fee){
                    dist[nx] = dist[node.x]+fee;
                    queue.offer(new Node(nx,dist[nx]));
                }
            }
        }
        return dist[n];
    }

    public static void findDangerousCity(int start){
        Queue<Integer> queue =new ArrayDeque<>();
        boolean[] v= new boolean[n+1];
        int[] dist = new int[n+1];

        queue.offer(start);
        v[start] = true;

        while(!queue.isEmpty()){
            int x =queue.poll();

            if(dist[x] <= s) isDanger[x] = true;
            else break;

            for (int nx : graph.get(x)) {
                if(!v[nx]){
                    v[nx] = true;
                    dist[nx] = dist[x]+1;
                    queue.offer(nx);
                }
            }
        }
    }

    static class Node{
        int x;
        long cost;

        public Node(int x, long cost) {
            this.x = x;
            this.cost = cost;
        }
    }

}
