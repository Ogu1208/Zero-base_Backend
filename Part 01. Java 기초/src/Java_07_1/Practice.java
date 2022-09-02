package Java_07_1;
//  Practice
//  다음 클래스 직접 만든 후 객체 생성
//  클래스명: Animal
//  특성: 이름, 무게, 분류
//  기능: 먹기, 잠자기, 걷기, 뛰기
class Animal {
    String name;
    double weight;
    String classfication;

    Animal(String name, double weight, String classfication) {
        this.name = name;
        this.weight = weight;
        this.classfication = classfication;
    }

    public void printInfo() {
        System.out.println("name = " + name);
        System.out.println("weight = " + weight);
        System.out.println("classfication = " + classfication);
    }

    public void eat() {
        System.out.println("냠냠!");
    }

    public void sleep() {
        System.out.println("쿨쿨!");
    }


    public void walk() {
        System.out.println("걷는중!");
    }

    public void run() {
        System.out.println("뛰는중!");
    }
}

public class Practice {
    public static void main(String[] args) {
        // Test code
        Animal animal1 = new Animal("강아지", 5.0, "포유류");
        Animal animal2 = new Animal("구피", 0.01, "어류");

        animal1.printInfo();
        animal2.printInfo();
    }
}

