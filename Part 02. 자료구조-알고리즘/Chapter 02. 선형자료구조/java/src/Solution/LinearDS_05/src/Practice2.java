package Solution.LinearDS_05.src;// Practice2
// Palindrome 연결 리스트
// 추가 자료구조 없이 연결 리스트만으로 풀어보기
// Palindrome: 앞으로 읽어도 뒤로 읽어도 같은 문자열

// 입력 예시)
// 입력 연결 리스트: 1, 3, 5, 3, 1
// 결과: true

// 입력 연결 리스트: 3, 5, 5, 3
// 결과: true

// 입력 연결 리스트: 1, 3, 5, 1
// 결과: false


public class Practice2 {
    public static boolean checkPalindrome(LinkedList list) {
        Node cur = list.head;
        Node left = list.head;
        Node right = null;

        int cnt = 0;
        while (cur != null) {
            cnt++;
            right = cur;
            cur = cur.next;
        }

        Node prevRight = right;
        for (int i = 0; i < cnt / 2; i++) {
            if (left.data != right.data) {
                return false;
            }

            left = left.next;
            right = left;
            while (right.next != prevRight) {
                right = right.next;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test code
        LinkedList linkedList = new LinkedList();
        linkedList.addData(1);
        linkedList.addData(3);
        linkedList.addData(5);
        linkedList.addData(3);
        linkedList.addData(1);
        System.out.println(checkPalindrome(linkedList));

        LinkedList linkedList2 = new LinkedList();
        linkedList2.addData(3);
        linkedList2.addData(5);
        linkedList2.addData(5);
        linkedList2.addData(3);
        System.out.println(checkPalindrome(linkedList2));

        LinkedList linkedList3 = new LinkedList();
        linkedList3.addData(1);
        linkedList3.addData(3);
        linkedList3.addData(5);
        linkedList3.addData(1);
        System.out.println(checkPalindrome(linkedList3));

        LinkedList linkedList4 = new LinkedList();
        linkedList4.addData(1);
        linkedList4.addData(3);
        linkedList4.addData(5);
        linkedList4.addData(5);
        linkedList4.addData(3);
        linkedList4.addData(1);
        System.out.println(checkPalindrome(linkedList4));

    }
}
