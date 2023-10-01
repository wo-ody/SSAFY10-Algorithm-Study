import java.io.*;
import java.util.*; 

public class Main {
static StringBuilder sb = new StringBuilder();
public static void main(String[] args) throws NoSuchElementException, IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
Deque<Integer> stack = new ArrayDeque<Integer>(); // stack ArrayDeque로 정의
int N = Integer.parseInt(br.readLine()); 

for (int i = 0; i < N; i++) {
StringTokenizer st =new StringTokenizer(br.readLine()); 
int num= Integer.parseInt(st.nextToken());
if (num==1) { 

stack.push(Integer.parseInt(st.nextToken()));// push가 문자열에 포함 시 다음에 나올 정수 push 

} else if (num==5) {
sb.append(stack.size() == 0 ? -1 : stack.getFirst()).append("\n");
} else if (num==3) {
sb.append(stack.size()).append("\n");
} else if (num==4) {
sb.append(stack.isEmpty() ? 1 : 0).append("\n");
} else if (num==2) {
sb.append(stack.size() == 0 ? -1 : stack.pop()).append("\n");
} 

} 

System.out.println(sb); 

} 

}




