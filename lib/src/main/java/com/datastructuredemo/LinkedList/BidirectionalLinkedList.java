package com.datastructuredemo.LinkedList;

/**
 * 双向循环链表
 */
public class BidirectionalLinkedList<T> {
    //节点结构
    private class Node<T>{
        private T data;
        private Node<T> next,previous;;
        public Node(T data){
            this.data = data;
        }
        public Node(T data,Node<T> previous,Node<T> next){
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        public String toString(){
            return data.toString();
        }
    }

    private Node<T> head,currentNode;
    private int size;

    public BidirectionalLinkedList(){
        size = 0;
        head = new Node<T>(null,null,null);
        head.previous = head;
        head.next = head;
    }

    //检测是否为空
    public boolean isEmpty(){
        return (head.next == head);
    }

    //获取链表长度
    public int getSize() {
        return size;
    }

    //将currentNode定位到index所指的结点
    private void located(int index){
        if (index >= 0 && index < size) {
            currentNode = head;
            if (index <= size / 2) {
                for (int i = 0; i <= index; i++){
                    currentNode = currentNode.next;
                }
            }else {
                for (int i = size; i > index; i-- ){
                    currentNode = currentNode.previous;
                }
            }
        }else {
            throw new IndexOutOfBoundsException();
        }
    }

    //在尾部添加结点
    public void add(T data){
        Node<T> newNode = new Node<T>(data,head.previous,head);
        head.previous.next = newNode;
        head.previous = newNode;
        size++;
    }

    //在指定index插入结点
    public void add(T data,int index){
        //定位到要插入的结点前一个结点
        located(index - 1);
        Node<T> newNode = new Node<T>(data,currentNode,currentNode.next);
        currentNode.next.previous = newNode;
        currentNode.next = newNode;
        size++;
    }

    //在指定index删除结点,并返回改结点data
    public T remove(int index){
        located(index);
        currentNode.previous.next = currentNode.next;
        currentNode.next.previous = currentNode.previous;
        currentNode.previous = null;
        currentNode.next = null;
        size--;
        return currentNode.data;
    }

    //清空链表
    public void clear(){
        if (!isEmpty()) {
            head.next = head;
            head.previous = head;
            size = 0;
        }
    }

    //用于输出内容
    public String toString(){
        if (isEmpty()){
            try {
                throw new Exception("链表为空");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        StringBuffer sb = new StringBuffer();
        currentNode = head;
        for (int i = 0; i < size; i++){
            currentNode = currentNode.next;
            sb.append(currentNode.toString());
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BidirectionalLinkedList<Integer> list = new BidirectionalLinkedList<>();
        System.out.println("list是否空："+list.isEmpty());
        System.out.println("链表长度："+list.getSize());
        list.add(12);
        list.add(23);
        list.add(56);
        list.add(46);
        list.add(89);
        System.out.println(list.toString());
        System.out.println("链表长度："+list.getSize());
        System.out.println("list是否空："+list.isEmpty());
        System.out.println("删除index为3的data："+list.remove(3));
        System.out.println("删除后："+list.toString());
        list.clear();
        System.out.println("清空后："+list.toString());
    }
}
