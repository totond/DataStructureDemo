package com.datastructuredemo.Sort;

import java.lang.reflect.Array;

import com.datastructuredemo.ArrayUtils;

/**
 * Created by yany on 2016/7/30.
 */
public class MergeSort {

    public static <T extends Comparable<T>> void Version_1(T[] inputArray){
        //开始执行递归
        Sort(inputArray,0,inputArray.length-1);
    }

    protected static  <T extends Comparable<T>> void Sort(T[] inputArray, int start, int end){
        //如果递归到单个值作为一个分组，则返回
        if (start >= end){
            return;
        }
        int mid = (start + end) / 2;
        Sort(inputArray,start,mid);
        Sort(inputArray,mid+1,end);
        Merge(inputArray,start,mid,end);

    }

    protected static  <T extends Comparable<T>> void Merge(T[] inputArray, int start, int mid, int end){
        //在Java里面因为类型安全的问题，泛型数组是不能初始化的，可以通过这种方法勉强解决，在这里编译器会提示让你自己负责类型安全检查
        T[] temp = inputArray.clone();
        int i,j;
        int k = start;
        //把输入数组分成两组，用左边数组最小的值和右边数组最小的值比较，小的就放进新的临时数组，然后下标加一
        for (i = start, j = mid + 1; i <= mid && j <= end; k++){
            if (inputArray[i].compareTo(inputArray[j]) <= 0){
                temp[k] = inputArray[i];
                i++;
            }else {
                temp[k] = inputArray[j];
                j++;
            }
        //这样一定会有一个分组的数据全放进temp才会结束循环
        }
        //如果左边数据还没全放进去temp，则说明后面的都是比较大的值，在后面加入补全
        while (i <= mid){
            temp[k++] = inputArray[i++];
        }
        //如果左边数据还没全放进去temp，则说明后面的都是比较大的值，在后面加入补全
        while (j <= end){
            temp[k++] = inputArray[j++];
        }
        //将排序处理好的临时数组temp返回给原输入数组
        for (int s = start; s <= end; s++){
            inputArray[s] = temp[s];
        }
    }

    public static void main(String[] args){
        Integer[] integers1 = {16,22,33,55,37,1,96,47,27,56};

        System.out.println("归并排序前");
        ArrayUtils.printArray(integers1);
        Version_1(integers1);
        System.out.println("归并排序后");
        ArrayUtils.printArray(integers1);
    }
}
