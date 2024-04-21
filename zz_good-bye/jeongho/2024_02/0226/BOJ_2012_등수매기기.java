package algorithm2024.feb.day26;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2012_등수매기기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Student{
        int idx, rank;

        public Student(int idx, int rank) {
            this.idx = idx;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "idx=" + idx +
                    ", rank=" + rank +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Student> pq = new PriorityQueue<>((o1, o2) -> o1.rank-o2.rank);
        for (int i = 1; i <= N; i++) {
            pq.offer(new Student(i, Integer.parseInt(br.readLine())));
        }
        int rank = 1;
        long ans = 0L;
        while (!pq.isEmpty()) {
            Student student = pq.poll();
            if(rank!=student.rank){
                ans += Math.abs(rank - student.rank);
            }
            rank++;
        }
        System.out.println(ans);
    }
}
