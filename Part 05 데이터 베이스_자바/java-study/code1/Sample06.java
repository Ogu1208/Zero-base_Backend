package code1;

public class Sample06 {
  
  public void test() {

    int curMonth = 4;
    int curDay = 0;

    switch(curMonth) {
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
         curDay = 31;
         break;

      case 4:
      case 6:
      case 11:
         curDay = 30;
         break;

      default:
         curDay = 28;
    }  
  }

  public void test2() {

      for(int i = 0; i < 10; i++) {

      }

      int i = 10;
      while (i > 10) {

         // continue;

         if (i != 10) {
            break;
         }
      }

      do {

      } while  (i > 10);
  }
}
