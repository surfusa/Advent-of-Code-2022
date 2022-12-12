package DayFour;

import java.io.BufferedReader;
import java.io.FileReader;

public class DayFour {

    public static void main(String[] args) {
        BufferedReader reader;
        String filePath = "C:/Users/james/Documents/GitHub/Advent of Code/2022/Advent-of-Code-2022/DayFour/Input.txt";
        Integer total = 0;
        boolean isPartOne = false;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {

                if (isItContained(line.split("[,-]")) && isPartOne)
                    total++;

                else if (isThereOverlap(line.split("[,-]")) && !isPartOne)
                    total++;

                line = reader.readLine();

            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println("Total Sum of Letter: " + total);
    }

    private static boolean isItContained(String[] valuesOfShifts) {
        Integer NumOfFirstCombo = Integer.valueOf(valuesOfShifts[1]) - Integer.valueOf(valuesOfShifts[0]);
        Integer NumOfSecondCombo = Integer.valueOf(valuesOfShifts[3]) - Integer.valueOf(valuesOfShifts[2]);

        if (NumOfFirstCombo >= NumOfSecondCombo) {
            if (Integer.valueOf(valuesOfShifts[0]) <= Integer.valueOf(valuesOfShifts[2])
                    && Integer.valueOf(valuesOfShifts[1]) >= Integer.valueOf(valuesOfShifts[3])) {
                return true;
            }
        } else {
            if (Integer.valueOf(valuesOfShifts[2]) <= Integer.valueOf(valuesOfShifts[0])
                    && Integer.valueOf(valuesOfShifts[3]) >= Integer.valueOf(valuesOfShifts[1])) {
                return true;
            }
        }
        return false;
    }

    private static boolean isThereOverlap(String[] valuesOfShifts) {

        if (Integer.valueOf(valuesOfShifts[0]) >= Integer.valueOf(valuesOfShifts[2])) {
            if (Integer.valueOf(valuesOfShifts[0]) <= Integer.valueOf(valuesOfShifts[3])) {
                return true;
            }
        } else {
            if (Integer.valueOf(valuesOfShifts[2]) <= Integer.valueOf(valuesOfShifts[1])) {
                return true;
            }
        }
        return false;
    }
}
