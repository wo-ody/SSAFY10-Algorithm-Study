import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828_스택 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		String command;
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			if(command.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if(command.equals("pop")) {
				if(stack.size() != 0) bw.write(stack.pop()+"\n");
				else bw.write("-1\n");
			} else if(command.equals("size")) {
				bw.write(stack.size()+"\n");
			} else if(command.equals("empty")) {
				if(stack.size() == 0) bw.write("1\n");
				else bw.write("0\n");
			} else if(command.equals("top")) {
				if(stack.size() != 0) bw.write(stack.peek()+"\n");
				else bw.write("-1\n");
				
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}
