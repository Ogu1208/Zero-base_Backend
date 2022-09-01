package Practice.Java_17.src;// Java 프로그래밍 - 스트림

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

//      1. 스트림 생성

//      1-1. 배열 스트림
        System.out.println("== 배열 스트림 == ");
        String[] arr = new String[]{"a", "b", "c"};

        System.out.println("== fori ==");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("== forEach ==");
        for (String item: arr) {
            System.out.println(item);
        }

        System.out.println("== to Stream ==");


//      1-2. 컬렉션 스트림
        System.out.println("== 컬렉션 스트림 ==");
        ArrayList list1 = new ArrayList(Arrays.asList(1, 2, 3));
        System.out.println("list1 = " + list1);

        System.out.println("== to Stream ==");


//      1-3. 스트림 builder
        System.out.println("== 스트림 builder ==");



//      1-4. 스트림 generate
        System.out.println("== 스트림 generate ==");



//      1-5. 스트림 iterate
        System.out.println("== 스트림 iterate ==");



//      1-6. 기본 타입 스트림
        System.out.println("== 기본타입 스트림 ==");



//      2. 스트림 중개 연산

//      2-1. Filtering
        System.out.println("== Filtering ==");



//      2-2. Mapping
        System.out.println("== Mapping ==");



//      2-3. Sorting
        System.out.println("== Sorting ==");



//      3. 최종 연산

//      3-1. Sum, Average
        System.out.println("== sum, average ==");



//      3-2. Min, Max
        System.out.println("== min, max ==");



//      3-3. reduce
        System.out.println("== reduce ==");



//      3-4. forEach
        System.out.println("== forEach == ");


    }
}


