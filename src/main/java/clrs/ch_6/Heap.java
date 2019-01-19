package clrs.ch_6;

public class Heap {

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
        if (l <= A.length && A[l] > A[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r <= A.length && A[r] > A[i]) {
            largest = r;
        }
        if (largest != i) {
            swap(A, i, largest);
            max_heapify(A, largest);
        }
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
