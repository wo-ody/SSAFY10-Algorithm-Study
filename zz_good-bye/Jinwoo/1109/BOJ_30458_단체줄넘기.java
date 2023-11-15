import java.io.*;
import java.util.*;
public class BOJ_30458_단체줄넘기 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] palin = br.readLine().toCharArray();
		int[] alphCnt = new int[26];
		for (int i=0; i<n/2; i++) {
			alphCnt[palin[i]-'a']++;
		}
		for (int i=n/2+((n%2==0)? 0:1); i<n; i++) {
			alphCnt[palin[i]-'a']++;
		}
		boolean flag = true;
		for (int i:alphCnt) {
			if (i%2==1) {
				flag = false;
				break;
			}
		}
		if (flag) System.out.println("Yes");
		else System.out.println("No");
	}

}
