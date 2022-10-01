public class Circle {

    double radius; // 반지름
    static double PI = 3.14;  // 파이이

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * PI * radius;
    }
}