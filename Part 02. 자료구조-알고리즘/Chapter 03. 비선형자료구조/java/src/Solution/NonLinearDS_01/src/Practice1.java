package Solution.NonLinearDS_01.src;// Practice1
// 배열을 이용한 이진 트리 구성, 순회

class BinaryTree {
    char[] arr;

    BinaryTree(char[] data) {
        this.arr = data.clone();
    }

    public void preOrder(int idx) {
        System.out.print(this.arr[idx] + " ");

        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        if (left < this.arr.length) {
            this.preOrder(left);
        }
        if (right < this.arr.length) {
            this.preOrder(right);
        }
    }

    public void inOrder(int idx) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if (left < this.arr.length) {
            this.inOrder(left);
        }

        System.out.print(this.arr[idx] + " ");

        if (right < this.arr.length) {
            this.inOrder(right);
        }
    }

    public void postOrder(int idx) {
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if (left < this.arr.length) {
            this.postOrder(left);
        }

        if (right < this.arr.length) {
            this.postOrder(right);
        }

        System.out.print(this.arr[idx] + " ");
    }

    public void levelOrder(int idx) {
        for (int i = idx; i < this.arr.length; i++) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }
}

public class Practice1 {
    public static void main(String[] args) {
        // Test code
        char[] arr = new char[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)('A' + i);
        }

        BinaryTree bt = new BinaryTree(arr);

        System.out.println("== Preorder ==");
        bt.preOrder(0);
        System.out.println();

        System.out.println("== Inorder ==");
        bt.inOrder(0);
        System.out.println();

        System.out.println("== Postorder ==");
        bt.postOrder(0);
        System.out.println();

        System.out.println("== Levelorder ==");
        bt.levelOrder(0);
        System.out.println();
    }
}
