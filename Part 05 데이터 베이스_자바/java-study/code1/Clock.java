package code1;

public class Clock {

    int hour;
    int minute;
    int second;

    boolean useAlarmYN;
    int alarmHour;
    int alarmMinute;

    public void setAlarm(int hour, int minute) {
        alarmHour = hour;
        alarmMinute = minute;
    }

    public void alarmOn() {
        useAlarmYN = true;
    }

    public void alarmOff() {
        useAlarmYN = false;
    }

    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
