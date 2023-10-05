import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static boolean arr[];
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new boolean[2001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++) {
        	int n = Integer.parseInt(st.nextToken())+1000;
        	arr[n] = true;
        }
        
        for(int i =0;i<=2000;i++) {
        	if(arr[i])sb.append(i-1000).append(" ");
        }
        System.out.println(sb);
    }
}
