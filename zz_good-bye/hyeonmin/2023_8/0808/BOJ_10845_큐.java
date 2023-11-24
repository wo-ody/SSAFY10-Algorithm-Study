import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_10845_큐 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		int value = 0;
		String command;
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			if(command.equals("push")) {
				value = Integer.parseInt(st.nextToken());
				queue.offer(value);
			} else if(command.equals("pop")) {
				if(queue.size() != 0) bw.write(queue.poll()+"\n");
				else bw.write("-1\n");
			} else if(command.equals("size")) {
				bw.write(queue.size()+"\n");
			} else if(command.equals("empty")) {
				if(queue.size() == 0) bw.write("1\n");
				else bw.write("0\n");
			} else if(command.equals("front")) {
				if(queue.size() != 0) bw.write(queue.peek()+"\n");
				else bw.write("-1\n");
			} else if(command.equals("back")) {
				if(queue.size() != 0) bw.write(value+"\n");
				else bw.write("-1\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
