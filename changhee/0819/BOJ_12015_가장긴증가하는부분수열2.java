/*
 *  08.18 김창희
 *  BOJ_12015_가장긴증가하는부분수열2
 *
 *  [풀이]
 *  1. dp에 최대 길이를 저장하며 이차원 반복문을 통한 풀이는 시간초과 발생한다.
 *  2. 이분탐색으로 각 숫자가 들어갈 위치를 지정한다.
 *  3. 최근에 들어온 값보다 새로 들어올 값이 크다면 바로 넣어 주고
 *  4. 작다면 앞선 수열을 작은 값들로 수열이 구성되도록 변경해준다.
 *  5. 4의 예시로 3 8 10 1 5 7 9 8 9 6이 순서대로 들어오면 1 5 7 8 9가 정답이다. 즉, 앞선 수열 3 8 10이 나중에 들어오는 값중 작은 값들로 대처된다.
 *  6. 위 과정에서 들어올 값을 key값으로 하여 이분탐색을 통해 적절한 위치에 업데이트 한다.
 *  7. 이때 배열에서 key값보다 작지만 제일 왼쪽에 있는 값을 선택하여 업데이트 해야하기 때문에 lower bound로 탐색한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int last =0;
        arr= new int[n];

        st = new StringTokenizer(br.readLine());
        arr[last++]=Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());
            if(arr[last-1] < key) arr[last++]= key;
            if(arr[last-1] > key) lower(key,0,last);
        }

        System.out.println(last);
    }

    public static void lower(int key, int start, int end){
        while(start<end){
            int mid=(start+end)/2;
            if(arr[mid] < key){
                start =mid+1;
            }else{
                end = mid;
            }
        }
        arr[end] =key;
    }
}
