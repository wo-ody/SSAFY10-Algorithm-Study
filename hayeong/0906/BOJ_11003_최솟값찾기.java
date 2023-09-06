import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 댁울 활용한 정렬 + 슬라이딩 윈도우
public class BOJ_11003_최솟값찾기 {
    static int N, L;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Node> section = new ArrayDeque<>();
        for (int i = 1; i < N + 1; i++) {
            Node n = new Node(i, arr[i]);
            while (!section.isEmpty() && section.getLast().num > n.num) {
                // 덱 내의 노드 삭제
                section.removeLast();
            }
            // 집어넣고
            section.addLast(n);
            // 인덱스 계산
            if (section.getFirst().idx < n.idx-L+1) {
                section.removeFirst();
            }
            sb.append(section.getFirst().num + " ");
        }
        System.out.println(sb.toString());
    }
    static class Node {
        int idx, num;

        Node(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }

}
