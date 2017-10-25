package com.datastructuredemo.LinkedList;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 单向链表
 */
public class UnidirectionalLinkedList<T> {
    //节点结构
    private class Node<T>{
        private T data;
        private Node<T> next ;
        public Node(T data){
            this.data = data;
        }
    }


    //头结点
    private Node<T> first;
    //当前结点
    private Node<T> currentNode;
    //链表长度
    private int size;

    //构造函数，用于初始化
    public UnidirectionalLinkedList(){
        currentNode = first = null;
        size = 0;
    }

    //检查是否为空
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }else {
            return false;
        }
    }

    //在头部加入一个结点
    public void addFirstNode(T data){
        //把新加入的结点设置为第一结点
        Node<T> newNode = new Node<T>(data);
        newNode.next = first;
        first = newNode;
        size++;
    }

    //删除第一个结点，并返回该结点数据
    public T removeFirstNode()  {
        if (first == null){
            try {
                throw new Exception("链表为空！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        T temp = first.data;
        first = first.next;
        size--;
        return temp;
    }

    //将currentNode定位到index所指的结点
    private void locate(int index){
        if (index <0 && index >size){
            try {
            throw new IndexOutOfBoundsException("参数越界！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int i = 0;
        //遍历链表寻找索引index所指结点
        for(currentNode = first; currentNode.next != null && i < index; i++){
            currentNode = currentNode.next;
        }
    }

    //在链表尾部加入一个新的结点
    public void add(T data){
        if (isEmpty()){
            addFirstNode(data);
            return;
        }
        //把currentNode定位到最后一个结点
        locate(size-1);
        currentNode.next = new Node<T>(data);
        size++;
    }

    //从链表删除一个索引为index的结点,并将里面的数据返回
    public T remove(int index)  {
        if (isEmpty()){
            try {
                throw new Exception("链表为空！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //把currentNode定位到index的前一个结点
        locate(index-1);
        T temp = currentNode.next.data;
        currentNode.next = currentNode.next.next;
        size--;
        return temp;
    }

    //根据索引index从链表获取该结点的data
    public T get(int index)  {
        if (isEmpty()){
            try {
                throw new Exception("链表为空！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //把currentNode定位到index的前一个结点
        locate(index);
        return currentNode.data;
    }


    public static void main(String[] args){
        UnidirectionalLinkedList<Integer> list = new UnidirectionalLinkedList<Integer>();
        list.add(12);
        list.add(23);
        list.add(56);
        list.add(46);
        list.add(89);
        for (int i = 0; i < list.size;i++){
            try {
                System.out.print(list.get(i)+" ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("删除index为3的data："+list.remove(3));
        System.out.println("删除后：");
        for (int i = 0; i < list.size;i++){
            try {
                System.out.print(list.get(i)+" ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
