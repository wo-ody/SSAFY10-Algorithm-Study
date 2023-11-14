import java.io.*;
import java.util.*;
public class BOJ_9527_1의개수세기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String n = Long.toBinaryString(Long.parseLong(st.nextToken())-1);
		String m = Long.toBinaryString(Long.parseLong(st.nextToken()));
		
		System.out.println(cntOne(m)-cntOne(n));
	}
	
	static long cntOne(String x) {
		long leftOne = 0, len=x.length(); long res=0;
		for (int i=0; i<len; i++) {
			if(x.charAt(i)=='1') {
				res += ((len-i-1)*(1L<<len-i-2)) + 1;
				res += (1L<<len-i-1)*leftOne++;
			}
		}
		return res;
	}
}
