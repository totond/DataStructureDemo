package com.datastructuredemo.Queue;

import java.util.ArrayList;

/**
 * Created by yany on 2016/9/11.
 */
public class ArrayCircularQueue<T> {
    private int num,maxSize = 0;
    private int rear,front = 0;
    private ArrayList<T> arrayQueue;

    public ArrayCircularQueue(int maxSize){
        this.maxSize = maxSize;
        arrayQueue = new ArrayList<T>(maxSize);
        for (int i = 0; i < maxSize; i++){
            arrayQueue.add(null);
        }
    }

    //从队尾加入元素，如果成功则返回true
    public boolean EnQueue(T element){
        if(num == maxSize){
            try {
                throw new Exception("此队列已满，不能执行入队操作,返回false");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        arrayQueue.set(rear++,element);
        if (rear == maxSize){
            rear = 0;
        }
        num++;
        return true;
    }

    //从队头取出元素
    public T DeQueue(){
        if (num == 0){
            try {
                throw new Exception("此队列为空队列，不能执行出队操作,返回null");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }else {
            T temp = arrayQueue.set(front++,null);
            if (front == maxSize){
                front = 0;
            }
            num--;
            return temp;
        }
    }

    public int getMaxSize(){
        return maxSize;
    }

    public boolean isEmpty(){
        return num == 0;
    }

    public int getNum(){
        return num;
    }


    public static void main(String[] args) {

        ArrayCircularQueue<Integer> queue = new ArrayCircularQueue<>(5);
        System.out.println("队列是否为空："+queue.isEmpty());

        //元素入队
        queue.EnQueue(232);
        queue.EnQueue(273);
        queue.EnQueue(13);
        System.out.println("队列元素个数："+ queue.getNum());
        System.out.println("元素出队："+queue.DeQueue());
        System.out.println("元素出队："+queue.DeQueue());

        queue.EnQueue(24);
        queue.EnQueue(85);
        queue.EnQueue(5);
        queue.EnQueue(5);
        queue.EnQueue(5);

        System.out.println("元素出队："+queue.DeQueue());
        System.out.println("元素出队："+queue.DeQueue());
        System.out.println("元素出队："+queue.DeQueue());
        System.out.println("元素出队："+queue.DeQueue());
        System.out.println("元素出队："+queue.DeQueue());

    }


}
