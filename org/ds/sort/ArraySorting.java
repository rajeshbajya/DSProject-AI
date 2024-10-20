package org.ds.sort;

import java.util.Arrays;

public class ArraySorting {



    //
    //after every interation, one element is put at right place, at end
    //
    public void bubbleSort(int [] arr, boolean reverse){
       int n = arr.length;

       for(int i=0;i<n;i++){
           for(int j=0;j<n-1-i;j++){
               if(reverse){
                   if(arr[j]<arr[j+1]){
                       swap(j,j+1,arr);
                   }
               }else{
                   if(arr[j] > arr[j+1]){
                       swap(j,j+1,arr);
                   }
               }

           }
       }
    }

    public void insertionSort(int [] arr, boolean reverse){
        int n = arr.length;

        for(int i=1;i<n;i++){
            int key = arr[i];
            int j=i-1;
            if(reverse){
                while(j>=0 && arr[j]<key){
                    arr[j+1]=arr[j];
                    j--;
                }
            }else{
                while(j>=0 && arr[j]>key){
                    arr[j+1]=arr[j];
                    j--;
                }
            }

            arr[j+1] = key;
        }
    }

    private void swap(int i, int j, int[] arr) {
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
    }

    public static void main(String[] args) {
        int [] arr = {4,7,1,66,43,5,78,56,-1,0};
        ArraySorting as = new ArraySorting();
        as.insertionSort(arr,true);
        System.out.println(Arrays.toString(arr));

    }
}
