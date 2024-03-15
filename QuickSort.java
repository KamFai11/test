package sort;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {

        int arr[]={4,2,1,4,35,2,5,2,24,52,51,5,2,23};

        quicksort(arr,0,arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(" "+ arr[i] +" ");
        }


    }

    public static void quicksort(int[] arr,int s,int e){
        int start = s;
        int end = e;
        if(start >= end){//递归出口
            return;
        }
        int i = arr[start];//记录拿来对比的值
        while(start != end){
            while(true){
                if(start == end || arr[end] < i){//找比i小的数
                    break;
                }
                end--;
            }
            while(true){
                if(start == end || arr[start] > i) {//找比i大的数
                    break;
                }
                start++;
            }
            //一轮循环下来交换找到要交换的数
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        //交换对比值和start和end同指到的那个值
        int temp = arr[s];
        arr[s] = arr[start];
        arr[start] = temp;

        quicksort(arr,s,start-1);
        quicksort(arr,start + 1,e);

    }




}
