package Solution.Algorithm_02_2.src;// 퀵 정렬

import java.util.Arrays;

public class Main3 {

    public static void quickSort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        
        // 분할
        int pivot = partition(arr, left, right);
        
        // 기준값 중심으로 좌우 재귀 호출
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    public static int partition(int[] arr, int left, int right) {
        // 가장 좌측 값을 기준값으로 설정
        // 이외에 기준 값은 배열에서 중간에 있는 값을 고르거나, 임의의 수를 3개 선정 후 중앙 값을 고르는 등의 방법이 있음
        int pivot = arr[left];
        int i = left;
        int j = right;

        while(i < j) {
            while (arr[j] > pivot && i < j) {
                j--;
            }

            while(arr[i] <= pivot && i < j) {
                i++;
            }

            swap(arr, i, j);
        }
        swap(arr, left, i);

        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 9, 4, 5, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("퀵 정렬: " + Arrays.toString(arr));
    }
}
