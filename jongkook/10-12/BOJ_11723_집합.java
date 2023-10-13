import java.io.BufferedReader;
import java.io.BufferedWriter; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer> als;
	static int T, bit;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		als = new ArrayList<>();
		
		bit = 0;
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if(command.equals("empty") || command.equals("all")) {
				operator(command);
				continue;
			}
			int value = Integer.parseInt(st.nextToken());
			operator(command, value);
		}
		System.out.println(sb);

	}
	static void operator(String command, int value) {
		switch(command){
			case "add": 
				bit = bit | (1 << value - 1);
				break;
			case "remove":
				bit = bit & ~(1 << value - 1);
				break;
			case "check" :
				sb.append((bit & (1 << value - 1)) == 0 ? "0\n" : "1\n");
				break;
			case "toggle":
				bit = bit ^ (1 << value - 1);
				break;
		}	
	}
	static void operator(String command) {
		switch(command) {
			case "all":
				bit = bit | ~0;
				break;
			case "empty":
				bit = bit & 0;
				break;				
		}
	}
}
