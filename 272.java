/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) ->
                                Double.compare(Math.abs(target - o2),
                                       Math.abs(target - o1)));
        
        List<Integer> ans = new ArrayList<>();
        preOrder(root, queue, k, target);
        
        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }
        return ans;
    }

    private void preOrder(TreeNode node, 
                          PriorityQueue<Integer> queue, 
                          int k, 
                          double target) {
        
        if (node == null) return;
        
        if (queue.size() < k) {
            queue.offer(node.val);
        } else if (!queue.isEmpty() &&
                   Math.abs(target - node.val) < Math.abs(target - queue.peek())) {
            queue.poll();
            queue.offer(node.val);
        }
        
        preOrder(node.right, queue, k, target);
        preOrder(node.left, queue, k, target);
    }
}
