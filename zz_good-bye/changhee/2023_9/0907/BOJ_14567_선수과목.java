import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws Exception {
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	st=new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	for(int i =0; i<n+1; i++) graph.add(new ArrayList<>());
    	
    	for(int i =0; i<m; i++) {
    		st=new StringTokenizer(br.readLine());
    		int a= Integer.parseInt(st.nextToken());
    		int b= Integer.parseInt(st.nextToken());
    		
    		graph.get(a).add(b);
    	}
    	
    	int[] e= new int[n+1];
    	for(List<Integer> list: graph) {
    		for(int x : list) {
    			e[x]++;
    		}
    	}
    	
    	int[] sum = new int[n+1];
    	Arrays.fill(sum,1);
    	Queue<Integer> q= new ArrayDeque<>();
    	for(int i =1; i<n+1; i++) {
    		if(e[i]==0) q.offer(i);
    	}
    	
    	while(!q.isEmpty()) {
    		int x=q.poll();
    		
    		for(int nx: graph.get(x)) {
    			e[nx]--;
    			if(e[nx]==0) {
    				sum[nx] = sum[x]+1;
    				q.offer(nx);
    			}
    		}
    	}
    	
    	StringBuilder answer = new StringBuilder();
    	for(int i =1; i<n+1; i++) {
    		answer.append(sum[i]).append(" ");
    	}
    	System.out.println(answer);
    }
}
