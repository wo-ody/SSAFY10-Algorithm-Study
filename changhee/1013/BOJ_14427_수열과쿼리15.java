import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();
		
		int n =Integer.parseInt(br.readLine());
		int[]arr=new int[n];
		
		st=new StringTokenizer(br.readLine());
		for(int i =0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		SegmentTree tree= new SegmentTree(n);
		tree.init(arr, 1, 0, n-1);
		
		int m = Integer.parseInt(br.readLine());
		for(int i =0; i<m; i++) {
			st=new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			
			if(cmd==2) {
				answer.append(tree.tree[1]+1).append("\n");
			}else {
				int index =Integer.parseInt(st.nextToken());
				int val =Integer.parseInt(st.nextToken());
				tree.update(arr, 1, 0, n-1, index-1, val);
			}
		}
		
		System.out.println(answer);
		
	}
}

class SegmentTree{
	int[] tree;
	int treeSize;
	
	public SegmentTree(int arrSize) {
		treeSize = getTreeSize(arrSize);
		tree=new int[treeSize];
	}
	
	public int getTreeSize(int arrSize) {
		int h = (int)(Math.ceil(Math.log(arrSize)/Math.log(2)));
		return (int) Math.pow(2, h+1);
	}
	
	public void init(int[] arr, int node, int start, int end) {
		if(start==end) {
			tree[node] = start;
			return;
		}
		
		init(arr,node*2,start,(start+end)/2);
		init(arr,node*2+1,(start+end)/2+1, end);
		
		if(arr[tree[node*2]] <=arr[tree[node*2+1]]) {
			tree[node] = tree[node*2];
		}else {
			tree[node] = tree[node*2+1];
		}
	}

	
	public void update(int[] arr,int node, int start, int end, int index, int val) {
		if(index < start || index > end) {
			return ;
		}
		
		if(start == end) {
			arr[index] = val;
			tree[node] = index;
			return;
		}
		
		update(arr,node*2,start,(start+end)/2, index, val);
		update(arr,node*2+1,(start+end)/2+1,end, index, val);
		
		if(arr[tree[node*2]] <= arr[tree[node*2+1]]) {
			tree[node] = tree[node*2];
		}else {
			tree[node] = tree[node*2+1];
		}
	}
}
