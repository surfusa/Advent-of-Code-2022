package DayTen;

import java.io.BufferedReader;
import java.io.FileReader;

public class ExecuteCathode {

    public static void main(String[] args) {
        int[] cycleResultsAt = new int[] { 20, 60, 100, 140, 180, 220 };
        String CRT = "................................................................................................................................................................................................................................................";
        String filePath = "DayTen/Input.txt";
        ClockCycle clockCycle = new ClockCycle();
        int total = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();

            while (line != null) {
                clockCycle.runFunction(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        for (int i : cycleResultsAt) {
            System.out.println("Result for " + i + "th cycle is: " + (clockCycle.getTotalAtCycle(i)));
            total += (clockCycle.getTotalAtCycle(i) * i);
        }
        System.out.println("Sum for cycles: " + (total));

        for (int i = 0; i < 240; i++) {
            if (clockCycle.checkCursor(i, (i / 40))) {
                System.out.println(i);
                StringBuilder myString = new StringBuilder(CRT);
                myString.setCharAt(i, '#');
                CRT = myString.toString();
            }
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(CRT.substring((40 * i), (40 * i + 40)));
        }
    }

}