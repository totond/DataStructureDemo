package com.datastructuredemo.Sort;

import com.datastructuredemo.ArrayUtils;

/**
 * Created by yany on 2016/7/29.
 */
public class ShellSort {

    public static <T extends Comparable<T>> void Version_1(T[] inputArray) {
        int i,j,k,increment;
        T temp;

        for (increment = inputArray.length ; increment > 0; increment = increment / 2 ) {
            //这里进行增量的减少，直到最后减少到1
            for (i = 0; i < increment; i++) {
                //这里根据分量把输入的数组分成几个小的数组
                for (j = i; j < inputArray.length - increment; j += increment){
                    //这里进行该分组的直接插入排序
                    temp = inputArray[j+increment];
                    for (k = j + increment;  k>= increment && inputArray[k-increment].compareTo(temp) > 0; k-= increment){
                        inputArray[k] = inputArray[k-increment];
                    }
                    inputArray[k] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        Integer[] integers1 = {47, 16, 33, 22, 55, 37, 1, 96, 27, 56};
//        Integer[] integers1 = {47,22,33,16};


        ArrayUtils.printArray(integers1);
        Version_1(integers1);
        ArrayUtils.printArray(integers1);

    }
}
