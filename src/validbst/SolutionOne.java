package validbst;

public class SolutionOne {

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		return isSubtreeLessThan(root.left, root.val) && isSubtreeGreaterThan(root.right, root.val)
				&& isValidBST(root.left) && isValidBST(root.right);
	}

	private boolean isSubtreeLessThan(TreeNode p, int val) {
		if (p == null)
			return true;
		return p.val < val && isSubtreeLessThan(p.left, val) && isSubtreeLessThan(p.right, val);
	}

	private boolean isSubtreeGreaterThan(TreeNode p, int val) {
		if (p == null)
			return true;
		return p.val > val && isSubtreeGreaterThan(p.left, val) && isSubtreeGreaterThan(p.right, val);
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
