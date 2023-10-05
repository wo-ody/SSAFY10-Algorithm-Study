import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class boj_1347_미로만들기 {
	static class Point{
		int x,y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public void increase(int addx, int addy) {
			this.x += addx;
			this.y += addy;
		}
	}

	static int N;
	static int cx = 0;
	static int cy = 0;
	static char[][] result = new char[100][100];
	
	static List<Point> lst = new ArrayList<>();
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int dir = 2;
	
	static StringBuilder sb = new StringBuilder();
	public static void make_road(char ch) {
		if(ch == 'F') {
			cx += dx[dir];
			cy += dy[dir];
			lst.add(new Point(cx, cy));
		}
		else if(ch == 'L') {
			dir--;
			if(dir == -1) dir = 3;
		}
		else if(ch == 'R') {
			dir = (dir + 1) % 4;
		}
	}
	
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 100; i++) {
		    for (int j = 0; j < 100; j++) {
		        result[i][j] = '#';
		    }
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		// 미로 만듬
		lst.add(new Point(cx,cy));
		for (int i = 0; i < N; i++) {
			make_road(s.charAt(i));
		}
		
		// 정렬 
		Collections.sort(lst, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if(o1.x == o2.x) return o1.y - o2.y;
				return o1.x - o2.x; 
			}
		});
		
		// 맨 앞 원소 (0,0)와의 차이만큼 더하고(result 배열에 .넣기) + 출력을 위한 rx,ry 갱신
		int rx = -1;
		int ry = -1;
		int sx = 100;
		int sy = 100;
		for(Point point : lst) {
			if(point.x < sx) sx = point.x;
			if(point.y < sy) sy = point.y;
		}
		int addx = 0 - sx;
		int addy = 0 - sy;
		
		for(Point point : lst) {
			point.increase(addx,addy);
			result[point.x][point.y] = '.';
			if(point.x > rx) rx = point.x;
			if(point.y > ry) ry = point.y;
		}
		
		// rx,ry만큼 출력
		for(int i=0;i<=rx;i++) {
			for (int j = 0; j <= ry; j++) {
				sb.append(result[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
		
	}

}
