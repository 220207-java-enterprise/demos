package com.revature.demos.trees;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class BinaryTree {

    TreeNode root;

    /**
     * Write logic to traverse a binary tree using PreOrder traversal without recursion.
     * In preorder traversal, each node value is printed (starting with the root node),
     * then the left subtrees are traversed, followed by the right subtrees.
     *
     * Expected output: a b c d e f
     */
    public void printPreOrder_withRecursion(TreeNode node) {

        if (node == null) {
            return;
        }

        System.out.println(node.data);
        printPreOrder_withRecursion(node.left);
        printPreOrder_withRecursion(node.right);

    }

    /**
     * Write logic to traverse a binary tree using PreOrder traversal without recursion.
     * In preorder traversal, each node value is printed (starting with the root node),
     * then the left subtrees are traversed, followed by the right subtrees.
     *
     * Expected output: a b c d e f
     */
    public void printPreOrder_withoutRecursion() {
        ArrayDeque<TreeNode> nodeStack = new ArrayDeque<>();
        nodeStack.push(this.root);

        while(!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            System.out.println(currentNode.data);

            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
            }

            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
            }
        }
    }

    /**
     * Produced tree structure:
     *          a
     *         / \
     *        b   e
     *       / \   \
     *      c   d   f
     */
    public static BinaryTree createAndPopulate() {

        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode("a");
        tree.root = root;
        tree.root.left = new TreeNode("b");
        tree.root.left.left = new TreeNode("c");
        tree.root.left.right = new TreeNode("d");
        tree.root.right = new TreeNode("e");
        tree.root.right.right = new TreeNode("f");

        return tree;
    }

    static class TreeNode {
        String data;
        TreeNode left;
        TreeNode right;

        TreeNode(String data) {
            this.data = data;
        }
    }


}
