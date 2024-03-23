import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1484_다이어트 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int G = Integer.parseInt(br.readLine());
		int now = 2;
		int past = 1;
		while(now <= (G+1)/2) {
			int num = now*now - past*past;
			if (num > G){
				past++;
			}else if(num < G){
				now++;
			}else{
				sb.append(now).append("\n");
				past++;
				now++;
			}
		}
		System.out.println(sb.length()==0?-1:sb);
	}
}
