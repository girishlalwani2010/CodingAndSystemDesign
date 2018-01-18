package goldmannsachs;
import java.util.LinkedList;
import java.util.Queue;

class Fraction{
	int a,b;
	String data;
	
	Fraction(){
		data = a+"/"+b;
	}
	
	public String getStringValue(){
		return data;
	}
}


class TreeNode {
	String data;
	TreeNode left;
	TreeNode right;

	public TreeNode(String data) {
		this.data = data;
	}
}


public class CustomBinaryTree {
	
	
	static void createTree(TreeNode root){
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		int level = 21;

		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			
			if(node==null){
				level--;
				if(!queue.isEmpty())
					queue.add(null);
			}
			else{
				String leftData = Integer.parseInt(node.data.split("/")[0]) + "/" + (Integer.parseInt(node.data.split("/")[0])+Integer.parseInt(node.data.split("/")[1]));
				node.left = new TreeNode(leftData);
				queue.add(node.left);
				
				String rightData = (Integer.parseInt(node.data.split("/")[0])+Integer.parseInt(node.data.split("/")[1])) + "/" + Integer.parseInt(node.data.split("/")[1]);
				node.right = new TreeNode(rightData);
				queue.add(node.right);
			}
			
			if(level==0)
				break;
			
			
		}	
		
		System.out.println("");
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode("1/1");
		createTree(root);
	}
	
	
	
}
