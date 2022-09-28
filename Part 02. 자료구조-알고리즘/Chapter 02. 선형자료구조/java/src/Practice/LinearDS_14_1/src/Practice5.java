package Practice.LinearDS_14_1.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Practice5 {
    public static Integer solution(int n, int k, int l, ArrayList<ArrayList> apples, Queue<ArrayList> moves) {
        return null;
    }

    public static void main(String[] args) {
        // Test code
        int n = 6;
        int k = 3;
        int l = 3;
        ArrayList<ArrayList> apples = new ArrayList();
        apples.add(new ArrayList<>(Arrays.asList(3, 4)));
        apples.add(new ArrayList<>(Arrays.asList(2, 5)));
        apples.add(new ArrayList<>(Arrays.asList(5, 3)));

        Queue<ArrayList> moves = new LinkedList();
        moves.add(new ArrayList(Arrays.asList(3, 'D')));
        moves.add(new ArrayList(Arrays.asList(15, 'L')));
        moves.add(new ArrayList(Arrays.asList(7, 'D')));
        System.out.println((solution(n, k, l, apples, moves)));

        n = 10;
        k = 4;
        l = 4;
        apples.clear();
        apples.add(new ArrayList<>(Arrays.asList(1, 2)));
        apples.add(new ArrayList<>(Arrays.asList(1, 3)));
        apples.add(new ArrayList<>(Arrays.asList(1, 4)));
        apples.add(new ArrayList<>(Arrays.asList(1, 5)));

        moves.clear();
        moves.add(new ArrayList(Arrays.asList(8, 'D')));
        moves.add(new ArrayList(Arrays.asList(10, 'D')));
        moves.add(new ArrayList(Arrays.asList(11, 'D')));
        moves.add(new ArrayList(Arrays.asList(13, 'L')));
        System.out.println((solution(n, k, l, apples, moves)));

        n = 10;
        k = 5;
        l = 4;
        apples.clear();
        apples.add(new ArrayList<>(Arrays.asList(1, 5)));
        apples.add(new ArrayList<>(Arrays.asList(1, 3)));
        apples.add(new ArrayList<>(Arrays.asList(1, 2)));
        apples.add(new ArrayList<>(Arrays.asList(1, 6)));
        apples.add(new ArrayList<>(Arrays.asList(1, 7)));

        moves.clear();
        moves.add(new ArrayList(Arrays.asList(8, 'D')));
        moves.add(new ArrayList(Arrays.asList(10, 'D')));
        moves.add(new ArrayList(Arrays.asList(11, 'D')));
        moves.add(new ArrayList(Arrays.asList(13, 'L')));
        System.out.println((solution(n, k, l, apples, moves)));
    }
}
