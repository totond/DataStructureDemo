package com.datastructuredemo;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by yany on 2016/7/27.
 */
public class ArrayUtils {
    //泛型方法前面要有一个尖括号部分声明泛型
    public static < T > void printArray( T[] inputArray ) {
        // 输出数组元素
        for ( T element : inputArray ){
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }

    public static < T > void printList(List<T> inputList) {
        // 输出数组元素
        for ( T element : inputList ){
            System.out.printf( "%s ", element );
        }
        System.out.println();

    }

    public static void main( String args[] ){
        //创建不同类型数组
        Character[] chars = { 'G', 'O', 'O', 'D' };
        Integer[] ints = { 13, 52, 35, 78, 96 };
        Double[] doubles = { 1.13, 4.2, 2.33, 7.42 };

        //输出各类型的数组
        printArray(chars);
        printArray(ints);
        printArray(doubles);

    }

}
