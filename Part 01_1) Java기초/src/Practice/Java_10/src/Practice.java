package Practice.Java_10.src;// Practice
// 아래 Device 추상 클래스를 이용하여
// UsbPort1 클래스와 WiFi 클래스를 자유롭게 구현해보세요.

abstract class Device {
    int deviceId;

    abstract void deviceInfo();
    abstract void connect();
    abstract void disconnect();
    abstract void send();
    abstract void receive();
}

// UsbPort1 클래스


// WiFi 클래스


public class Practice {

    public static void main(String[] args) {
        // Test code
//        UsbPort1 usb1 = new UsbPort1(1);
//        WiFi wifi = new WiFi(0);
    }

}
