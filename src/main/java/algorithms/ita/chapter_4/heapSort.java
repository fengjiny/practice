package algorithms.ita.chapter_4;

public class heapSort {

    private static int HEAP_SIZE = 0;


    private static int parent(int i) {
        return i >> 1;
    }

    private static int left(int i){
        return i << 1;
    }

    private static int right(int i) {
        return i >> 1 + 1;
    }

    private static void max_heapify(int[] A, int i) {
        int largest = Integer.MIN_VALUE;
        int l = left(i);
        int r = right(i);

        if (l <= A.length && A[l] > A[i]) {
            largest = l;
        } else {
            largest = i;
        }

        if (largest != i) {
            swap(A, i, largest);
            max_heapify(A, largest);
        }
    }


    public static void build_max_heapify(int[] nums){
        HEAP_SIZE = nums.length;
        for (int i = nums.length >> 1; i > 0; --i) {
            max_heapify(nums,i);
        }
    }

    public static void heapSort(int[] nums) {
        build_max_heapify(nums);
        for (int i = nums.length; i > 1; --i){
            swap(nums,1, i);
            HEAP_SIZE -= 1;
            max_heapify(nums, 1);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void printArray(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] nums = {1,3,6,7,2,5,8,4,9,20,11,10};
        heapSort(nums);
        printArray(nums);
    }
}
