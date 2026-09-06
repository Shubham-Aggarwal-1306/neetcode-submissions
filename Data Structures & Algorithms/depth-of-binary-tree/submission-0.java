/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        Queue<TreeNode> bq = new LinkedList<TreeNode>();

        int depth = 0;

        bq.offer(root);

        while (!bq.isEmpty()) {
            int size = bq.size();
            for (int i=0; i<size; i++) {
                TreeNode node = bq.poll();
                if (node.left != null) {
                    bq.add(node.left);
                }

                if (node.right != null) {
                    bq.add(node.right);
                }

            }
            depth++;
        }

        return depth;
    }
}
