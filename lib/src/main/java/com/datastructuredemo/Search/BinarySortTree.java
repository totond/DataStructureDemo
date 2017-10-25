package com.datastructuredemo.Search;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.datastructuredemo.ArrayUtils;

/**
 * Created by yany on 2016/8/21.
 */
public class BinarySortTree<T extends Comparable<T>> {
    private Node<T> root;
    private int size;
    //节点结构
    class Node<T extends Comparable<T>>{
        public T value;
        public Node<T> left = null;
        public Node<T> right = null;
        public Node(T value){
            this.value = value;
        }
    }

    /*
     * 二叉排序树的递归查找方法，成功返回true，失败返回false
     * key参数为要查找的内容
     * rootNode参数为要查找的树的根结点
     */
    public Boolean BSTsearch_Recursive(T key,Node<T> rootNode){
        //当前根结点为空，则返回false
        if (rootNode == null){
            return false;
        }
        //查找内容等于当前根结点的内容，则返回true
        if (key.compareTo(rootNode.value) == 0){
            return true;
        }
        //查找内容等于当小于根结点的内容，则在当前根结点的左子结点继续查找
        else if (key.compareTo(rootNode.value) < 0){
            return BSTsearch_Recursive(key,rootNode.left);
        }
        //查找内容等于当大于根结点的内容，则在当前根结点的右子结点继续查找
        else {
            return BSTsearch_Recursive(key,rootNode.right);
        }
    }


    /*
     * 二叉排序树的非递归查找方法，成功返回true，失败返回false
     * key参数为要查找的内容
     * rootNode参数为要查找的树的根结点
     */
    public Boolean BSTsearch_Non_Recursive(T key,Node<T> rootNode){
        //当前根结点为空，则返回false
        if (rootNode == null){
            return false;
        }
        Node<T> temp = rootNode;
        while (temp != null){
            //查找内容等于当前根结点的内容，则返回true
            if (key.compareTo(temp.value) == 0){
                return true;
            }
            //查找内容等于当小于根结点的内容，则在当前根结点的左子结点继续查找
            else if (key.compareTo(temp.value) < 0){
                temp = temp.left;
            }
            //查找内容等于当大于根结点的内容，则在当前根结点的右子结点继续查找
            else {
                temp = temp.right;
            }
        }
        return false;
    }



    /*
     * 插入操作，要插入的值已经存在,则添加失败,返回false,如果值不存在,则添加成功,返回true
     * value参数为要插入的值
     * isRecursive参数为选择是否用递归实现
     */

    public Boolean add(T value){
        return add(value,false);
    }

    public Boolean add(T value,Boolean isRecursive){
        //检测根结点是否空
        if (root == null){
            root = new Node<T>(value);
            return true;
        }
        boolean flag = false;
        if (isRecursive){
            flag = insert_Recursive(value,root);
        }else {
            flag = insert_Non_Recursive(value,root);
        }
        if (flag){
            size++;
        }
        return flag;
    }

    /*
     * 插入操作的递归实现，要插入的值已经存在,则添加失败,返回false,如果值不存在,则添加成功,返回true
     * value参数为要插入的值
     * rootNode参数为当前插入的根结点，通过插入值与它的值进行对比来决定值插入到哪里
     */
    private Boolean insert_Recursive(T value,Node<T> rootNode){
        if (rootNode == null){
            rootNode = new Node<T>(value);
            return true;
        }
        //插入值与根结点的值进行对比，如果插入值比较小的话就插入到它的左子结点，否则是右子结点，如果值相等的话说明已存在，返回false
        else if (value.compareTo(rootNode.value) < 0){
            return insert_Recursive(value,rootNode.left);
        }else if (value.compareTo(rootNode.value) > 0){
            return insert_Recursive(value,rootNode.right);
        }else {
            return false;
        }
    }

    /*
     * 插入操作的非递归实现，要插入的值已经存在,则添加失败,返回false,如果值不存在,则添加成功,返回true
     * value参数为要插入的值
     * rootNode参数为当前插入的根结点，通过插入值与它的值进行对比来决定值插入到哪里
     */
    private Boolean insert_Non_Recursive(T value,Node<T> rootNode){
        if (rootNode == null){
            rootNode = new Node<T>(value);
            return true;
        }
        Node<T> temp = rootNode;
        Node<T> finalNode = temp;
        //用循环找出最后的插入结点
        while (temp != null){
            //设置最后结点
            finalNode = temp;
            //查找内容等于当前根结点的内容，则返回true
            if (value.compareTo(temp.value) == 0){
                return false;
            }
            //查找内容等于当小于根结点的内容，则在当前根结点的左子结点继续查找
            else if (value.compareTo(temp.value) < 0){
                temp = temp.left;
            }
            //查找内容等于当大于根结点的内容，则在当前根结点的右子结点继续查找
            else {
                temp = temp.right;
            }
        }
        if (value.compareTo(finalNode.value) < 0){
            finalNode.left = new Node<T>(value);
            return true;
        }else {
            finalNode.right= new Node<T>(value);
            return true;
        }
    }

    public boolean remove(T value){
        return Delete_Recursive(value,root);
//        return Delete_Non_Recursive(value,root);
    }


    public boolean Delete_Non_Recursive(T value,Node<T> rootNode) {
        if (rootNode == null) {
            return false;
        }
        if (value.compareTo(rootNode.value) == 0){
                    /*
         * 根据找到的删除节点的类型，分成以下几种情况
         */
            //如果被删除的节点是叶子结点，直接删除
            if (rootNode.left == null && rootNode.right == null){
                rootNode = null;
            }
            //如果被删除的节点含有一个子结点，让指向该结点的指针指向他的子结点
            else if (rootNode.left != null && rootNode.right == null){
                rootNode = rootNode.left;
            }
            else if (rootNode.left == null & rootNode.right != null){
                rootNode = rootNode.right;
            }
            //如果被删除的节点含有两个子结点，找到左子树的最大（最右）结点，并替换该结点
            else {
                Node<T> subTree = rootNode.left;
                while (subTree.right != null){
                    subTree = subTree.right;
                }
                //把值赋给删除结点，然后删除这个结点
                rootNode.value = subTree.value;
                Delete(subTree);
            }
            return true;
        }
        else if (value.compareTo(rootNode.value) < 0){
            return Delete_Non_Recursive(value,rootNode.left);
        }
        else {
            return Delete_Non_Recursive(value,rootNode.right);
        }
    }
    /*
     * 删除方法的递归实现,这里用于递归查找要删除的结点
     * value参数为要删除的值
     * rootNode参数为开始查找删除结点的根结点
     */
    private boolean Delete_Recursive(T value,Node<T> rootNode){
        if (rootNode == null){
            return false;
        }else {
            if (value.compareTo(rootNode.value) == 0){
                Delete(rootNode);
                return true;
            }
            else if (value.compareTo(rootNode.value) < 0){
                return Delete_Recursive(value,rootNode.left);
            }
            else {
                return Delete_Recursive(value,rootNode.right);
            }
        }
    }

    /*
     * 删除结点操作的具体实现
     */
    private void Delete(Node<T> rootNode){
        /*
         * 根据找到的删除节点的类型，分成以下几种情况
         */
        //如果被删除的节点是叶子结点，直接删除
        if (rootNode.left == null && rootNode.right == null){
            rootNode = null;
        }
        //如果被删除的节点含有一个子结点，让指向该结点的指针指向他的子结点
        else if (rootNode.left != null && rootNode.right == null){
            rootNode = rootNode.left;
        }
        else if (rootNode.left == null & rootNode.right != null){
            rootNode = rootNode.right;
        }
        //如果被删除的节点含有两个子结点，找到左子树的最大（最右）结点，并替换该结点
        else {
            Node<T> subTree = rootNode.left;
            while (subTree.right != null){
                subTree = subTree.right;
            }
            //把值赋给删除结点，然后删除这个结点
            rootNode.value = subTree.value;
            Delete(subTree);
        }
    }
    /*
     * 中序遍历，输出排好序的数组
     */
    public List<T> inOrderTraverse(){
        List<T> list = new ArrayList<>();
//        inOrderTraverse(list,root);
        inOrderNoRecursion(list,root);
        return list;
    }

    /*
     * 中序遍历的递归实现方法
     */
    private void inOrderTraverse(List<T> list,Node<T> currentNode){
        if (currentNode == null){
            return;
        }
        //先遍历左子结点
        inOrderTraverse(list,currentNode.left);
        list.add(currentNode.value);
        inOrderTraverse(list,currentNode.right);
    }

    /*
     * 中序遍历的非递归实现方法
     */
    private void inOrderNoRecursion(List<T> list,Node<T> currentNode) {
        Stack<Node<T>> s = new Stack<Node<T>>();
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
    public List<T> preOrderTraverse(){
        List<T> list = new ArrayList<>();
        preOrderNoRecursion(list,root);
        return list;
    }

    /*
     * 先序遍历的非递归实现方法
     */
    private void preOrderNoRecursion(List<T> list,Node<T> currentNode){
        Stack<Node<T>> stack = new Stack<Node<T>>();
        while (currentNode != null || !stack.empty() ){
            while (currentNode != null){
                list.add(currentNode.value);
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            if (!stack.empty()){
                currentNode = stack.pop();
                currentNode = currentNode.right;
            }
        }
    }

    /*
     * 后序遍历
     */
    public List<T> postOrderTraverse(){
        List<T> list = new ArrayList<>();
        postOrderNoRecursion(list,root);
        return list;
    }


    /*
     * 后序遍历的非递归实现
     */
    private void postOrderNoRecursion(List<T> list,Node<T> currentNode){
        Stack<Node<T>> stack = new Stack<Node<T>>();
        Node<T> prev = currentNode;
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

    public static void main(String[] args) {
        BinarySortTree<Integer> binarySortTree = new BinarySortTree<>();
        binarySortTree.add(22);
        binarySortTree.add(45);
        binarySortTree.add(34);
        binarySortTree.add(56);
        binarySortTree.add(10);

        System.out.println("中序遍历：");
        ArrayUtils.printList(binarySortTree.inOrderTraverse());
        System.out.println("先序遍历：");
        ArrayUtils.printList(binarySortTree.preOrderTraverse());
        System.out.println("后序遍历：");
        ArrayUtils.printList(binarySortTree.postOrderTraverse());
        System.out.println("移除元素34" + binarySortTree.remove(34));
        ArrayUtils.printList(binarySortTree.inOrderTraverse());
    }
}
