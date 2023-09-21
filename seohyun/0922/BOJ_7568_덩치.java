package boj;

import javax.sound.midi.SysexMessage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_7568_덩치 {
    static int N;
    static ArrayList<Node> graph = new ArrayList<>();

    static int[] result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        result = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int wei = Integer.parseInt(st.nextToken());
            int hei = Integer.parseInt(st.nextToken());

            graph.add(new Node(i,wei,hei));
        }

        solve();
        for(int r : result){
            System.out.print(r + " ");
        }

    }

    static void solve(){
//        Collections.sort(graph, new Comparator<Node>() {
//            @Override
//            public int compare(Node o1, Node o2) {
//                if(o1.hei == o2.hei) return o2.wei - o1.wei;
//                return o2.hei - o2.hei;
//            }
//        });

        for (int i = 0; i < N; i++) {
            int cnt = 0 ;
            int wei = graph.get(i).wei;
            int hei = graph.get(i).hei;
            for (int j = 0; j < N; j++) {
                if(i==j) continue;
                if(graph.get(j).wei > wei && graph.get(j).hei > hei) cnt++;
            }
            result[i] = cnt + 1;
        }

    }

    static class Node{
        int wei, hei;
        int idx;
        Node(int idx, int wei, int hei){
            this.idx = idx;
            this.wei = wei;
            this.hei = hei;
        }
    }
}
