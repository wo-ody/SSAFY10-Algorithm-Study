/*
 *  09.02 김창희
 *  BOJ_18405_경제적전염
 *
 *  [풀이]
 *  1. 주어진 초 만큼 큐를 인덱스로 접근하여 최소값으로 map을 채운다.
 *  2. 퍼뜨린 후 큐의 길이만큼 poll하여 최소값으로 퍼뜨려진 부분들을 방문 처리한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dx ={-1,0,1,0}, dy={0,1,0,-1};
    static Queue<Node> q= new ArrayDeque<>();
    static boolean[][] v;
    static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        v=new boolean[n][n];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j =0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>0){
                    v[i][j] = true;
                    q.offer(new Node(i,j));
                }
            }
        }


        st=new StringTokenizer(br.readLine());
        int s= Integer.parseInt(st.nextToken());
        int x= Integer.parseInt(st.nextToken());
        int y= Integer.parseInt(st.nextToken());

        System.out.println(bfs(x,y,s));
    }
    public static int bfs(int x,int y,int s){
        for(int i=0; i<s; i++){
            for(Node node : q) spread(node);
            int len = q.size();
            for(int j =0; j<len; j++){
                Node node = q.poll();

                for(int l = 0; l<4; l++){
                    int nx = node.x+dx[l];
                    int ny = node.y+dy[l];

                    if(nx<0||ny<0||nx>=n||ny>=n) continue;

                    if(!v[nx][ny] && map[nx][ny]>0){
                        v[nx][ny]=true;
                        q.offer(new Node(nx,ny));
                    }
                }
            }
        }
        return map[x-1][y-1];
    }
    public static void spread(Node node){
        for(int i = 0; i<4; i++){
            int nx = node.x+dx[i];
            int ny = node.y+dy[i];

            if(nx<0||ny<0||nx>=n||ny>=n||v[nx][ny]) continue;

            if(map[nx][ny] ==0 || map[nx][ny]>map[node.x][node.y]) map[nx][ny]=map[node.x][node.y];
        }
    }
    public
    static class Node{
        int x,y;

        public Node(int x,int y) {
            this.x = x;
            this.y=y;
        }
    }
}
