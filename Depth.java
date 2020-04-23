package count;

public class Depth {

    /**
     * 最大最小深度
     */
    public int minDepth(TreeNode root){
        if (root==null)return 0;
        if (root.left == null){
            return minDepth(root.right)+1;
        }
        if (root.right == null){
            return minDepth(root.left)+1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }

    /**
     * 最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root){
        return root==null ? 0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }
}
