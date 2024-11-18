import java.util.Arrays;

public class HeapSort {

    public static void heapSort(Integer[] values) {
        // Intentionally not implemented -- see homework assignment
        heapify(values); //O(n)
        Integer dummyVal;
        for (int i = values.length - 1; i > 0; i--) { //n*O(lgn) -> O(nlgn)
            dummyVal = values[i];
            values[i] = values[0];
            values[0] = dummyVal;
            trickleDown(values,0,i-1);
        }
    }

    //O(n)
    private static void heapify(Integer[] values){
        for (int i = values.length/2 - 1; i >= 0; i--){
           trickleDown(values,i,values.length);
        }
    }

    //O(lgn)
    private static void trickleDown(Integer[] values, int index, int heapSize){
        int leftChildIndex = index*2+1;
        int rightChildIndex = index*2+2;
        int smallerChildIndex;
        if(leftChildIndex < heapSize && rightChildIndex < heapSize){
            smallerChildIndex = values[leftChildIndex]<values[rightChildIndex] ? leftChildIndex : rightChildIndex;
        }
        else if(leftChildIndex < heapSize){
            smallerChildIndex = leftChildIndex;
        }
        else if(rightChildIndex < heapSize){
            smallerChildIndex = rightChildIndex;
        }
        else{
            return;
        }
        if(values[index] > values[smallerChildIndex]){
            Integer dummyVal = values[index];
            values[index] = values[smallerChildIndex];
            values[smallerChildIndex] = dummyVal;
            trickleDown(values, smallerChildIndex, heapSize);
        }
    }

    public static void main(String[] args) {
        int size = 20;
        Integer[] list = new Integer[size];

        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }

        System.out.println("Unsorted List: " + Arrays.toString(list));
        heapSort(list);
        System.out.println("  Sorted List:" + Arrays.toString(list));
    }
}
