package org.ds.leetcode;

import java.util.Arrays;

public class NextPermutation {
    public static int [] getNextPermuation(int [] arr){

        int n = arr.length;
        int i = arr.length-1;

//        1 2 3 5 4

        while(i-1 >=0 && arr[i]<=arr[i-1]){
            i--;
        }

        if(i-1<0) {
            Arrays.sort(arr); //no next permutation
            return arr;
        }



        int minSoFar = arr[i];

        int index=i;

        for(int j=i;j<n;j++){
            if(arr[j]>arr[i-1] && arr[j]<minSoFar){
                index = j;
                minSoFar = arr[j];
            }
        }

//        make a swap

        int swap = arr[i-1];
        arr[i-1] = arr[index];
        arr[index] = swap;

        //sort array
        Arrays.sort(arr,i,n);


        return arr;
    }


    public static void main(String[] args) {
        int [] arr = {5,1,1};
        System.out.println(Arrays.toString(getNextPermuation(arr)));
    }
}
