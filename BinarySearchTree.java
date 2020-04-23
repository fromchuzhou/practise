package count;

import java.util.Stack;

public class BinarySearchTree {
    /**
     * 验证是二叉搜索树,递归的方式
     */
    public boolean  isBST(TreeNode node,Integer lower,Integer upper){
        if (node==null)return true;
        int val = node.value;
        if (lower !=null && val<=lower)return false;
        if (upper !=null && val>=upper)return false;

        if (!isBST(node.left,lower,val))return false;
        if (!isBST(node.right,val,upper))return false;
        return true;
    }

    public boolean isValidBST(TreeNode root){
        return isBST(root,null,null);
    }
    private Integer preValue=Integer.MIN_VALUE;
    /**
     * 采用中序递归的方式
     */
    public boolean isValidBinarySearchTree(TreeNode root){
        if (root == null) return true;
        if (isValidBinarySearchTree(root.left)){
            if (preValue != null && preValue >= root.value)return false;
            preValue=root.value;
            return isValidBinarySearchTree(root.right);
        }
        return false;
    }

    /**
     * 采用中序迭代的方式
     */
    public boolean isValidBST1(TreeNode root){
        if (root == null)return true;

        Integer preValue=null;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || node!=null){
            while (node!=null){
                stack.push(node);
                node=node.left;
            }
            node = stack.pop();
            if (preValue==null){
                preValue=node.value;
            }else if (preValue>=node.value){
                return false;
            }
            preValue=node.value;
            node=node.right;
        }
        return true;
    }

    static class TreeNode{
        private int value;
        private TreeNode left;
        private TreeNode right;
    }
}
