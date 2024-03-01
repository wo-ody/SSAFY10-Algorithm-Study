package boj;

import java.io.*;
import java.util.*;

public class boj_20006_랭킹전대기열 {
    static class Room{
        int kijun;
        int time;
        boolean isEnd;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.nickname.compareTo(o2.nickname));
    }
    static class Node{
        int level;
        String nickname;
        Node(int level, String nickname){
            this.level = level;
            this.nickname = nickname;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int P,M,L;

    static List<Room> rooms = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        st = new StringTokenizer(br.readLine());
        P = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            simulation(i,Integer.parseInt(st.nextToken()), st.nextToken());
        }

        // 출력
        // 방생성할때 이미 생성된 시점으로 넣어주기 때문에 차례대로 출력
        for (int i = 0; i < rooms.size(); i++) {
            Room cur = rooms.get(i);

            if(cur.isEnd){
                sb.append("Started!").append("\n");
                while(!cur.pq.isEmpty()){
                    Node n = cur.pq.poll();
                    sb.append(n.level).append(" ").append(n.nickname).append("\n");
                }
            }
            else{
                sb.append("Waiting!").append("\n");
                while(!cur.pq.isEmpty()){
                    Node n = cur.pq.poll();
                    sb.append(n.level).append(" ").append(n.nickname).append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    static void simulation(int time, int level, String nickname){

        for (int i = 0; i < rooms.size(); i++) {
            if(rooms.get(i).isEnd) continue;

            Room cur = rooms.get(i);
            if(cur.kijun - 10 <= level && level <= cur.kijun + 10){
                cur.time = time;
                cur.pq.add(new Node(level,nickname));

                if(cur.pq.size() == M) cur.isEnd = true;

                return;
            }
        }

        // 새로운 방 파기
        Room newRoom = new Room();
        newRoom.kijun = level;
        newRoom.time = time;
        newRoom.pq.add(new Node(level,nickname));

        if(newRoom.pq.size() == M) newRoom.isEnd = true;
        rooms.add(newRoom);
    }

}
