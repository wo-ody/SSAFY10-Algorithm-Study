package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1713_후보추천하기 {
    static class Point{
        int cnt, time;
        Point(int cnt, int time) {
            this.cnt = cnt;
            this.time = time;
        }
    }
    static int N; // 사진 틀 개수
    static int R; // 추천 횟수 1-1000, 학생번호는 1 - 100 자연수
    static Point[] arr = new Point[101];

    public static int find_erase_student(){
        int cnt = 1001;
        int time = 1001;
        int idx = 0;
        for (int i = 1; i <= 100 ; i++) {
            if(arr[i].cnt == 0 )continue;
            if(arr[i].cnt < cnt) {
                cnt = arr[i].cnt;
                time = arr[i].time;
                idx = i;
            }
            else if(arr[i].cnt == cnt) {
                if(arr[i].time < time) {
                    idx = i;
                    time = arr[i].time;
                }
            }
        }
        return idx;
    }



    public static void main(String[] args) throws Exception{
        // 사진틀 = 후보 수 만큼
        // 현재까지 추천 받은 횟수가 가장 적은 사진 삭제
        // 2명 이상일 경우 -> 가장 오래된 사진을 삭제함
        for (int i = 0; i < 101; i++) {
            arr[i] = new Point(0,0);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        R = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;
        for (int i = 0; i < R; i++) {
            int recommend = Integer.parseInt(st.nextToken());
            if(cnt == N){
                if(arr[recommend].cnt > 0) {
                    arr[recommend].cnt++;
                    continue;
                }
                int idx = find_erase_student();
                arr[idx].cnt = 0;
                arr[idx].time = 0;
                cnt--;
            }

            arr[recommend].cnt++;
            if(arr[recommend].time == 0 ) arr[recommend].time = i + 1;
            if(arr[recommend].cnt == 1) cnt++;
        }

        for (int i = 1; i < 101; i++){
            if(arr[i].cnt == 0) continue;
            System.out.print(i + " ");
        }

    }
}
