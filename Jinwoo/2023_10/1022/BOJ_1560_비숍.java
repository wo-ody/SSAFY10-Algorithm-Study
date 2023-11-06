import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int ans = n*2-2;
		if (n==1) ans = 1;
		else if (n==2) ans =2;
		System.out.println(ans);
	}

}
