import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*; 

public class Main {
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
static StringTokenizer st;
static int N, M;
static int[] input;
static StringBuilder sb= new StringBuilder(); 

public static void main(String[] args) throws Exception {
st = new StringTokenizer(br.readLine());
N = Integer.parseInt(st.nextToken());
M = Integer.parseInt(st.nextToken()); 

input = new int[N+M];
st = new StringTokenizer(br.readLine());
for (int i = 0; i < N; i++) {
input[i] = Integer.parseInt(st.nextToken());
}
st = new StringTokenizer(br.readLine());
for (int j= N; j< N+M; j++) {
input[j] = Integer.parseInt(st.nextToken());
}
Arrays.sort(input);
for (int k = 0; k< N+M; k++) {
sb.append(input[k]+" ");
}
System.out.println(sb);
}
}
