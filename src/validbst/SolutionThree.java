package validbst;

public class SolutionThree {

	private TreeNode prev;

	public boolean isValidBST(TreeNode root) {
		prev = null;
		return isMonotonicIncreasing(root);
	}

	private boolean isMonotonicIncreasing(TreeNode p) {
		if (p == null)
			return true;
		if (isMonotonicIncreasing(p.left)) {
			if (prev != null && p.val <= prev.val)
				return false;
			prev = p;
			return isMonotonicIncreasing(p.right);
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode node6 = new TreeNode(6, null, null);
		TreeNode node20 = new TreeNode(20, null, null);
		TreeNode node15 = new TreeNode(15, node6, node20);
		TreeNode node5 = new TreeNode(5, null, null);
		TreeNode root = new TreeNode(10, node5, node15);
		SolutionOne main = new SolutionOne();
		System.out.println(main.isValidBST(root));
	}
}
