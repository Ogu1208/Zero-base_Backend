package Solution.Java_12.src;// Java 프로그래밍 - 내부 클래스

class Outer {

    public void print() {
        System.out.println("Outer.print");
    }

    class Inner {
        void innerPrint() {
            Outer.this.print();
        }
    }

    static class InnerStaticClass {
        void innerPrint() {
//            Outer.this.print();
        }
    }

    public void outerMethod() {
        class InnerLocal {

        }

        InnerLocal il1 = new InnerLocal();
    }
}

abstract class Person {
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
        Outer.Inner i1 = new Outer().new Inner();

//      내부 클래스 - 정적
        Outer.InnerStaticClass is1 = new Outer.InnerStaticClass();
        
//      익명 클래스
        Person p1 = new Person() {
            @Override
            public void printInfo() {
                System.out.println("Main.printInfo");
            }
        };

    }

}
