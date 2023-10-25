import java.io.*;
import java.util.*;

public class Main {
    static int T,K;
    static char[] W;

    static boolean isAnswer;
    static int r1,r2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T ; tc++) {
            W = br.readLine().toCharArray();
            K = Integer.parseInt(br.readLine());

            isAnswer = true;
            simulation();

            if(isAnswer) System.out.println(r1 + " " + r2);
            else System.out.println(-1);
        }

    }

    static void simulation(){
        ArrayList<Integer>[] location = new ArrayList[30];
        for (int i = 0; i < 30; i++) location[i] = new ArrayList<>();

        for (int i = 0; i < W.length; i++) {
            int idx = W[i] - 97;
            location[idx].add(i);
        }

        // K개 포함하는 것 만들기
        ArrayList<Node> range = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            if(location[i].size() == 0 || location[i].size() < K) continue;

            int fidx = 0;
            int first = location[i].get(fidx);
            int last = location[i].get(K-1);
            range.add(new Node(first,last,last-first+1));
            for (int j = K; j < location[i].size(); j++) {
                fidx++;
                first = location[i].get(fidx);
                last = location[i].get(j);
                range.add(new Node(first,last,last-first+1));
            }
        }

        if(range.size() == 0) {
            isAnswer = false;
            return;
        }
        // r1 뽑기
        Collections.sort(range, (o1,o2) -> o1.distance - o2.distance);
        r1 = range.get(0).distance;

        // r2 뽑기
        Collections.sort(range, (o1,o2) -> o2.distance - o1.distance);
        r2 = range.get(0).distance;

    }

    static class Node{
        int first, last, distance;
        Node(int first, int last, int distance){
            this.first = first;
            this.last = last;
            this.distance = distance;
        }
    }
}
