import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] P = br.readLine().toCharArray();
		int[] Pi = new int[P.length];
		int j=0;
		for (int i=1; i<P.length; i++) {
			while (j>0 && P[i]!=P[j]) j = Pi[j-1];
			
			if (P[i]==P[j]) Pi[i] = ++j;
			else j=0;
		}
		System.out.println(P.length-j);
	}
	
}
