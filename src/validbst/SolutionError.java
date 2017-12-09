package validbst;

public class SolutionError {

	public static boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		if (root.left != null && root.left.val > root.val){
			return false;
		}
		if (root.right != null && root.right.val < root.val){
			return false;
		}
		
		return isValidBST(root.left) && isValidBST(root.right);
	}

	public static void main(String[] args) {
		TreeNode node6 = new TreeNode(6,null,null);
		TreeNode node20 = new TreeNode(20,null,null);
		TreeNode node15 = new TreeNode(15,node6,node20);
		TreeNode node5 = new TreeNode(5,null,null);
		TreeNode root = new TreeNode(10,node5,node15);
		System.out.println(isValidBST(root));
	}
}
