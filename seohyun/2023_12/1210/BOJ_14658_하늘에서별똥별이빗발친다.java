package boj;

import java.io.*;
import java.util.*;

public class boj_14658_하늘에서별똥별이빗발친다 {
    static int N,M,L,K;
    static ArrayList<Node> arr = new ArrayList<>();

    static int result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Node(x,y));
        }

        simulation();
        System.out.println(K - result);

    }

    static void simulation(){
        Collections.sort(arr, (n1,n2) -> n1.x - n2.x);

        for (int i = 0; i < K; i++) {
            ArrayList<Integer> y = new ArrayList<>();
            y.add(arr.get(i).y);
            for (int j = i+1; j < K ; j++) {
                if(arr.get(i).x + L >= arr.get(j).x){
                    y.add(arr.get(j).y);
                }
                else break;
            }

            // 별똥별 세주기
            Collections.sort(y);
            y.add(600000);
            for (int j = 0; j < y.size(); j++) {
                for (int k = j + 1; k < y.size() ; k++) {
                    if(y.get(j) + L < y.get(k)){
                        result = Math.max(result, k - j);
                        break;
                    }

                }
            }
        }
    }

    static class Node{
        int x,y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
