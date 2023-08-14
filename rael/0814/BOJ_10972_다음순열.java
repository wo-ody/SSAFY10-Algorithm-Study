package BOJ10972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
    static int[] src;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        src =  new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }
        
        if(np(src)) {
        	for(int val : src) {
        		sb.append(val).append(" ");
        	}
        }
        else {
        	sb.append("-1");
        }
        System.out.println(sb);
    }
    
    static boolean np(int a[]) {
        int i = n-1;
        while(i > 0 && a[i-1] >= a[i]) i--;
        if(i == 0) return false;
        
        int j = n-1;
        while(a[i-1] >= a[j] ) j--;
        
        swap(a, i-1, j);
        
        int k = n-1;
        while(k > i) {
            swap(a, i++, k--);
        }
        return true;
    }
    
    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
