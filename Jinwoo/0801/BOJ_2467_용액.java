import java.io.*;
import java.util.*;
/*
이분탐색하거나 투포인터를 이용하여 해결하는 문제.
두가지 모두 사용해보면 조금 더 빠르지 않을까 생각했으나, 그냥 투포인터로 푸는게 간결하고 시간도 비슷할듯  또는 더 효율적일수도 모르겠다.
2467, 2470 정렬만 차이나는 같은 문제
2473번은 용액 3개를 탐색하는 문제이다. 이후 풀어보면 좋을듯
*/
public class BOJ_2467_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] st = br.readLine().split(" ");
        int[] sol = new int[n];
        for (int i=0; i<n; i++) sol[i] = Integer.parseInt(st[i]);
        Arrays.sort(sol);
        int l= 0, r= n-1;
        int[] ans = {Math.abs(sol[r]+sol[l]), l, r};
        if (sol[r]<=0) {l=n-2; r= n-1; ans = new int[] {Math.abs(sol[r]+sol[l]), l, r};}
        if (sol[l]>=0) {l=0; r= 1; ans = new int[] {Math.abs(sol[r]+sol[l]), l, r};}
        while (r-l>1 && ans[0] != 0) {
        	r = binary_s(sol, l, r, -sol[l]);
        	if (l>=r) break;
        	if (Math.abs(sol[r]+sol[l]) < ans[0]) {ans = new int[] {Math.abs(sol[r]+sol[l]), l, r}; }
        	if (l!=r-1) {
        		if (Math.abs(sol[r-1]+sol[l]) < ans[0]) {ans = new int[] {Math.abs(sol[r-1]+sol[l]), l, r-1}; }
        	}
        	l = Math.max(l+1, binary_s(sol,l,r,-sol[r])-1);
        }
        bw.write(""+ sol[ans[1]]+" "+ sol[ans[2]]+"\n");
        bw.flush();
    } // main

    public static int binary_s(int[] sol, int l, int r, int targ) {
        if (l==r) return l;
        int mid = (l+r)/2;
        if (sol[mid] >= targ) return binary_s(sol, l, mid, targ);
        else return binary_s(sol, mid+1, r, targ);
    }
}
