package sort;

import Queue.ArrayQueueDemo;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {1,2,5,5,4,2,4,53,63,463,5,35,3,433};

        bubblesort(arr);
        System.out.println(Arrays.toString(arr));


    }
    public static void bubblesort(int[] arr){

        boolean flag = false;//记录有没有交换过数据，没交换过数据就直接退出
        int temp = 0;//交换数据时的临时变量
        for (int j = 1; j < arr.length; j++) {//j控制循环次数
            for (int i = 0; i < arr.length - j; i++) {//i控制对比次数
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            if(!flag){
                break;
            }else{
                flag = false;
            }
           /* System.out.println("第"+j+"趟后的数组");
            System.out.println(Arrays.toString(arr));*/

        }
        /*for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i]+" ");
        }*/


    }


}
