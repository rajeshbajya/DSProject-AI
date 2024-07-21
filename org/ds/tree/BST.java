package org.ds.tree;

import com.sun.source.tree.Tree;

public class BST<T extends Comparable<T>> {
    private TreeNode<T> root;

    public BST() {
    }

    public BST(T value) {
        root = new TreeNode<>(value);
    }

    public TreeNode<T> addNode(T value) {
        if (root == null) {
            root = new TreeNode<>(value);
            return root;
        } else {
            return addNodeHelper(root, value);
        }
    }

    private TreeNode<T> addNodeHelper(TreeNode<T> root, T value) {
        if (root == null) {
            return new TreeNode<>(value);
        }
        if (value.compareTo(root.value) < 0) {
            root.left = addNodeHelper(root.left, value);
        } else if (value.compareTo(root.value) > 0) {
            root.right = addNodeHelper(root.right, value);
        }
        return root;
    }

    public TreeNode<T> lowestCommonAncestor(TreeNode<T> root,T n1, T n2)  {
        if(root == null) return root;
        else{
           if(root.value.compareTo(n1)>=0 && root.value.compareTo(n2)<=0
             ||root.value.compareTo(n2)>=0 && root.value.compareTo(n1)<=0){
               return root;
           }else if(root.value.compareTo(n1)>=0 || root.value.compareTo(n2)>=0){
               return lowestCommonAncestor(root.left,n1,n2);
           }else{
               return lowestCommonAncestor(root.right,n1,n2);
           }
        }
    }

    public TreeNode<T> deleteNode(TreeNode<T> root, T key) {
        if (root == null) {
            return null;
        }
        if (key.compareTo(root.value) < 0) {
            root.left = deleteNode(root.left, key);
        } else if (key.compareTo(root.value) > 0) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Node with two children: Get the inorder successor (smallest in the right subtree)
            TreeNode<T> temp = minValueNode(root.right);
            root.value = temp.value;
            root.right = deleteNode(root.right, temp.value);
        }
        return root;
    }

    private TreeNode<T> minValueNode(TreeNode<T> node) {
        TreeNode<T> current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }


    public static void main(String[] args) {


        /*
                 25
                /  \
              12    29
             /  \   / \
          10    18 26  35
               /
              15
             /
            14
         */
        BST<Integer> bst = new BST<>(25);
        bst.addNode(12);
        bst.addNode(29);
        bst.addNode(18);
        bst.addNode(15);
        bst.addNode(26);
        bst.addNode(35);
        bst.addNode(14);
        bst.addNode(10);
        TreeTraversal<Integer> tree = new TreeTraversal<>();
        tree.inOrder(bst.root);
//        TreeNode<Integer> result = bst.lowestCommonAncestor(bst.root,26 ,18);
//        System.out.println(result == null? "null" : result.value);
        bst.deleteNode(bst.root,14);
        System.out.println();
        tree.inOrder(bst.root);
    }
}
