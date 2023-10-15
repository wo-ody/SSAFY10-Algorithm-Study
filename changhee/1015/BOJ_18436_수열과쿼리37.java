import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int n =Integer.parseInt(br.readLine());

        st=new StringTokenizer(br.readLine());
        int[] arr=new int[n];
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        SegmentTree tree= new SegmentTree(n);
        tree.init(arr,1,0,n-1);
        int m = Integer.parseInt(br.readLine());
        for(int i =0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            if(cmd==1){
                int index = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                tree.update(arr,1,0,n-1,index-1,val);
            }else if(cmd == 2){
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                int result = tree.evenQuery(1,0,n-1,left-1,right-1);
                answer.append(result).append("\n");
            }else{
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                int result = tree.oddQuery(1,0,n-1,left-1,right-1);
                answer.append(result).append("\n");
            }
        }


        System.out.println(answer);
    }
}

class SegmentTree{
    int[] oddTree;
    int[] evenTree;
    int treeSize;

    public SegmentTree(int arrSize) {
        treeSize=getTreeSize(arrSize);
        oddTree=new int[treeSize];
        evenTree=new int[treeSize];
    }

    public int getTreeSize(int arrSize){
        int h = (int)Math.ceil(Math.log(arrSize)/Math.log(2));
        return (int) Math.pow(2,h+1);
    }

    public void init(int[] arr,int node,int start, int end){
        if(start==end){
            if(arr[start]%2==1) oddTree[node] = 1;
            else evenTree[node] = 1;
            return;
        }

        init(arr,node*2,start,(start+end)/2);
        init(arr,node*2+1,(start+end)/2+1,end);
        oddTree[node] = oddTree[node*2]+oddTree[node*2+1];
        evenTree[node] = evenTree[node*2]+evenTree[node*2+1];
    }

    public void update(int []arr, int node, int start,int end,int index,int val){
        if(start>index || end < index){
            return;
        }

        if(start==end){
            arr[start] = val;
            if(val%2==1){
                evenTree[node]=0;
                oddTree[node] = 1;
            }
            else{
                oddTree[node]=0;
                evenTree[node] = 1;
            }
            return;
        }

        update(arr,node*2,start,(start+end)/2,index,val);
        update(arr,node*2+1,(start+end)/2+1,end,index,val);
        oddTree[node] = oddTree[node*2]+oddTree[node*2+1];
        evenTree[node] = evenTree[node*2]+evenTree[node*2+1];
    }

    public int oddQuery(int node, int start,int end,int left,int right){
        if(start > right || end < left){
            return 0;
        }

        if(left <= start && right >= end){
            return oddTree[node];
        }

        int lSum = oddQuery(node*2,start,(start+end)/2,left,right);
        int rSum = oddQuery(node*2+1,(start+end)/2+1,end,left,right);
        return lSum+rSum;
    }

    public int evenQuery(int node, int start,int end,int left,int right){
        if(start > right || end < left){
            return 0;
        }

        if(left <= start && right >= end){
            return evenTree[node];
        }

        int lSum = evenQuery(node*2,start,(start+end)/2,left,right);
        int rSum = evenQuery(node*2+1,(start+end)/2+1,end,left,right);
        return lSum+rSum;
    }
}
