package boj;

import java.io.*;
import java.util.*;

public class boj_20920_영단어암기는괴로워 {
    static int N,M;
    static HashMap<String,Integer> hmap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if(word.length() < M) continue;
            if(!hmap.containsKey(word)) hmap.put(word,1);
            else hmap.put(word,hmap.get(word) + 1);
        }
        simulation();
    }

    static void simulation(){
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.cnt == o2.cnt && o1.len == o2.len) return o1.word.compareTo(o2.word);
                else if(o1.cnt == o2.cnt) return o2.len - o1.len;
                else return o2.cnt - o1.cnt;
            }
        });
        for(String word : hmap.keySet()){
            pq.add(new Node(hmap.get(word), word.length(), word));
        }

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            sb.append(cur.word).append("\n");
        }

        System.out.println(sb);

    }

    static class Node{
        int cnt,len;
        String word;
        Node(int cnt, int len, String word){
            this.cnt = cnt;
            this.len = len;
            this.word = word;
        }
    }
}
