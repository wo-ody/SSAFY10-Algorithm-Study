package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_3000_중간값_구하기 {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int initValue = Integer.parseInt(st.nextToken());
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            minHeap.add(initValue);
            int result = 0;
            for(int c = 0; c < count; c++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int big = Math.max(a, b);
                int small = Math.min(a, b);
                maxHeap.add(small);
                minHeap.add(big);
                if(minHeap.peek() < maxHeap.peek()){
                    int minVal = minHeap.poll();
                    int maxVal = maxHeap.poll();
                    minHeap.add(maxVal);
                    maxHeap.add(minVal);
                }

                result = (result + minHeap.peek()) % 20171109;
            }
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}
