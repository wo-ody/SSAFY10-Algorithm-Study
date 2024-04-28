import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] map;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        simulation();

    }

    static void simulation(){
        Deque<Node> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            int cur = map[i];
            int idx = i + 1;

            while(!stack.isEmpty() && stack.peekLast().num < cur){
                stack.pollLast();
            }

            if(stack.isEmpty()) sb.append(0).append(" ");
            else sb.append(stack.peekLast().idx).append(" ");

            stack.addLast(new Node(cur,idx));
        }

        System.out.println(sb);
    }

    static class Node{
        int num,idx;
        Node(int num, int idx){
            this.num = num;
            this.idx = idx;
        }
    }
}
