package Practice.Java_08.src;// Practice1
// 아래의 클래스 및 상속 관계에서 Test code를 수정하지 않고
// Cat 클래스 내에서 super 또는 super()를 이용하여
// "고양이 입니다." 가 출력될 수 있도록 변경해보세요.

class Animal {
    String desc;
    Animal() {
        this.desc = "동물 클래스 입니다.";
    }

    Animal(String desc) {
        this.desc = desc;
    }

    public void printInfo() {
        System.out.println(this.desc);
    }
}

class Cat extends Animal {
    String desc;
    Cat() {
        this.desc = "고양이 입니다.";
    }
}

public class Practice1 {
    public static void main(String[] args) {
        // Test code
        Cat cat = new Cat();
        cat.printInfo();

    }
}
