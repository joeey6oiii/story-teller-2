package events;

public class Time {
    public static void passMinutes(long minutes) throws InterruptedException {
        Thread.sleep(minutes * 1000);
        System.out.println("Прошло " + minutes + " минут");
    }
}
