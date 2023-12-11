/*
 *	7.29 김창희
 *	BOJ_1902_배
 *
 *	[풀이]
 *	1. 크레인이 들 수 있는 최대 박스 무게를 우선으로 선정해야한다. 그래야 모든 박스를 옮길수 있는 가능성이 증가한다.
 *	2. 위 조건을 만족시키기 위해 크레인의 파워의 오름차순과, 박스 무게를 내림차순으로 정렬한다.
 *	3. 크레인이 박스를 옮기기 위해서는 크레인 파워가 박스무게보다 같거나 커야하며, 크레인 사용횟수가 최저가 되야한다.
 *	4.  만약 위 조건을 만족하는 경우가 없을 경우 answer = -1
 */
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Integer[] cranes = new Integer[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++) cranes[i] = Integer.parseInt(st.nextToken());

        int m =Integer.parseInt(br.readLine());
        Integer[] boxes = new Integer[m];
        st =new StringTokenizer(br.readLine());
        for(int i =0; i<m; i++) boxes[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cranes,(o1,o2)->Integer.compare(o2,o1));
        Arrays.sort(boxes,(o2,o1)->Integer.compare(o1,o2));

        int[] craneTimer = new int[n];
        int answer = 0;
        for(int i =0; i<m; i++){
            int timer = Integer.MAX_VALUE;
            int selectCrane=-1;
            int box= boxes[i];

            for(int j =0; j<n; j++){
                if(cranes[j] < box) continue;
                if(timer>craneTimer[j]){
                    timer = craneTimer[j];
                    selectCrane = j;
                }
            }

            if(selectCrane==-1){
                answer=-1;
                break;
            }
            craneTimer[selectCrane]++;
        }

        System.out.println(answer==-1?-1: Arrays.stream(craneTimer).max().getAsInt());
    }
}
