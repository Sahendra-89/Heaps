import java.util.*;
public class Heapsort {
    public static void heaify(int arr[], int i, int size){
        int left= 2*i+1;
        int right = 2*i+2;
        int maxIdx=i;
        if(left<size && arr[left]> arr[maxIdx]){
            maxIdx = left;
        }
        if(left<size && arr[right]>arr[maxIdx]){
            maxIdx = right;
        }
        if(maxIdx != i){
            //swap
            int temp = arr[i];
            arr[i] =arr[maxIdx];
            arr[maxIdx] = temp;
            heaify(arr,maxIdx,size);
        }
    }
    public static void heapSort(int arr[]){
        //step1 - bulid maxheap
         int n = arr.length;
         for(int i = n/2; i>=0; i--){
            heaify(arr,i,n);
         }
         //step2 - push largest elements 
         for( int i=n;i>0; i--){
            //swap largest - first with last
            int temp= arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heaify(arr, i,0);

         }

    }
    
    
    public static void main(String args[]){
        int arr[]= {1,2,4,5,3};
        heapSort(arr);
        //print 
        for( int i =0;i<arr.length; i++){
            System.out.println(arr[i]+ " ");
        }
        System.out.println();


    }
    
}
