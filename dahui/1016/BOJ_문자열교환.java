import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int aCnt = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == 'a') aCnt++;
		}
		
		Queue<Character> q = new ArrayDeque<>();
		
		int bCnt = 0;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<aCnt; i++) {
			q.add(str.charAt(i));
			if(str.charAt(i) == 'b') bCnt++;
		}
		min = Math.min(min, bCnt);
		
		if(aCnt ==0) System.out.println(0);
		else {
			for(int i=aCnt; i<aCnt+str.length(); i++) {
				int j = i%str.length();
				
				if(q.poll() == 'b') bCnt--;
				q.add(str.charAt(j));
				if(str.charAt(j) == 'b') bCnt++;
				min = Math.min(min, bCnt);
			}
			
			System.out.println(min);
		}
		
		
	}

}
