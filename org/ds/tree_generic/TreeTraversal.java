package org.ds.tree_generic;

public class TreeTraversal<T> {

    void preOrder(TreeNode<T> root){
        if(root == null) return;
        System.out.print(root.value+" ");
        preOrder(root.left);
        preOrder(root.right);

    }

    void inOrder(TreeNode<T> root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.value+" ");
        inOrder(root.right);

    }

    void postOrder(TreeNode<T> root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value+" ");

    }



    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        TreeNode<Integer> left = new TreeNode<>(2);
        left.left = new TreeNode<>(5);
        TreeNode<Integer> right = new TreeNode<>(3);
        right.left = new TreeNode<>(7);
        root.left = left;
        root.right  = right;;

        TreeTraversal<Integer> traversal = new TreeTraversal<>();
        traversal.preOrder(root);
        System.out.println();
        traversal.inOrder(root);
        System.out.println();
        traversal.postOrder(root);

    }
}
