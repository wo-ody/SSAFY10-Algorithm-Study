package boj;

import java.io.*;
import java.util.*;
public class boj_10431_줄세우기 {
    static int T,N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            // 여기서 시뮬 시작
            int result = 0;
            ArrayList<Integer> arr = new ArrayList<>();

            arr.add(Integer.parseInt(st.nextToken()));
            for (int i = 0; i < 19; i++) {
                int num = Integer.parseInt(st.nextToken());

                Collections.sort(arr);
                for (int j = 0; j < arr.size(); j++) {
                    if(arr.get(j) > num){
                        result += (arr.size() - j);

                        break;
                    }
                }
                arr.add(num);
            }

            sb.append(tc+1).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}
