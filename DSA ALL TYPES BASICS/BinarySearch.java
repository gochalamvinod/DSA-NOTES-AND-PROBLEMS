class BinarySearch {

    public static int value(int[] arr, int i, int j, int target) {

        // Base case: target not found
        if (i > j) {
            return -1;
        }

        int mid = (i + j) / 2;

        // Target found
        if (arr[mid] == target) {
            return mid;
        }

        // Search right half
        else if (arr[mid] < target) {
            return value(arr, mid + 1, j, target);
        }

        // Search left half
        else {
            return value(arr, i, mid - 1, target);
        }
    }

    public static void main(String args[]) {

        int[] array = new int[]{
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 100, 200
        };

        System.out.print(value(array, 0, array.length - 1, 6));
    }
}
