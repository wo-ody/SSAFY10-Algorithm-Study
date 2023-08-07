package codingtest;

import java.io.*;
import java.util.*;
public class BOJ_1717_집합의_표현 {
    static int N[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = new int[Integer.parseInt(st.nextToken())+1];
        for(int i = 0; i < N.length; i++) N[i] = i;
        int line = Integer.parseInt(st.nextToken());
        for(int i = 0; i < line; i++){
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // operation 이 0이라면 같은 집합이니까 union 을 사용해서 같은 집합으로 표현
            if(operation == 0) union(a, b);
            // 1이라면 같은 집합인지 아닌지 알아봐야 하니까 check 를 사용
            else check(a, b);
        }
    }

    // 분리집합
    // 서로 중복되지 않는 집합들로 나누어진 원소들을 저장
    // 각 집합의 부모 값을 얻어와 다른 한쪽의 부모를 가르키게 하는 Union - Find 알고리즘
    // 구조는 트리처럼 생겼네
    public static void union(int a, int b) {
        int ap = findParent(a);
        int bp = findParent(b);
        N[bp] = ap;
    }

    /*
    원소가 속해있는 집합의 부모를 찾는 연산
    A, B 의 부모를 구했을 때 같은 부모를 가르키면 같은 집합
    자식노드는 항상 부모를 가르켜야 연산이 빠르다
    * */
    public static int findParent(int x){
        if (x == N[x]) return N[x];
        else return N[x] = findParent(N[x]);
    }

    static void check(int a, int b){
        int ap = findParent(a);
        int bp = findParent(b);
        if(ap != bp) System.out.println("NO");
        else System.out.println("YES");
    }

}
