package Java_12;
// Java 프로그래밍 - 내부 클래스

// 내부 클래스 구조
class Outer {
    public void print() {
        System.out.println("Outer.print");
    }

    class Inner {
        public void innerPrint() {
            Outer.this.print();
        }
    }

    static class InnerStaticClass{
        void innerPrint() {
//            Outer.this.print();    // static 클래스가 아니라서 바로 메모리에 올라가지 않음
        }
    }
}

abstract  class Person {
    public abstract void printInfo();
}

class Student extends Person {
    public void printInfo() {
        System.out.println("Student.printInfo");
    }
}

public class Main {

    public static void main(String[] args) {

//      외부 클래스
        Outer o1 = new Outer();

//      내부 클래스 - 인스턴스
        Outer.Inner i1 = new Outer().new Inner();   // 외부 객체->내부객체를 만들어서 접근해야함

//      내부 클래스 - 정적 (static)
        Outer.InnerStaticClass is1 = new Outer.InnerStaticClass();
        // static이기 때문에 Outer의 객체를 생성하지 않고 .으로 불러올 수 있다. (클래스 이름으로 접근)

//      익명 클래스   (anonymous)
        Person p1 = new Person() {
            @Override
            public void printInfo() {
                System.out.println("Main.printInfo");
            }
        };
    }

}
