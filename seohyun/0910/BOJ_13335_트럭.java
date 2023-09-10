package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13335_트럭 {
    static int N,W,L;
    static Queue<Integer> truck;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        truck = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }
        
        Queue<Integer> bridge = new ArrayDeque<>();
        for(int w=0; w<W; w++) {
            bridge.offer(0);
        }
        int cnt = 0;
        int sum = 0;
        while(!bridge.isEmpty()) {
            sum -= bridge.poll();
            if(!truck.isEmpty()) {
                if(sum + truck.peek() <= L) {
                    int newTruck = truck.poll();
                    sum += newTruck;
                    bridge.offer(newTruck);
                }else {
                    bridge.offer(0);
                }
            }
            cnt++;
        }
        System.out.println(cnt);

    }

    
}
