// Реализовать алгоритм пирамидальной сортировки (HeapSort).
public class ex3dz
{
    public static void main(String args[])
    {
        int arr[] = {10,5,4,3,2,1,2,2,3,7};
        int n = arr.length;
        ex3dz ob = new ex3dz();
        ob.sort(arr);
        printArray(arr);
    }
    public void sort(int arr[]){
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i=n-1; i>=0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp; 
            heapify(arr, i, 0);
        }
    }
    public static void heapify(int arr[], int n, int i){
        int max = i; 
        int l = 2*i + 1; 
        int r = 2*i + 2;   
        if (l < n && arr[l] > arr[max])
            max = l; 
        if (r < n && arr[r] > arr[max])
            max = r;
        if (max != i){
            int swap = arr[i];
            arr[i] = arr[max];
            arr[max] = swap;
            heapify(arr, n, max);
        }
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}