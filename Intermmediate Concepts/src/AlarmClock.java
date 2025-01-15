import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter alarm hour (0-23): ");
        int hour = scanner.nextInt();
        System.out.print("Enter alarm minute (0-59): ");
        int minute = scanner.nextInt();

        LocalTime alarmTime = LocalTime.of(hour, minute);

        System.out.println("Alarm set for: " + alarmTime);

        while (true) {
            LocalTime currentTime = LocalTime.now();

            if (currentTime.equals(alarmTime)) {
                System.out.println("ALARM! It's " + alarmTime + " now!");
                break;
            }

            try {
                Thread.sleep(1000);  // Sleep for 1 second to avoid constant checking
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}
