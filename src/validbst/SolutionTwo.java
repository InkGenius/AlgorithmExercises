package validbst;

public class SolutionTwo {

	public static boolean isValidBST(TreeNode root) {
		return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean valid(TreeNode p, int low, int high) {
		if (p == null)
			return true;
		return p.val > low && p.val < high && valid(p.left, low, p.val) && valid(p.right, p.val, high);
	}

	public static void main(String[] args) {
		TreeNode node6 = new TreeNode(6, null, null);
		TreeNode node20 = new TreeNode(20, null, null);
		TreeNode node15 = new TreeNode(15, node6, node20);
		TreeNode node5 = new TreeNode(5, null, null);
		TreeNode root = new TreeNode(10, node5, node15);
		System.out.println(isValidBST(root));
	}
}
