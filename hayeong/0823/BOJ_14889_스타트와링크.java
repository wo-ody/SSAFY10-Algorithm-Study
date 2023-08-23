import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// NP 조합
public class BOJ_14889_스타트와링크 {
    static int N; // 사람 수
    static int[][] board; // 가중치 배열

    static int[] tgt; // NP를 사용하여 2팀으로 나누기 위해 만든 0과 1로 이루어진 배열

    static int[] teamOne; // 0/1 중에 1로 이루어진 인덱스 배열
    static int[] teamZero; // 0/1 중에 0으로 이루어진 인덱스 배열
    static boolean[] select; // 순열에서 방문체크를 위한 배열

    static int[] miniTgt = new int[2]; // 나누어진 팀에서 2명을 뽑을 때 사용하는 배열

    static int sumOne, sumZero, min = Integer.MAX_VALUE; // 각팀의 가중치 합, 그 차이를 저장할 변수

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i = 0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // NP 조합으로 두팀으로 나누기
        tgt = new int[N];
        teamOne = new int[N/2];
        teamZero = new int[N/2];
        select = new boolean[N/2];
        for(int i = 1; i<=N/2; i++){
            tgt[N-i] = 1;
        }


        while(true){

             /**
              * complete code
              * np로 두팀으로 나누기
              * 나뉘어진 각 팀에 대해 순열을 사용하여 2개씩 뽑아서 가중치를 각 팀에 더함
              * 찾은 가중치 합의 차이를 업데이트 함
              * */

            // 두팀으로 나누기
            int idxOne = 0;
            int idxZero= 0;
            for(int i = 0; i<N; i++){
                if(tgt[i] == 1){
                    teamOne[idxOne++] = i;
                } else{
                    teamZero[idxZero++] = i;
                }
            }
            // 각 팀 맴버 배열을 기반으로 모든 순열(2개 뽑기)을 구하고 각 팀 별 가중치 합을 구한다.
            sumOne = 0;
            sumZero = 0;
            perm(teamOne, 0, 1);

            select = new boolean[N/2];
            perm(teamZero, 0, 0);


            // 이번 팀 조합의 가중치 차이의 최솟값을 구하고 업데이트
            min = Math.min(min, Math.abs(sumOne - sumZero));

            if(!np(tgt)){
                break;
            }
        }

        // 모든 팀 조합 중 가중치 합의 차이의 최소
        System.out.println(min);


    }

    static void perm(int[] arr, int tgtIdx, int flag){
        if(tgtIdx == 2){
            // complete code;
            if(flag == 1) { // 1팀이면 sumOne에 추가
                sumOne += board[miniTgt[0]][miniTgt[1]];
            }
            if(flag == 0){ // 0팀이면 sumZero에 추가
                sumZero+= board[miniTgt[0]][miniTgt[1]];
            }
            return;
        }
        for(int i = 0; i<arr.length; i++){
            if(select[i]) continue;

            miniTgt[tgtIdx]  = arr[i];
            select[i] = true;
            perm(arr, tgtIdx+1, flag);
            select[i] = false;

        }
    }

    static boolean np(int[] arr){
        int len = arr.length -1;
        int i,j, k;
        i = j = k = len;

        while(i != 0 && arr[i-1] >= arr[i]) i--;
        if(i == 0) return false;

        while(arr[i-1] >= arr[j]) j--;
        swap(arr, i-1, j);

        while(i<k) swap(arr, i++, k--);
        return true;
    }

    static void swap (int[] arr, int i , int j){
        int tmp = arr[i] ;
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
