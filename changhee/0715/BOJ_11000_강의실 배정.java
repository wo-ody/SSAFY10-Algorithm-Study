/**
 * 7.16 김창희
 * 백준11000_강의실 배정
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> schedule = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.start == o2.start) return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });
        PriorityQueue<Integer> endPoint = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            schedule.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int answer = 1;
        endPoint.offer(schedule.poll().end);
        while (!schedule.isEmpty()) {
            Node node = schedule.poll();
            endPoint.offer(node.end);
            if (node.start < endPoint.peek()) {
                answer++;
            } else {
                endPoint.poll();
            }
        }
        System.out.println(answer);

    }

    static class Node {
        int start, end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
