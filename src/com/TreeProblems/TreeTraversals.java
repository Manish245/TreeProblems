package com.TreeProblems;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class TreeTraversals {
    public static void printPreOrder(TreeNode node){
        if(node==null)return;
        System.out.print(node.data+",");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
    public static void printInOrder(TreeNode node){
        if(node==null)return;
        printInOrder(node.left);
        System.out.print(node.data+",");
        printInOrder(node.right);
    }

    public static void printPostOrder(TreeNode node){
        if(node==null)return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data+",");

    }
    public static void printBreadthFirstOrder(TreeNode node){


    }
    /*
    Inorder Tree Traversal without Recursion.
     */
    public static void printInorderwithoutRecursion(TreeNode node){

        if(node==null) return;
        Stack<TreeNode> stack=new Stack<TreeNode>();
       // stack.push(node);
        TreeNode current=node;
        while (current!=null) {
            stack.push(current);
            if (current.left != null) {
                current = current.left;
            } else
                current = null;


            while (stack.size()>0 && current==null) {
                current = stack.pop();
                System.out.print(current.data + ",");
                if (current.right != null) {
                    current = current.right;
                }
                else
                    current=null;

            }
        }

    }
}
