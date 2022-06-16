import java.util.Arrays;
import java.util.PriorityQueue;

public class MinHeap {
    private int[] arr;
    private final PriorityQueue<Long> priorityQueue = new PriorityQueue<>(10);

    public MinHeap(int k) {
        this.arr = new int[k];
        Arrays.fill(this.arr, 0);
    }

    public MinHeap(int[] arr) {
        this.arr = arr;
        for (int i=arr.length/2-1; i>=0; i--) {
            adjust(i, arr.length);
        }
    }

    public void addNumber(int number) {
        if (number > this.arr[0]) {
            this.arr[0] = number;
            this.adjust(0, arr.length);
        }
    }

    private void adjust(int i, int length) {
        int temp = arr[i];
        for (int p=2*i+1; p<length; p=p*2+1) {
            if (p+1<length && arr[p+1] < arr[p]) {
                p++;
            }
            if (arr[p] < temp) {
                arr[i] = arr[p];
                i = p;
            } else break;
        }
        arr[i] = temp;
    }

    public String toString() {
        return Arrays.toString(this.arr);
    }

    public static void main(String[] args) {
        // 最大的k个
        MinHeap heap = new MinHeap(10);
        for (int i = 0; i < 100; i++) {
            heap.addNumber((int)(Math.random()*1000));
            System.out.println(heap.toString());
        }

    }
}
