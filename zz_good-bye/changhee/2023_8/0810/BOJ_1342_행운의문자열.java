/*
 *	08.10 김창희
 *	BOJ_1342_행운의문자열
 *
 *	[풀이]
 *  1. 일반적인 조합으로 풀면 시간초과발생.
 *  2. 중복되는 문자에 대한처리가 관건.
 *  3. 순차적으로 조합이 나오는 nextPermutation사용
 *  4. 최초로 정렬을 한 후, 뒤쪽부터(오름차순) 정렬을 수행한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[] arr;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = br.readLine().toCharArray();
        size= arr.length;

        Arrays.sort(arr);

        int answer =0;
        do{
            if(isLuckyStr()) answer++;
        }while (nextPermutation());

        System.out.println(answer);
    }

    public static boolean nextPermutation(){
        int x= size-1,y=size-1,n=size-1;

        while(x>0 && arr[x]<=arr[x-1]) x--;

        if(x==0) return false;

        while(arr[x-1] >= arr[y]) y--;

        swap(x-1,y);

        while(x<n) swap(x++,n--);

        return true;
    }

    private static void swap(int x, int y) {
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y]= temp;
    }

    public static boolean isLuckyStr(){
        for(int i =0; i<size-1; i++){
            if(arr[i]==arr[i+1]) return false;
        }
        return true;
    }
}
