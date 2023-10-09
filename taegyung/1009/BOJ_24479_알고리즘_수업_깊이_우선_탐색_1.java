package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class BOJ_24479_알고리즘_수업_깊이_우선_탐색_1 {
    static int [] visited;
    static int cnt = 1;
    static ArrayList<ArrayList<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int R = Integer.parseInt(st.nextToken());


        graph = new ArrayList<>();
        for(int i = 0 ; i <= N ; i ++){
            graph.add(new ArrayList<>());
        } // 0번째는 무시할 수 있게

        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 전체 정렬

        for(int i = 1 ; i <= N ; i ++){
            Collections.sort(graph.get(i));
        }

//        for(int i = 0 ; i <= N ; i ++)
//            System.out.println(graph.get(i));
        visited=  new int[N+1];
        visited[R] = 1;
        dfs(R);

        for(int i = 1 ; i <= N ; i ++)
            System.out.println(visited[i]);
    }
    public static void dfs(int startNode){
        // 재귀로 해보자

        for(int i = 0 ; i < graph.get(startNode).size() ; i ++){
                if (visited[graph.get(startNode).get(i)] == 0){
                    visited[graph.get(startNode).get(i)] = ++cnt;
//                    stack.add(graph.get(startNode).get(i));
                    dfs(graph.get(startNode).get(i));
                }
            }
    }

//    public static void dfs(int startNode){
//
//        visited[startNode] = 1;
//
//        ArrayDeque<Integer> stack = new ArrayDeque<>();
//
//        stack.push(startNode);
//
//        while(!stack.isEmpty()){
//            int tNode = stack.pop();
//
////            System.out.println(tNode); // 출력
//
//            for(int i = 0 ; i < graph.get(tNode).size() ; i ++){
//                if (visited[graph.get(tNode).get(i)] == 0){
//                    visited[graph.get(tNode).get(i)] = ++cnt;
//                    stack.add(graph.get(tNode).get(i));
//                }
//            }
//
//        }
//
//    }
}
