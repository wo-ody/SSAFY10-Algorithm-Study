/*
 *  08.13 김창희
 *  BOJ_1379_강의실2
 *
 *  [풀이]
 *  1. 두개의 우선순위 큐를 이용한다.
 *  2. 하나는 시작시간과 끝시간이 빠른 순대로 정렬하고, 하나는 빨리끝나는 시간순대로 정렬한다
 *  3. 빨리끝나는 시간큐와 새로 들어갈 노드의 시작시간을 비교하며 강의실을 새로 배정할지 말지를결정한다.
 *  4. 각 강의의 방 정보를 저장할 배열을 만들고, 노드에 시간과 인덱스정보까지 저장하여 인덱스로 방 번호를 가져온다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        PriorityQueue<Node> schedule = new PriorityQueue<>((o1,o2)->(o1.start==o2.start?o1.end-o2.end:o1.start-o2.start));
        PriorityQueue<Node> endPoint = new PriorityQueue<>((o1,o2)->o1.end-o2.end);
        int n =Integer.parseInt(br.readLine());

        for(int i =0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            schedule.offer(new Node(index,start,end));
        }

        int count = 1;
        int[] room = new int[n+1];
        Node start = schedule.poll();
        room[start.index] = count;
        endPoint.offer(start);

        while(!schedule.isEmpty()){
            Node node = schedule.poll();
            endPoint.offer(node);

            if(endPoint.peek().end > node.start){
                count++;
                room[node.index] = count;
            }else{
                room[node.index] = room[endPoint.poll().index];
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(count).append("\n");
        for(int i =1; i<n+1; i++) answer.append(room[i]).append("\n");
        System.out.println(answer);
    }

    static class Node{
        int index, start, end;

        public Node(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }
}
