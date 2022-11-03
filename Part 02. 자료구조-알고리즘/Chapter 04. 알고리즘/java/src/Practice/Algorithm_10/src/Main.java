package Practice.Algorithm_10.src;

public class Main {

    public static int getMax(int[] arr, int left, int right) {
        int m = (left + right) / 2;
        if (left == right) {
            return arr[left];
        }

        left = getMax(arr, left, m);
        right = getMax(arr, m + 1, right);

        return (left > right) ? left : right;
    }


    public static void main(String[] args) {
        int arr[] = {6, 2, 9, 8, 1, 4, 17, 5};
        System.out.println(getMax(arr, 0, arr.length - 1));
    }
}
