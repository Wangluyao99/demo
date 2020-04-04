package com.test.java;

public class BinarySearch {
    public static void main(String args){
        int[] arr=new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(arr,7));
    }
    /*
     参数：
     arr 有序数组
     data 查找的数据
     index 下标，未找到时返回-1
    */
    public static int binarySearch(int[] arr,int data){
        int low=0;
        int height=arr.length-1;

        while(low <= height){
            int mid=low+(height-low)/2;

            if (data>arr[mid]){
                low=mid+1;
            }else if (arr[mid]==data){
                return mid;
            }else{
                height=mid-1;
            }
        }
        return -1;
    }
}
