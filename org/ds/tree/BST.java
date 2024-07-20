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

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>(25);
        bst.addNode(12);
        bst.addNode(29);
        bst.addNode(18);
        bst.addNode(15);
        bst.addNode(26);
        bst.addNode(35);
        bst.addNode(14);

        /*
                 25
                /  \
              12    29
                \   / \
                18 26  35
               /
              15
             /
            14
         */

        TreeTraversal<Integer> tree = new TreeTraversal<>();
        tree.postOrder(bst.root);
    }
}
