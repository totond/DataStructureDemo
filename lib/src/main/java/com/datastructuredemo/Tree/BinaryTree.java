package com.datastructuredemo.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import jdk.nashorn.internal.ir.BinaryNode;

/**
 * 二叉树实现，在想要不要删掉
 */

public class BinaryTree<T> {
    private BinaryTreeNode<T> rootNode;

    public static class BinaryTreeNode<T> {
        public BinaryTreeNode<T> left;
        public BinaryTreeNode<T> right;
        public T value;
    }

    /*
 * 中序遍历，输出排好序的数组
 */
    public ArrayList<T> inOrderTraverse() {
        ArrayList<T> list = new ArrayList<>();
//        inOrderTraverse(list,root);
        inOrderNoRecursion(list, rootNode);
        return list;
    }

    /*
     * 中序遍历的递归实现方法
     */
    private void inOrderTraverse(List<T> list, BinaryTreeNode<T> currentNode) {
        if (currentNode == null) {
            return;
        }
        //先遍历左子结点
        inOrderTraverse(list, currentNode.left);
        list.add(currentNode.value);
        inOrderTraverse(list, currentNode.right);
    }

    /*
     * 中序遍历的非递归实现方法
     */
    private void inOrderNoRecursion(List<T> list, BinaryTreeNode<T> currentNode) {
        Stack<BinaryTreeNode<T>> s = new Stack<>();
        while (currentNode != null || !s.empty()) {
            while (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            }
            if (!s.empty()) {
                currentNode = s.pop();
                list.add(currentNode.value);
                currentNode = currentNode.right;
            }
        }
    }

    /*
     * 先序遍历
     */
    public List<T> preOrderTraverse() {
        List<T> list = new ArrayList<>();
        preOrderNoRecursion(list, rootNode);
        return list;
    }

    /*
     * 先序遍历的非递归实现方法
     */
    private void preOrderNoRecursion(List<T> list, BinaryTreeNode<T> currentNode) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        while (currentNode != null || !stack.empty()) {
            while (currentNode != null) {
                list.add(currentNode.value);
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            if (!stack.empty()) {
                currentNode = stack.pop();
                currentNode = currentNode.right;
            }
        }
    }

    /*
     * 后序遍历
     */
    public List<T> postOrderTraverse() {
        List<T> list = new ArrayList<>();
        postOrderNoRecursion(list, rootNode);
        return list;
    }


    /*
     * 后序遍历的非递归实现
     */
    private void postOrderNoRecursion(List<T> list, BinaryTreeNode<T> currentNode) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> prev = currentNode;
        while (currentNode != null) {
            while (currentNode.left != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            while (currentNode != null && (currentNode.right == null || currentNode.right == prev)) {
                list.add(currentNode.value);
                prev = currentNode;
                if (stack.empty()) {
                    return;
                }
                currentNode = stack.pop();
            }
            //处理右子树
            stack.push(currentNode);
            currentNode = currentNode.right;
        }
    }

    //层序遍历
    /*
        先将树的根节点入队，

    如果队列不空，则进入循环

    {

      将队首元素出队，并输出它；

      如果该队首元素有左孩子，则将其左孩子入队；

      如果该队首元素有右孩子，则将其右孩子入队

    }
     */
    public void levelTraverse(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(root);
        BinaryTreeNode current;
        while (!queue.isEmpty()){
            current = queue.poll();
            if (current.left != null){
                queue.offer(current.left);
            }
            if (current.right != null){
                queue.offer(current.right);
            }
        }
    }

}


