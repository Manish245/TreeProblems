package com.TreeProblems;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class TreeTraversals {
    /*
1. Tree Traversals.
     */
    public static void printPreOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.data + ",");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    /*
1. Tree Traversals.
     */
    public static void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.data + ",");
        printInOrder(node.right);
    }

    /*
    1. Tree Traversals.
     */
    public static void printPostOrder(TreeNode node) {
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.data + ",");

    }

    public static void printBreadthFirstOrder(TreeNode node) {


    }

    /*
    Inorder Tree Traversal without Recursion.
     */
    public static void printInorderwithoutRecursion(TreeNode node) {

        if (node == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // stack.push(node);
        TreeNode current = node;
        while (current != null) {
            stack.push(current);
            if (current.left != null) {
                current = current.left;
            } else
                current = null;


            while (stack.size() > 0 && current == null) {
                current = stack.pop();
                System.out.print(current.data + ",");
                if (current.right != null) {
                    current = current.right;
                } else
                    current = null;

            }
        }

    }

    /*
    Print Postorder traversal from given Inorder and Preorder traversals
    Input:
    Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
    Preorder traversal int[] = {1, 2, 4, 5, 3, 6}

    Output:
    Postorder traversal is {4, 5, 2, 6, 3, 1}
     */

    public static TreeNode genrateTreeFromTraversal(int[] preorder,int[] inorder,int inorderS,int inorderE,int preorderS,int preorderE){

        if(inorderS>=inorderE) return null;
        int rootindex=-1;
        int rootData=preorder[preorderS];
        for(int i=inorderS; i<inorderE;i++){
              if(inorder[i]==rootData){
                  rootindex=i;
                  break;
              }

        }
            TreeNode node = new TreeNode(inorder[rootindex]);
            node.left = genrateTreeFromTraversal(preorder, inorder, inorderS, rootindex+1, preorderS + 1, rootindex+1);
            node.right = genrateTreeFromTraversal(preorder, inorder, rootindex + 1, inorderE, rootindex+1, preorderE);
            return node;


    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length==0){
            return null;
        }


        int preorder_index=1;
        int inorder_index=0;
        Stack<TreeNode> treestack=new Stack<>();
        TreeNode root=new TreeNode(preorder[0]);
        treestack.push(root);
        TreeNode lastpoped=null;
       // Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
       // Preorder traversal int[] = {1, 2, 4, 5, 3, 6}
        while(preorder_index<preorder.length && inorder_index<inorder.length){
            if(treestack.isEmpty() || treestack.peek().data!=inorder[inorder_index]){
                TreeNode newnode=new TreeNode(preorder[preorder_index]);
                if(lastpoped!=null){
                    lastpoped.right=newnode;
                }else if(!treestack.isEmpty()){
                    treestack.peek().left=newnode;
                }
                treestack.push(newnode);
                preorder_index++;
                lastpoped=null;
            }else{
                lastpoped=treestack.pop();
                inorder_index++;
            }
        }
        return root;
    }

        public  static  TreeNode connstructTreeUsingInorder_preorder(int[] preorder,int[] inorder){
        if(inorder.length==0) return null;
        int rootData=preorder[0];
        int rootIndex=-1;
        for(int i=0;i<inorder.length;i++){
            if(rootData==inorder[i]){
                rootIndex=i;
                break;
            }
        }
        TreeNode node=new TreeNode(rootData);
        int[] lPre=sliceArray(preorder,1,rootIndex+1);
        int[] lin=sliceArray(inorder,0,rootIndex);
        int[] rPre=sliceArray(preorder,rootIndex+1,preorder.length);
        int[] rin=sliceArray(inorder,rootIndex+1,inorder.length);
        node.left=connstructTreeUsingInorder_preorder(lPre,lin);
        node.right=connstructTreeUsingInorder_preorder(rPre,rin);
            System.out.println();
        System.out.print(node.data+",");
        return node;
        }
        private static int[] sliceArray(int[] array,int start,int end){
        int[] ar=new int[end-start];
        for(int i=start,j=0;i<end;i++,j++){
            ar[j]=array[i];
        }
        return ar;

        }

}
