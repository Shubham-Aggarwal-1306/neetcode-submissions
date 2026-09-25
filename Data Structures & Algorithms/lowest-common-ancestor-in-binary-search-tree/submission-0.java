class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);
        parent.put(root, null);

        // Build parent relationships until both nodes are found
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode curr = queue.poll();

            if (curr.left != null) {
                parent.put(curr.left, curr);
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                parent.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }

        // Store all ancestors of p
        Set<TreeNode> ancestors = new HashSet<>();

        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // First ancestor of q that is also an ancestor of p
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }

        return q;
    }
}