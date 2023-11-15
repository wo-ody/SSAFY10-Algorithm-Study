import java.io.*;

public class Main{
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		String str = bf.readLine();
		while (!str.equals("#")){
			int ans = 0;
			char[] charr = str.toCharArray();
			for (char c: charr){
				if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u'
				|| c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
					ans++;
				}
			}
		    bw.write(ans+"\n");
		    str = bf.readLine();
		}
		bw.flush();
	}
}