package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj_11725 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 노드 개수 입력

        // ArrayList로 트리구조 구현
        // 이중 리스트, 외부의 ArrayList는 트리의 각 레벨 내부의 ArrayList는 각 노드들의 값
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++)
            tree.add(new ArrayList<>());//각 층에 ArrayList 선언

        // 각 노드들에 입력 넣어주기
        for (int i = 0; i < n - 1; i++) {
            int n1 = sc.nextInt() - 1;
            int n2 = sc.nextInt() - 1;
            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }

        boolean[] visited = new boolean[n]; // 방문 체크 확인
        int[] parentNode = new int[n]; // 부모 노드 저장

        // BFS
        Queue<Integer> queue = new LinkedList<>(); //BFS 용 큐
        queue.add(0); //루트 노드 입력
        visited[0] = true;
        while (!queue.isEmpty()) {
            int v = queue.remove(); //큐에서 빼서 가져오기
            for (int node : tree.get(v)) //해당 트리의 레벨의 노드 돌기
                if (!visited[node]) { //방문확인
                    visited[node] = true; //방문체크
                    queue.add(node); //해당 노드 큐에 넣기
                    parentNode[node] = v; // 현재 노드의 부모노드가 node
                }
        }

        // 루트 노드를 제외한 나머지 노드의 부모 노드 출력
        for (int i = 1; i < n; i++)
            System.out.println(parentNode[i] + 1); // 노드 번호를 0부터 시작했으므로 1을 더해준다.
    }

}
