package Music.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputParser {
    public static int getDuration() {
        Scanner in = new Scanner(System.in);
        int duration = -1;

        while (duration < 0) {
            try {
                System.out.println("Your duration: ");
                duration = in.nextInt();
            } catch (InputMismatchException e) {
                in.nextLine();
            }

            if (duration < 0) {
                System.out.println("You should enter a non-negative integer");
            }
        }

        return duration;
    }
}