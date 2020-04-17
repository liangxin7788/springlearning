package spring.demo.arithmetic.sort;

import java.util.Arrays;

/**
 * @Package: spring.demo.arithmetic.sort
 * @ClassName: Insert
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/11/5 8:56
 * @UpdateDate: 2019/11/5 8:56
 */
public class Insert {
    public static void main(String[] args) {
        int arr[] = {6,9,2,3,1,-5,-4};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * (从小到大排序)
     *
     * 1、取第一个元素，自己作为一个有序数组，后边剩下的是无序数组
     * 2、按顺序取无序数组，在有序数组这边比较大小，后插入到有序数组合适的位置
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++){
            int temp = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("第一次排序得到：" + Arrays.toString(arr));
    }
}
