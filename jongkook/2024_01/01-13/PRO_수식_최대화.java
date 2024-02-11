package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_5639_이진_검색_트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        structure.BOJ_5639_이진_검색_트리.Node root = new structure.BOJ_5639_이진_검색_트리.Node(Integer.parseInt(br.readLine()));
        String str;
        while(true){
            str = br.readLine();
            if(str == null) break;
            root.insert(Integer.parseInt(str));
        }
//        System.out.println(root);
        postOrder(root);

    }
    static void postOrder(structure.BOJ_5639_이진_검색_트리.Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
    static class Node{
        int num;
        structure.BOJ_5639_이진_검색_트리.Node left, right;
        Node(int num){ this.num = num; }
        Node(int num, structure.BOJ_5639_이진_검색_트리.Node left, structure.BOJ_5639_이진_검색_트리.Node right){
            this.num = num;
            this.left = left;
            this.right = right;
        }
        void insert(int n){
            // n이 현재노드 보다 작다면 왼쪽
            if(n < this.num){
                if(this.left == null) this.left = new structure.BOJ_5639_이진_검색_트리.Node(n);
                else this.left.insert(n);
            }
            else{
                if(this.right == null) this.right = new structure.BOJ_5639_이진_검색_트리.Node(n);
                else this.right.insert(n);
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
