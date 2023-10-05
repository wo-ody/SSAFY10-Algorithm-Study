import java.util.*;
import java.io.*;

public class Main {
	static int[] hand;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]), M = Integer.parseInt(st[1]), K = Integer.parseInt(st[2]);
        boolean[] card = new boolean[N+1];
        st = br.readLine().split(" ");
        for (int i=0;i<M;i++) {
        	card[Integer.parseInt(st[i])] = true;
        }
        hand = new int[N+2];
        for(int i=1; i<=N+1; i++)hand[i] = i;
        for (int i=N; i>0; i--) {
        	if (!card[i]) hand[i] = find(hand[i+1]);
        }
        st = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s:st) {
        	int i = Integer.parseInt(s);
        	int ans = find(i+1);
        	sb.append(ans).append("\n");
        	union(hand[ans+1], ans);
        }
        System.out.println(sb);
    } // main
    public static int find(int x) {
    	if (x==hand[x]) return x;
    	return find(hand[x]);
    }
    public static void union(int x, int y) {
    	x = find(x);
    	y = find(y);
    	hand[y] = x;
    }
}
