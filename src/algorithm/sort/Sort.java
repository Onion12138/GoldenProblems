package algorithm.sort;

import java.util.Random;

/**
 * @author onion
 * @date 2020/4/30 -1:49 下午
 */
public class Sort {
    private void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j > 0 && arr[j-1] > temp ; j--)
                arr[j] = arr[j-1];
            arr[j] = temp;
        }
    }
    public void insertSort2(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
                swap(arr, arr[j], arr[j-1]);
            }
        }
    }
    public void mergeSort(int[] arr) {
        temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1);
    }
    private void mergeSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int mid = (l + r) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        if (arr[mid] > arr[mid + 1])
            merge(arr, l, mid, r);
    }
    public void mergeSortBU(int[] arr) {
        for (int size = 1; size <= arr.length; size++) {
            for (int i = 0; i + size < arr.length; i += size) {
                merge(arr,i,i+size-1,Math.min(arr.length-1,i+size+size-1));
            }
        }
    }
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }
    public void quickSortThreeWay(int[] arr, int l, int r) {
        if (l >= r)
            return;
        Random random = new Random();
        swap(arr,l,random.nextInt(r-l)+l);
        int guard = arr[l];
        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        while (i < gt) {
            if (arr[i] < guard) {
                swap(arr,++lt, i);
            }else if (arr[i] > guard) {
                swap(arr,i,--gt);
            }else {
                i++;
            }
        }
        swap(arr,l,lt);

    }
    private void quickSort(int[] arr, int l, int r) {
        if (l >= r)
            return;
        int p = partition(arr, l, r);
        quickSort(arr,l,p-1);
        quickSort(arr,p+1,r);
    }

    private int partition(int[] arr, int l, int r) {
        Random random = new Random();
        swap(arr,l,random.nextInt(r-l)+l);
        int guard = arr[l];
        int pos = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < guard){
                swap(arr, ++pos,i);
            }
        }
        swap(arr,pos,l);
        return pos;
    }

    private int[] temp;
    private void merge(int[] arr, int l, int mid, int r) {
        if (r + 1 - l >= 0)
            System.arraycopy(arr, l, temp, l, r + 1 - l);
        int i = l;
        int j = mid+1;
        for (int k = l; k <= r; k++) {
            if (i > mid){
                arr[k] = temp[j];
                j++;
            }else if(j > r){
                arr[k] = temp[i];
                i++;
            }else if(temp[i] < temp[j]){
                arr[k] = temp[i];
                i++;
            }else{
                arr[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,6,0,7,5,3,2,4,4};
        Sort sort = new Sort();
        sort.quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
