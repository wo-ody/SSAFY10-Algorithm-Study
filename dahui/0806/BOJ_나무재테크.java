import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//r,c 1부터 -> N+1,M : 나무 수  
//모든 땅의 처음 양분 -> 5
//봄 : 양분 -자신의 나이, 나이++;
//한 칸 안에 여러개의 나무가 있다면, 나이가 어린 나무가 양분을 먹는다. -> 자신의 나이만큼 먹지 못하면 즉시 죽음
//여름 : 봄에 죽은 나무는 죽은 나무의 나이/2 가 양분이 됨, 소수점 아래는 버린다.
//가을 : 나이가 5의 배수인 나무가 번식, 인접한 8개의 칸에 나이가 1인 나무가 생긴다, 벗어나면 xx
//겨울 : 각 땅에 양분 A[r][c]큼 추가 (입력)
//K년 후의 땅에 살아있는 나무의 개수 구하기
//x,y,z 나무의 위치, 나이  
public class Main {
	static int N,M,K; //땅 크기, 나무 개수, 년
	static int[][] A,map; 
	static int year;
	static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    static LinkedList<Tree> trees; //Tree클래스 형태로 LinkedList
    static Queue<Tree> dead; //죽은 나무 저장할 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1]; // r,c 1부터 시작
        A = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = 5;
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        trees = new LinkedList<>();
        dead = new LinkedList<>();
        		
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	trees.add(
        			new Tree(
        					Integer.parseInt(st.nextToken()), //x
        					Integer.parseInt(st.nextToken()), //y
        					Integer.parseInt(st.nextToken())  //z
        			)
        	);
        }
        
        season();
        System.out.println(trees.size());
        
        
	}
	
	static void season() {
		while (true) {
			if(year == K) return;
		
		//ㅎㅎ 
		//봄
		Iterator<Tree> iterator = trees.iterator();
		while(iterator.hasNext()) {
			Tree tree = iterator.next();
			int r = tree.x;
			int c = tree.y;
			int age = tree.z;
			
			if(map[r][c] - age < 0) { //맵에 남아있는 양분이 해당 나무의 나이보다 작다면  
				dead.offer(tree); //죽은 나무에 넣어주고
				iterator.remove(); //trees에서 나무 지우기  
			} else {
				map[r][c] -= age; //나이만큼 양분 빼주기
				tree.z += 1; //해당 객체에 나이 올려주기  
			}
		}
		
		//여름 
		//죽은 나무를 모두 영양분으로 대체할 때까지  
		while(!dead.isEmpty()) {
			Tree tree = dead.poll(); //죽은 나무에서 빼주고  
			map[tree.x][tree.y] += tree.z/2; //양분 채워넣기  
		}
		
		//가을
		//나무 생성  
		LinkedList<Tree> babyTrees = new LinkedList<>();
		for (Tree tree : trees) {
            int r = tree.x;
            int c = tree.y;
            if (tree.z % 5 != 0) continue; // 나이가 5의 배수가 아니면  
            for (int d = 0; d < 8; d++) { 
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 1 || nc < 1 || nr > N || nc > N) continue;
                babyTrees.add(new Tree(nr, nc, 1)); // 나이가 1인 나무 해당 좌표에 생성해주기  
            }
        }
		//trees에 대입  
		trees.addAll(0, babyTrees);
		
		//겨울  
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] += A[i][j]; //양분 공
			}
		}
		
		year++;
		}
		
	}
	
	static class Tree{
		int x;
		int y;
		int z;
		
		public Tree(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
}
