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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> dq = new LinkedList<>();
        Deque<TreeNode> dq2 = new LinkedList<>();

        dq.offer(p);
        dq2.offer(q);

        while (!dq.isEmpty() && !dq2.isEmpty()) {
            for (int i=0; i<dq.size(); i++) {
                TreeNode curr = dq.poll();
                TreeNode curr2 = dq2.poll();
                if (curr == null && curr2 == null) {
                    continue;
                }

                if (curr == null || curr2 == null || curr.val != curr2.val) {
                    return false;
                }
                dq.offer(curr.left);
                dq.offer(curr.right);
                dq2.offer(curr2.left);
                dq2.offer(curr2.right);
            }
        }
        return true;

    }
}
