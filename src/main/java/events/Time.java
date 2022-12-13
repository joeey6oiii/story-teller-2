package events;

public class Time {
    public static void passMinutes(long minutes) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                for(int i = 1; i < minutes; i ++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Прошло " + i + " минуты");
                }
            }
        });
        thread.start();
        Thread.sleep(minutes * 1000);
        System.out.println("Прошло " + minutes + " минут");
    }
}
