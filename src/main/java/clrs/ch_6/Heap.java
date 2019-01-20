package clrs.ch_6;

public class Heap {

    private int heapSize;

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return i * 2;
    }

    private int right(int i) {
        return i * 2 + 1;
    }


    public void max_heapify(int[] A, int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        if (l < heapSize && A[l] > A[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < heapSize && A[r] > A[i]) {
            largest = r;
        }
        if (largest != i) {
            swap(A, i, largest);
            max_heapify(A, largest);
        }
    }

    public void build_max_heap(int[] A) {
        heapSize = A.length;
        for (int i = A.length / 2; i > 0; --i) {
            max_heapify(A, i);
        }
    }

    public void heapSort(int[] A) {
        build_max_heap(A);
        for (int i = A.length / 2; i > 1; --i) {
            swap(A, i, 1);
            max_heapify(A, 1);
        }
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {-1,1,3,4,9,8,7,5,11,42,57,111,23,44,557,457};
        Heap heap = new Heap();
        heap.build_max_heap(a);
        printArray(a);

        heap.heapSort(a);
        printArray(a);
    }

    public static void printArray(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
