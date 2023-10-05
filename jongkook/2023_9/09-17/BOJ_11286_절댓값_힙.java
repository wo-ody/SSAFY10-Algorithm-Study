package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286_절댓값_힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int a1 = Math.abs(o1);
            int a2 = Math.abs(o2);
            if(a1 == a2) return o1 - o2;
            else return a1 - a2;
        });
        for(int t = 0; t < size; t++){
            int elem = Integer.parseInt(br.readLine());
            if(elem == 0){
                // 큐가 비어있지 않다면
                if(!pq.isEmpty()) System.out.println(pq.poll());
                // 큐가 비어있다면
                else System.out.println(0);
            }
            else pq.add(elem);
        }

    }
}
