package Practice.Algorithm_04.src;// 자바 기본 binarySearch

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};

        System.out.println("== 데이터가 있는 경우 ==");
        System.out.println(Arrays.binarySearch(arr, 1));
        System.out.println(Arrays.binarySearch(arr, 10));
        System.out.println(Arrays.binarySearch(arr, 30));

        System.out.println("== 데이터가 없는 경우 ==");
        //        (있어야 할 자리 * -1) -1
        System.out.println(Arrays.binarySearch(arr, 3));   // 2번에 있었어야함 -> (2 * -1) - 1
        System.out.println(Arrays.binarySearch(arr, 11));   // (4 * -1) - 1
        System.out.println(Arrays.binarySearch(arr, 35));   // (6 * -1) - 1

//        따라서 삽입해야할 위치를 알 수 있음 -> (음수를 양수로 바꾸고) -1


    }
}
