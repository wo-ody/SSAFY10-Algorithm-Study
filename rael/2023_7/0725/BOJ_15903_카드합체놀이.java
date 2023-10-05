import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    static PriorityQueue<Long>p_queue = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] t = br.readLine().split(" ");
        
        int n = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
            
        String [] tt = br.readLine().split(" ");
        
        for(int i=0; i<n; i++) {
            p_queue.add(Long.parseLong(tt[i]));
        }

        for(int i=0; i<m; i++) {
            Long a = p_queue.poll();
            Long b = p_queue.poll();
            p_queue.add(a+b);
            p_queue.add(a+b);
        }
    
        long ans = 0;
    
        while(!p_queue.isEmpty()) {
            ans+=p_queue.poll();
        }
        System.out.println(ans);
    }
}