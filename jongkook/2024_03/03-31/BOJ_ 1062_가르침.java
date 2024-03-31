import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_ 1062_가르침 {
    static int N, K, max = Integer.MIN_VALUE;
    static int[] alpha;
    static boolean[] visited;
    static char[] fix = {'a', 'n', 't', 'i', 'c'};
    static ArrayList<ArrayList<Character>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        // a, n, t, i, c 는 항상 고정되어 있기 때문에 5를 제외하고 시작해야 됌
        K = Integer.parseInt(st.nextToken()) - 5;

        // alpha가 총 몇개있는지 세는 배열
        alpha = new int['z' - 'a' + 1];
        visited = new boolean['z' - 'a' + 1];
        // anta, tica는 고정되어 있기 때문에 그곳에 해당되는 알파벳은 미리 세어주기
        for(char chr: fix) {
            visited[chr - 'a'] = true;
            alpha[chr - 'a'] = -1;
        }

        // 문자열의 길이가 서로 다르기 때문에 list 사용
        for(int n = 0; n < N; n++) list.add(new ArrayList<>());
        for(int n = 0; n < N; n++){
            String str = br.readLine();
            // 제일 처음 4개 알파와 제일 뒤의 4개 알파는 제외
            for(int s = 4; s < str.length()-4; s++) list.get(n).add(str.charAt(s));
        }

        for(ArrayList<Character> fList: list){
            for(Character chr: fList){
                // 기존 배열에 포함이 되어있다면 넘김
                if(isIn(chr)) continue;
                alpha[chr - 'a'] += 1;
            }
        }
        if(K < 0){
            System.out.println(0);
            return;
        }
        else if (K == 26){
            System.out.println(N);
            return;
        }

//        System.out.println(list);

//        for(int i = 0; i < alpha.length; i++) System.out.println("alpha[i] = " + alpha[i] + " " + (char) ('a' + i));


        recursive(0, 0);

        System.out.println(max);
    }
    static boolean isIn(char chr){
        for(char ch: fix){
            if(ch == chr) return true;
        }
        return false;
    }
    static void recursive(int alpha, int depth){
        if(depth == K){
            int cnt = 0;
            for(int n = 0; n < N; n++){
                boolean isAccept = true;
                for(int l = 0; l < list.get(n).size(); l++){
                    if(visited[list.get(n).get(l) - 'a']) continue;
                    isAccept = false;
                    break;
                }
                if(isAccept) cnt++;
            }
            max = Math.max(cnt, max);
            return;
        }
        for(int i = alpha; i < 'z' - 'a' + 1; i++){
            if(visited[i]) continue;
            visited[i] = true;
            recursive(i, depth+1);
            visited[i] = false;
        }
    }
}
