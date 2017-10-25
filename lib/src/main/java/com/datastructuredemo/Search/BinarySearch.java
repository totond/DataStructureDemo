package com.datastructuredemo.Search;

/**
 * 二分查找，需要输入一个有序的数组和关键字key，如果查找成功则返回索引，失败则返回-1
 */
public class BinarySearch {
    //二分查找的非递归实现,这里假设输入的数组是从小到大
    public static <T extends Comparable<T>> int Version_1(T[] inputArray, T key){
        int high = inputArray.length - 1;
        int low = 0;
        int middle;

        while (low <= high){
            //构建中值
            middle = (low + high) / 2;
            //中值和关键字作比较，如果相等则说明查找成功返回middle，如果不相等则重新循环构建中值
            if (inputArray[middle].compareTo(key) == 0){
                return middle;
            }else if (inputArray[middle].compareTo(key) > 0){
                high = middle - 1;
            }else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /*
     *Version1是非递归实现，下面是递归实现Version2
     */

    //递归实现，这里也是假设输入的数组是从小到大,其实就是把Version1的循环用递归实现
    public static <T extends Comparable<T>> int Version_2(T[] inputArray, T key){
        return RecursiveBinarySearch(inputArray,key,0,inputArray.length-1);
    }

    public static <T extends Comparable<T>> int RecursiveBinarySearch(T[] inputArray, T key, int low, int high){
        //如果low大于high，说明已经遍历完数组都找不到key，返回-1
        if (low > high){
            return -1;
        }
        //这里就是实现上面Version1循环的递归
        int middle = (low + high) / 2;
        if (inputArray[middle].compareTo(key) == 0){
            return middle;
        }else if (inputArray[middle].compareTo(key) > 0){
            return RecursiveBinarySearch(inputArray,key,low,middle-1);
        }else {
            return RecursiveBinarySearch(inputArray,key,middle+1,high);
        }

    }
    public static void main(String[] args) {
        Integer[] integers = {1, 4, 8, 11, 13, 15, 16, 18, 22, 29};
        Integer intKey = 12;
        System.out.println("Version1查找 "+ intKey);
        System.out.println("Version1返回 "+BinarySearch.Version_1(integers, intKey));

        System.out.println("Version2查找 "+ intKey);
        System.out.println("Version2返回 "+BinarySearch.Version_2(integers, intKey));

    }
}
