package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953_A_B {
    static int original, dest, result = -1;
    static HashMap<Long, Long> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        original = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        bfs(original);
//        System.out.println(map);
        System.out.println(result);
    }
    static void bfs(int start){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start, 1));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.value == dest) {
                result = (int) node.count;
                return;
            }
            if(node.value * 2 <= dest && !map.containsKey(node.value * 2)){
                map.put(node.value * 2, node.count+1);
                queue.add(new Node(node.value *2, node.count+1));
            }

            if(node.value * 10 + 1 <= dest && !map.containsKey(node.value * 10 + 1)){
                map.put(node.value * 10 + 1, node.count+1);
                queue.add(new Node(node.value * 10 + 1, node.count+1));
            }
        }
    }
    static class Node{
        long value, count;

        public Node(long value, long count) {
            this.value = value;
            this.count = count;
        }
    }
}
