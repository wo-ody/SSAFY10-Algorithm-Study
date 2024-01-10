package boj;

import java.io.*;
import java.util.*;

public class boj_1205_등수구하기 {
    static int N,T,P;
    static ArrayList<Node> input = new ArrayList<>();

    static int result = -1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        if(N==0){
            System.out.println(1);
            return;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input.add(new Node(Integer.parseInt(st.nextToken()), 0));
        }

        //
        simulation();
        System.out.println(result);
    }

    static void simulation(){
        input.add(new Node(T,1));

        Collections.sort(input, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.n == o2.n) return o1.w - o2.w;
                return o2.n - o1.n;
            }
        });

        int num = -1;
        int rank = -1;
        for (int i = 0; i < P; i++) {
            if(input.get(i).n != num) {
                num = input.get(i).n;
                rank = i+1;
            }

            if(input.get(i).w == 1){
                result = rank;
                break;
            }
        }
    }

    static class Node{
        int n,w;
        Node(int n, int w){
            this.n = n;
            this.w = w;
        }
    }



}
