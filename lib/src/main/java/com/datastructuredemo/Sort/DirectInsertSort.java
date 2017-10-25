package com.datastructuredemo.Sort;

import com.datastructuredemo.ArrayUtils;

/**
 * Created by yany on 2016/7/27.
 */
public class DirectInsertSort {
    public static <T extends Comparable<T>> void Version_1(T[] inputArray){
        T temp;
        int ValuateTimes = 0;

        ValuateTimes++;
        for (int i = 0; i < inputArray.length - 1; i++){
            ValuateTimes++;
            for (int j = i+1; j > 0; j--){
                //假设前面的是排好的，如果后面遇到一个比前面小的，就把它不断交换到合适的位置
                if (inputArray[j].compareTo(inputArray[j-1]) < 0){
                    temp = inputArray[j];
                    inputArray[j] = inputArray[j-1];
                    inputArray[j-1] = temp;
                    ValuateTimes += 3;
                }else {
                    break;      //因为前面的是都排好的，如果这一轮第一次不需要交换则后面都不需要
                }
            }
        }
        System.out.println("赋值次数："+ValuateTimes);

    }

    /*
     *因为Version_1每次比较发现插入值是小的之后都要交换，而交换之后不一定到达最后合适的位置，所以Version_2
     *出现了，它是通过如果比较后发现插入值比较小的话，就把当前值后移一位，比较完发现插入值最合适的位置再进行
     *交换的
     */

    public static <T extends Comparable<T>> void Version_2(T[] inputArray){
        T temp;
        int ValuateTimes = 0;       //计算赋值次数
        int i,j;

        ValuateTimes++;
        for (i = 0; i < inputArray.length - 1; i++){
            //把后一位当做插入值
            temp = inputArray[i+1];
            ValuateTimes++;
            //假设前面的是排好的，如果后面遇到一个比前面数组里数据小的,前面的数据后移一位
            ValuateTimes++;
            for (j = i+1; j > 0 && inputArray[j-1].compareTo(temp) > 0; j--){
                inputArray[j] = inputArray[j-1];
                ValuateTimes++;
            }
            //退出循环后进行赋值，把插入值插入到该插入的地方
            inputArray[j] = temp;
            ValuateTimes++;

        }
        System.out.println("赋值次数："+ValuateTimes);

    }

    public static void main(String[] args){
        Integer[] integers1 = {34,22,2,48,27};
        Integer[] integers2 = {34,22,2,48,27};

        System.out.print("Version1直接插入排序前：");
        ArrayUtils.printArray(integers1);
        Version_1(integers1);
        System.out.print("Version1直接插入排序后：");
        ArrayUtils.printArray(integers1);

        System.out.println("------------------------");

        System.out.print("Version2直接插入排序前：");
        ArrayUtils.printArray(integers2);
        Version_2(integers2);
        System.out.print("Version2直接插入排序后：");
        ArrayUtils.printArray(integers2);
    }
}
