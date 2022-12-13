package events;

public class Time {
    public static void passMinutes(long minutes) {
        for (int i = 1; i <= minutes; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Прошло " + minutes + " минут");
    }

    public static void skip(){
        System.out.println();
        System.out.println("Прошло некоторое время...");
        System.out.println();
    }
}
