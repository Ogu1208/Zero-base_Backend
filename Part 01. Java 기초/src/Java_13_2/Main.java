package Java_13_2;
// Java 프로그래밍 - 입출력_2

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
//      1. 파일 쓰기
//      FileWriter
        FileWriter fw = new FileWriter("./memo_13_2.txt");
        String memo = "헤드 라인\n";
        fw.write(memo);

        memo = "1월 1일 날씨 맑음\n";
        fw.write(memo);

        fw.close();

//      PrintWriter
        PrintWriter pw = new PrintWriter("./memo_13_2.txt");
        memo = "헤드 라인";
        pw.println(memo);   // 자동으로 줄바꿈 추가

        memo = "1월 1일 날씨 맑음";
        pw.println(memo);

        pw.close();

//      파일 이어 쓰기
//        FileWriter로 이어쓰기
        FileWriter fw2 = new FileWriter("./memo_13_2.txt", true);

        memo = "1월 2 날씨 완전 맑음\n";
        fw2.write(memo);
        fw2.close();

//        PrintWriter로 이어쓰기 - FileWriter를 만들어서 안에 넣어준다
        PrintWriter pw2 = new PrintWriter(new FileWriter("./memo_13_2.txt", true));

        memo = "1월 3 날씨 또 맑음!\n";
        pw2.println(memo);
        pw2.close();


//      2. 파일 읽기
        BufferedReader br = new BufferedReader(new FileReader("./memo_13_2.txt"));

        while(true) {
            String line = br.readLine();

            if(line==null) {
                break;
            }
            System.out.println(line);
        }
        br.close();



    }
}
