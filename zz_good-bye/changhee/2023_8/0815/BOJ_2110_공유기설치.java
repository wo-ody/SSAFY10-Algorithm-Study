/*
 *  08.15 김창희
 *  BOJ_2110_공유기설치
 *
 *  [풀이]
 *  1. 파라메트릭 서치를 적용한다.
 *  2. 최소거리와 최재거리를 start, end로 잡고 이분탐색을 하며 공유기를 설치할수 있는 거리를 mid로 계속 업데이트한다.
 *  3. start와 end의 범위설정 주의!!
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st =new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int c =Integer.parseInt(st.nextToken());

        int[] home= new int[n];
        for(int i =0; i<n; i++){
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);
        System.out.println(install(home,n,c));

    }
    public static int install(int[] home, int n ,int c){
        int start= 1, end = home[n-1]-home[0],result =0;
        while(start<=end){
            int mid =(start+end)/2;

            int installCount = 1;
            int prev= home[0];
            for(int i =1; i<n; i++){
                if(home[i] - prev>=mid){
                    prev=home[i];
                    installCount++;
                }
            }

            if(installCount >= c){
                result = mid;
                start=mid+1;
            }else{
                end = mid-1;
            }
        }

        return result;
    }
}
