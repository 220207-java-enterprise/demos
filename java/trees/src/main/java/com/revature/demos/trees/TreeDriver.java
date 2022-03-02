package com.revature.demos.trees;

import java.util.ArrayDeque;
import java.util.Stack;

public class TreeDriver {

    public static void main(String[] args) {

        BinaryTree tree = BinaryTree.createAndPopulate();
        tree.printPreOrder_withRecursion(tree.root);
        System.out.println("+---------------------------+");
        tree.printPreOrder_withoutRecursion();

    }

}
