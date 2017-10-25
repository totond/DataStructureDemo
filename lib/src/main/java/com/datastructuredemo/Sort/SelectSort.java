package com.datastructuredemo.Sort;

import com.datastructuredemo.ArrayUtils;

/**
 * Created by yany on 2016/7/27.
 */
public class SelectSort {

    public static <T extends Comparable<T>> void Version_1(T[] inputArray){
        T temp;         //用于交换
        int minIndex ;
        for (int i = 0; i < inputArray.length; i++){
            minIndex = i;   //当前遍历到的索引

            //通过比较，把后面的最小值的索引找出来
            for (int j = i+1; j < inputArray.length; j++){
                if (inputArray[minIndex].compareTo(inputArray[j]) > 0){
                    minIndex = j;
                }
            }
            //如果后面的元素都没有它更小的，则不用交换
            if (i != minIndex){
                temp = inputArray[i];
                inputArray[i] = inputArray[minIndex];
                inputArray[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args){
        Integer[] integers1 = {34,22,2,48,27,90,75,11,84,9};

        System.out.println("选择排序前：");
        ArrayUtils.printArray(integers1);
        Version_1(integers1);
        System.out.println("选择排序后：");
        ArrayUtils.printArray(integers1);
    }
}
