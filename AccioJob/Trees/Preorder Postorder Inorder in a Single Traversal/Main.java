// https://course.acciojob.com/idle?question=e4bec89a-4907-4b75-9ff7-f9defb7ba20f

import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class Main {
    static Node buildTree(String str){
       // System.out.print(str);
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root);
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            Node currNode = queue.peek();
            queue.remove();
            String currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
            i++;
            if(i >= ip.length)
                break;   
            currVal = ip[i];
            if(!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    
    public static void main (String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    Scanner sc = new Scanner(System.in);
            
		String s = sc.nextLine();               
		Node root = buildTree(s);
		Solution tree = new Solution();
		tree.allTraversal(root);
        sc.close();
	}
}

class Solution {
	
	static class Helper{
	    Node node;
	    int state;
	    Helper(Node node,int state){
		    this.node = node;
		    this.state = state;
	    }
    }

    private static void print(ArrayList<Integer> ans) {
	    for(int i = 0; i < ans.size(); i++) {
		    System.out.print(ans.get(i) + " ");
	    }   
	    System.out.println("");
    }
    public void allTraversal(Node root) {
		//Write your code here
		ArrayList<Integer> pre = new ArrayList<>();
		ArrayList<Integer> in = new ArrayList<>();
		ArrayList<Integer> post = new ArrayList<>();
		
		Stack<Helper> st = new Stack<>();
		st.push(new Helper(root, 0));

		while(st.size() > 0) {
			Helper top = st.peek();
			if(top.state == 0){
				// preorder
				pre.add(top.node.data);
				if(top.node.left != null) st.push(new Helper(top.node.left,0));
				top.state++;
			}else if(top.state == 1){
				//inorder
				in.add(top.node.data);
				if(top.node.right != null) st.push(new Helper(top.node.right,0));
				top.state++;
			}
			else if(top.state == 2){
				// postorder
				post.add(top.node.data);
				top.state++;
				st.pop();
			}
		}
		print(pre);
		print(in);
		print(post);
        
	}
}