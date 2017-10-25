package com.datastructuredemo.Sort;


import com.datastructuredemo.ArrayUtils;

/**
 * Created by yany on 2016/7/26.
 */
public class BubbleSort  {

    public static <T extends Comparable<T>> void Version_1(T[] inputArray){
        T temp;     //用于交换的临时变量
        int ChangeTimes = 0;      //用于计算交换次数的变量
        int LoopTimes = 0;        //用于计算循环次数的变量

        for (int i = 0; i < inputArray.length - 1; i++){
            LoopTimes++;
            for (int j = inputArray.length - 1; j > 0; j--){
                LoopTimes++;
                if (inputArray[j].compareTo(inputArray[j-1]) < 0){
                    temp = inputArray[j];
                    inputArray[j] = inputArray[j-1];
                    inputArray[j-1] = temp;
                    ChangeTimes++;
                }
            }
        }
        System.out.println("循环次数："+LoopTimes);
        System.out.println("交换次数："+ChangeTimes);

    }

    /*
     *Version_1存在问题：
     *数据的顺序排好之后，冒泡算法仍然会继续进行下一轮的比较，直到arr.length-1次，后面的比较没有意义
     */

    /*
     *Version_2改进：
     *设置标志位Changed，如果一轮发生了交换Changed设置为true；如果一轮没有交换就设置为false，检测到false就跳出循环。
     */

    public static <T extends Comparable<T>> void Version_2(T[] inputArray){
        T temp;     //用于交换的临时变量
        int ChangeTimes = 0;      //用于计算交换次数的变量
        int LoopTimes = 0;        //用于计算循环次数的变量
        boolean Changed;

        for (int i = 0; i < inputArray.length - 1; i++){
            Changed = false;
            LoopTimes++;
            for (int j = inputArray.length - 1; j > 0; j--){
                LoopTimes++;
                if (inputArray[j].compareTo(inputArray[j-1]) < 0){
                    temp = inputArray[j];
                    inputArray[j] = inputArray[j-1];
                    inputArray[j-1] = temp;
                    ChangeTimes++;
                    Changed = true;
                }
            }if (!Changed){
                System.out.println("循环次数："+LoopTimes);
                System.out.println("交换次数："+ChangeTimes);
                return;
            }
        }
        System.out.println("循环次数："+LoopTimes);
        System.out.println("交换次数："+ChangeTimes);


    }

    public static void main(String[] args){
        Integer[] integers1 = {33,16,22,55,37,1,96,47,27,56};
        Integer[] integers2 = {33,16,22,55,37,1,96,47,27,56};

        System.out.println("Version1排序后:");
        Version_1(integers1);
        ArrayUtils.printArray(integers1);

        System.out.println("Version2排序后:");
        Version_2(integers2);
        ArrayUtils.printArray(integers2);
    }
}
