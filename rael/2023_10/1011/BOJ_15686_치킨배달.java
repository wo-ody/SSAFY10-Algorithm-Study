import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {
    static int N, M, min;
    static int houseSize, srcSize;
    static List<int[]> house, src, tgt;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //변수 초기화
        house = new ArrayList<>();
        src = new ArrayList<>();
        tgt = new ArrayList<>();

        //map 구분받아 입력
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) house.add(new int[] {i,j});
                else if(num == 2) src.add(new int[] {i,j});
            }
        }

        //범위 초기화
        houseSize = house.size();
        srcSize = src.size();

        //풀이
        min = Integer.MAX_VALUE;
        comb(0,0);
        System.out.println(min);
    }

    static void comb(int srcIdx, int tgtIdx){
        //기저조건 (치킨집 다 고르면)
        if(tgtIdx == M){
            //치킨집과의 거리 구한 뒤 최소 합 구하기
            int sum = 0;        //현재 조합에서의 최소 누적 합
            //집
            for(int i=0; i<houseSize; i++){
                int dist = Integer.MAX_VALUE;
                int h[] = house.get(i);
                //가게
                for(int j=0; j<M; j++){
                    int c[] = tgt.get(j);
                    dist = Math.min(dist, Math.abs(h[0]-c[0])+Math.abs(h[1]-c[1]));
                }
                sum += dist;
            }
            //최솟값 업데이트
            min = Math.min(min, sum);
            return;
        }

        //srcSize로도 판단
        if(srcIdx == srcSize) return;

        //선택
        tgt.add(src.get(srcIdx));
        comb(srcIdx+1, tgtIdx+1);
        //비선택
        tgt.remove(src.get(srcIdx));
        comb(srcIdx+1, tgtIdx);
    }
}
