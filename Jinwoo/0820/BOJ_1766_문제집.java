import java.util.*;
import java.io.*;
public class Main {
	static int[] ind;
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n= Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
    	ind = new int[n+1];
    	List<List<Integer>> g = new ArrayList<>(n+1);
    	for (int i=0; i<=n; i++) g.add(new ArrayList<Integer>());
    	
    	int s, e;
    	for (int i=0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		s = Integer.parseInt(st.nextToken()); e = Integer.parseInt(st.nextToken());
    		ind[e]++;
    		g.get(s).add(e);
    	}
    	
    	PriorityQueue<Integer> heap = new PriorityQueue<>();
    	for (int i=1; i<=n; i++) if (ind[i]==0) heap.add(i);
    	
    	StringBuilder sb = new StringBuilder();
    	for (int a=0; a<n; a++) {
    		s = heap.poll();
    		sb.append(s).append(" ");
    		for (int i:g.get(s)) {
    			ind[i]--;
    			if (ind[i]==0) heap.add(i);
    		}
    	}
    	System.out.println(sb);
    }
}
