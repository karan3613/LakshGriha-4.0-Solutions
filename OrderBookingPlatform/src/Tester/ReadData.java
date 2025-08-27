package Tester;

import java.util.Scanner;

public class ReadData {
    private static final Scanner scanner = new Scanner(System.in);
    public static String acceptString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
