import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, ans;
    static boolean[] select;
    static int[][] flower;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);//개화시기를 이용해 정렬하기 위한 pq

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        select = new boolean[N];//꽃 선택 유무
        flower = new int[N][3];//꽃의 정보(인덱스,개화시기,지는시기);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            flower[i][0] = i;
            flower[i][1] = start;
            flower[i][2] = end;
        }//꽃의 정보 입력

        int endtime = 1201;
        while (true) {
            if (endtime <= 301)//3월 1일 후에 꽃이 피어있는 경우 break;
                break;
            pq.clear();
            ans++;//피어있을 꽃을 하나 선택
            for (int i = 0; i < N; i++) {
                if (!select[flower[i][0]] && flower[i][2] >= endtime) {//선택한 적이 없고 전의 꽃이 없어지기 전에 개화되어 있는 꽃
                    pq.add(flower[i]);
                }
            }
            if (pq.isEmpty()) {//조건을 만족할 수 없는 경우
                ans = 0;
                break;
            }
            int[] cur = pq.poll();
            select[cur[0]] = true;
            endtime = cur[1];//뽑힌 꽃의 개화시기이상으로 피어 있을 꽃을 선정
        }
        System.out.println(ans);
    }
}