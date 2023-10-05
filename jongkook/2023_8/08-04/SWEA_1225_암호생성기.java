import java.util.*;
import java.io.*;

public class SWEA_1225_암호생성기 {
	
	public static void main(String[] args) throws IOException{
		System.setIn(new FileInputStream("src//swea//password_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = 0;
		while(true) {
			tc++;
			String t = br.readLine();
			if ( t == null || t.length() == 0) break;
			StringBuilder sb = new StringBuilder();
//			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			Deque<Integer> dq = new ArrayDeque<>();
			// Deque 에 값 초기화
			while(st.hasMoreTokens()) dq.offer(Integer.parseInt(st.nextToken()));
			int count = 1;
			while(dq.peekLast() > 0) {
				int myPoll = dq.poll();
				int myNumber = (myPoll - count > 0) ? myPoll - count : 0;
				dq.offer(myNumber);
				count++;
				if(count > 5) count = 1;
			}
			sb.append("#" + tc + " ");
			
			while(!dq.isEmpty())  sb.append(dq.poll() + " "); //System.out.print(dq.poll() + " ");
//			sb.append("\n");
			System.out.println(sb);
			
		}
	}

}
