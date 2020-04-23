package count;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelDiscussion {

    private List<List<Integer>> levels=new ArrayList<>();

    /**
     * 按层遍历二叉树,递归实现
     */
    public void helper(TreeNode node,int level){
        if (levels.size() == level)levels.add(new ArrayList<>());
        levels.get(level).add(node.value);
        if (node.left!=null){
            helper(node.left,level+1);
        }
        if (node.right!=null){
            helper(node.right,level+1);
        }
    }


    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
    }

    /**
     * 广度优先搜索
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null)return levels;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level=0;
        while(!queue.isEmpty()){
            levels.add(new ArrayList<>());
            int level_length = queue.size();
            for (int i = 0; i < level_length; i++) {
                TreeNode node = queue.remove();
                levels.get(level).add(node.value);
                if (node.left!=null)queue.add(node.left);
                if (node.right!=null)queue.add(node.right);
            }
            level++;
        }
        return levels;
    }
}
