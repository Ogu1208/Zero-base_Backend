import java.util.Scanner;

public class 모스부호테스트 {

    public static void main(String[] args) {

        String str = "SOS";
        String[] morseCode = {".-", "-...", "-.-.", "-..", ".",
                "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---",
                ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--",
                "--.."};

        Scanner scanner = new Scanner(System.in);
        String str2 = scanner.next();
        for (int i = 0; i < str2.length(); i++) {
            int code = (int) str.charAt(i) - 65;
            System.out.println(morseCode[code]);
        }
//        for (int i = 0; i < str.length(); i++) {
//            System.out.println((int) str.charAt(i));
//        }
    }
}
