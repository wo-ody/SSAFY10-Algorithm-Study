import java.util.*;

public class boj1325 {
    public static ArrayList<Integer>[] list;
    public static boolean[] visitied;
    public static int[] num; // 각 노드에서 가장 깊이 들어간 곳의 수를 담는 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();


        //이중 리스트 구현
        list = new ArrayList[n+1];
        num = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        //신뢰도 리스트에 입력 받기
        for (int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
        }

        //방문 체크, BFS
        for (int i = 1; i <= n ; i++) {
            visitied = new boolean[n+1];
            BFS(i);
        }

        //가장 큰 값을 배열에서 찾아주기
        int max = Arrays.stream(num).max().getAsInt();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 1; i < n+1; i++) {
            if(num[i] == max){
                answer.add(i);
            }
        }

        Collections.sort(answer);
        for(int item : answer){
            System.out.print(item + " ");
        }
        System.out.println();

    }


    public static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>(); //BFS를 위한 큐
        queue.add(start); //시작 노드 큐에 넣기
        visitied[start] = true; // 시작 노드 방문 체크

        while (!queue.isEmpty()){ //큐에 노드가 없을 때까지
            int cur = queue.poll(); //큐에 있는 노드 꺼내기
            for(int item : list[cur]){ //해당 노드의 리스트 돌기
                if(!visitied[item]){ //방문 하지 않았다면
                    visitied[item] = true; //방문 체크
                    queue.add(item); //큐 돌기
                    num[item] ++; // 가장 많이 간 거리 , -> 해당 노드의 값을 num배열에 담음
                }
            }
        }
    }
}
