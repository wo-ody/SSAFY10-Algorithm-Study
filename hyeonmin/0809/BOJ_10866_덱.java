import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_10866_덱 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		int value = 0;
		String command;
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			if(command.equals("push_front")) {
				value = Integer.parseInt(st.nextToken());
				deque.addFirst(value);
			} else if (command.equals("push_back")) {
				value = Integer.parseInt(st.nextToken());
				deque.addLast(value);
			} else if(command.equals("pop_front")) {
				if(!deque.isEmpty()) bw.write(deque.removeFirst()+"\n");
				else bw.write("-1\n");
			} else if(command.equals("pop_back")) {
				if(!deque.isEmpty()) bw.write(deque.removeLast()+"\n");
				else bw.write("-1\n");
			} else if(command.equals("size")) {
				bw.write(deque.size()+"\n");
			} else if(command.equals("empty")) {
				if(deque.isEmpty()) bw.write("1\n");
				else bw.write("0\n");
			} else if(command.equals("front")) {
				if(!deque.isEmpty()) bw.write(deque.peekFirst()+"\n");
				else bw.write("-1\n");
			} else if(command.equals("back")) {
				if(!deque.isEmpty()) bw.write(deque.peekLast()+"\n");
				else bw.write("-1\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
