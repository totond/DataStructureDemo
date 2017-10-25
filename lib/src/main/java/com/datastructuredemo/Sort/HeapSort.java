package com.datastructuredemo.Sort;

import com.datastructuredemo.ArrayUtils;

/**
 * Created by yany on 2016/7/30.
 */
public class HeapSort {

    public static <T extends Comparable<T>> void Version_1(T[] inputArray){
        int i;
        T temp;
        //构建大顶堆
        for (i = inputArray.length / 2 - 1; i >= 0; i--){
            BuildMaxHeap(inputArray,i,inputArray.length - 1);
        }
        //不断地从堆顶取出最大的节点值，把最后的节点值放上堆顶，重新进行构建大顶堆
        for (i = inputArray.length - 1; i > 0; i--){
            temp = inputArray[0];
            inputArray[0] = inputArray[i];
            inputArray[i] = temp;

            BuildMaxHeap(inputArray,0,i-1);
        }

    }

    protected static <T extends Comparable<T>> void BuildMaxHeap(T[] inputArrary, int start, int end){
        int father = start;
        T temp = inputArrary[father];
        //从当前父节点的左子节点（start*2 + 1）开始比较，选出最大的节点
        for (int index = father * 2 + 1; index <= end; index = index * 2 + 1){
            if (index + 1 <= end && inputArrary[index].compareTo(inputArrary[index + 1]) < 0){
                //如果有右子节点而且左子节点比右子节点小，则把索引指向右子节点
                index++;
            }
            if (inputArrary[index].compareTo(temp) < 0){
                //如果子节点的最大者都比父节点小，则代表已经选出最大节点，跳出循环
                break;
            }else {
                //否则把最大子节点和父节点的值交换
                inputArrary[father] = inputArrary[index];
                inputArrary[index] = temp;
                //最后如果发生交换的话就把交换后的节点当作父节点继续循环，构建大顶堆
                father = index;
            }
        }
    }

    public static void main(String[] args){
        Integer[] integers1 = {16,22,33,55,37,1,96,47,27,56};

        System.out.println("堆排序前");
        ArrayUtils.printArray(integers1);
        Version_1(integers1);
        System.out.println("堆排序后");
        ArrayUtils.printArray(integers1);
    }
}
