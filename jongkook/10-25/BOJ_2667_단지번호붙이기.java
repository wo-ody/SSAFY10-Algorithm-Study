package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {
    static int size, danji = 1;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    static int[][] lst;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        lst = new int[size][size];
        for(int i = 0; i < size; i++) {
        	String s = br.readLine();
        	for(int j = 0; j < size; j++) {
        		lst[i][j] =  -1 * (s.charAt(j) - '0');
        	}
        }
        
        for(int i = 0; i < size; i++) {
        	for(int j = 0; j < size; j++) {
        		if(lst[i][j] == -1) mappingMap(i, j);
        	}
        }

        System.out.println(pq.size());
        while(!pq.isEmpty()) System.out.println(pq.poll());
    }
    
    static void mappingMap(int y, int x) {
    	Queue<Node> queue = new ArrayDeque<>();
    	queue.add(new Node(y,x));
    	lst[y][x] = danji;    	
    	int count = 1;
    	
    	while(!queue.isEmpty()) {
    		Node node = queue.poll();
    		for(int d = 0; d < 4; d++){
	            int nx =  node.x + dx[d];
	            int ny = node.y + dy[d];
	            if(nx < 0 || ny < 0 || ny >= size || nx >= size || lst[ny][nx] != -1) continue;
	            lst[ny][nx] = danji;	            
	            queue.offer(new Node(ny, nx));
	            count++;
    		}
    	}
    	pq.offer(count);
    	danji++;
    }
    
    static class Node{
    	int y, x;

		public Node(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
    	
    }
}
