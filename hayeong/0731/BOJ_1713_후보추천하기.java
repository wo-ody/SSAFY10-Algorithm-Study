import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class 후보추천하기 {
    static int n;
    static int r;

    static Map<Integer, Frame> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        r = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int s = Integer.parseInt(st.nextToken());
            // 빈 액자가 있을때,
            if (map.size() < n) {
                // 이미 존재할떄,
                if (map.keySet().contains(s)) {
                    Frame ex = map.get(s);
                    map.put(s, new Frame(ex.cnt+1, ex.idx));
                }
                //존재하지 않을때
                else {
                    map.put(s, new Frame(1, i));
                }
            }
            // 빈 액자가 없을때,
            else {
                // 이미 존재할 때,
                if (map.keySet().contains(s)) {
                    Frame ex = map.get(s);
                    map.put(s, new Frame(ex.cnt + 1, ex.idx));
                }
                // 존재하지 않을 때,-> 우선순위에 따라 삭제하고 집어넣기
                else {
                    ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
                    Collections.sort(keyList, (x, y) -> map.get(x).cnt == map.get(y).cnt ? map.get(x).idx - map.get(y).idx : map.get(x).cnt - map.get(y).cnt);
                    map.remove(keyList.get(0));
                    // 집어넣기
                    map.put(s, new Frame(1, i));
                }
            }
        }
        ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);
        StringBuilder sb= new StringBuilder();

        for(int i: keyList){
            sb.append(i+" ");
        }
        System.out.println(sb.toString());
    }
}

class Frame {
    int cnt;
    int idx;

    Frame(int cnt, int idx) {
        this.cnt = cnt;
        this.idx = idx;
    }
}
