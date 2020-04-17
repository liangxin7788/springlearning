package spring.demo.arithmetic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Package: spring.demo.arithmetic.sort
 * @ClassName: Bubble
 * @Description: java类作用描述
 * @Author: liangxin
 * @CreateDate: 2019/10/31 14:19
 * @UpdateDate: 2019/10/31 14:19
 */
public class Bubble {

    public static void main(String[] args) {
        int[] arr = {-2, 3, 9, 7, -1};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubble(int[] arr){
        boolean flag = false; // 默认没有数据位置交换过
        for(int i = 0; i < arr.length - 1; i++){
            int temp;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (!flag) {
                return;
            }else {
                flag = false;
            }
            System.out.println("第 " + (i +1 ) +" 次循环得到：" + Arrays.toString(arr));
        }
    }

}
