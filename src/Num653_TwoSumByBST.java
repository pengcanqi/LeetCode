import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Num653_TwoSumByBST {

	public static int[] twoSum(int[] numbers, int target) {
		if(numbers == null || numbers.length < 2) {
			return null;
		}
		int length = numbers.length;
		int j = 0;
		int k = length - 1;
		while (j != k && numbers[j] + numbers[k] != target) {
			while (j != k && numbers[j] + numbers[k] > target) {
				k--;
			}
			while (j != k && numbers[j] + numbers[k] < target) {
				j++;
			}
		}
		return j == k ? null : new int[] {j+1, k+1};      
	}
	
	public static boolean findTarget(TreeNode root, int k) {
		if (root == null || (root.left == null && root.right == null)) {
			return false;
		}
		
		Stack<TreeNode> preTraversalStack = new Stack<>();
		List<TreeNode> nodeList = new ArrayList<>();
		
		preTraversalStack.push(root);
		while (!preTraversalStack.isEmpty()) {
			while (preTraversalStack.peek().left != null) {
				preTraversalStack.push(preTraversalStack.peek().left);
			}
			while (!preTraversalStack.isEmpty()) {
				TreeNode top = preTraversalStack.pop();
				nodeList.add(top);
				
				if(top.right != null) {
					preTraversalStack.push(top.right);
					break;
				}
			}
		}
		
		int[] value = new int[nodeList.size()];
		int i = 0;
		for (TreeNode node : nodeList) {
			value[i++] = node.val;
		}
		
		int[] result = twoSum(value, k);
		
		return result == null ? false : true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(6);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(7);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.right = node5;
		System.out.println(findTarget(root, 9));
	}

}
