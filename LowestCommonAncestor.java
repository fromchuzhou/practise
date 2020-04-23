package count;

public class LowestCommonAncestor {

    /**
     * 二叉树的最近公共祖先 递归的实现方式
     */
    public TreeNode lowestCommonAncestor(TreeNode node,TreeNode p,TreeNode q){
        if (node == null || node==q || node==p)return node;
        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);
        if (left==null){
            return right;
        }else if (right==null){
            return left;
        }else{
            return node;
        }
    }

    /**
     * 非递归的方式
     * @param
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root,TreeNode p,TreeNode q){
        while (root!=null){
            if (p.value < root.value && q.value<root.value){
                root=root.left;
            }else if (p.value>root.value && q.value>root.value){
                root=root.right;
            }else{
                return root;
            }
        }
        return null;
    }

    static class TreeNode{
        private int value;
        private TreeNode left;
        private TreeNode right;
    }
}
