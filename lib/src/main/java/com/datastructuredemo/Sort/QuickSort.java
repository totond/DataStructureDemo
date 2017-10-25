package com.datastructuredemo.Sort;

import com.datastructuredemo.ArrayUtils;

/**
 * 通过把要排序的数据分割成独立的两部分，
 * 其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，递归进行最后分出顺序
 */
public class QuickSort {
    public static <T extends Comparable<T>> void Version_1(T[] inputArray){
        QSort(inputArray,0,inputArray.length-1);

    }

    public static <T extends Comparable<T>> void QSort(T[] inputArray, int start, int end){
        int pivot;
        if (start < end){
            pivot = Partition(inputArray, start,end);
            QSort(inputArray,start,pivot-1);
            QSort(inputArray,pivot+1,end);
        }
    }

    public static <T extends Comparable<T>> int Partition(T[] inputArray, int start, int end){
        T pivotkey = inputArray[start];
        while (start < end){

            //跳过比pivotkey大的，把比pivotkey小的值放到左边
            while (start < end && pivotkey.compareTo(inputArray[end]) <= 0){
                end--;
            }if (start < end) {//如果左边的所有都比pivotkey小，就不用交换了
                inputArray[start++] = inputArray[end];
            }

            //跳过比pivotkey小的，把比pivotkey大的值放到右边
            while (start < end && pivotkey.compareTo(inputArray[start]) >= 0){
                start++;
            }if (start < end){
                inputArray[end--] = inputArray[start];
            }

        }
        //把pivotkey放回数组中部
        inputArray[start] = pivotkey;
        //返回pivotkey的索引
        return start;
    }

    public static void main(String[] args){
        Integer[] integers1 = {16,22,33,55,37,1,96,47,27,56};

        System.out.println("快速排序前");
        ArrayUtils.printArray(integers1);
        Version_1(integers1);
        System.out.println("快速排序后");
        ArrayUtils.printArray(integers1);
    }
}
