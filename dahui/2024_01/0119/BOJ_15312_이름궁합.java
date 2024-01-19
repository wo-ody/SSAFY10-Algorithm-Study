package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15312_이름궁합 {
	static int[] arr = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String str1 = br.readLine();
        
        int[][] arr1 = new int[str.length()*2-1][str.length()*2];
        
        for(int i=0; i<str.length(); i++) {
        	arr1[0][i*2] = arr[str.charAt(i)-'A'];
        	arr1[0][i*2+1] = arr[str1.charAt(i)-'A'];
        }
        
        int k = str.length()*2-1;
        for(int i=0; i<str.length()*2-2;i++){
        	for(int j=0; j<k; j++) {
        		arr1[i+1][j] = (arr1[i][j] + arr1[i][j+1])%10;
        	}
        	k--;
        }
        
        System.out.print(arr1[str.length()*2-2][0]);
        System.out.print(arr1[str.length()*2-2][1]);
        
	}

}
