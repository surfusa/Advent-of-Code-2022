package DayThree;

import java.io.BufferedReader;
import java.io.FileReader;

public class DayThreePartOne {
    public static void main(String[] args) {

        BufferedReader reader;
        String filePath = "C:/Users/james/Documents/GitHub/Advent of Code/2022/Advent-of-Code-2022/DayThree/Input.txt";
        int mySum = 0;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                String firstContainer = line.substring(0, ((line.length()) / 2));
                String secondContainer = line.substring((((line.length() - 1) / 2) + 1), (line.length()));

                mySum += (sumOfCharacters(foundLetters(firstContainer, secondContainer)));

                line = reader.readLine();

            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println("Total Sum of Letter: " + mySum);
    }

    private static String foundLetters(String containerOne, String containerTwo) {
        String results = "";

        char[] firstContainer = containerOne.toCharArray();
        char[] secondContainer = containerTwo.toCharArray();

        for (char c : firstContainer) {
            for (char d : secondContainer) {
                if (Character.compare(c, d) == 0) {
                    if (!results.contains(String.valueOf(c)))
                        results += c;
                }
            }
        }

        return results;
    }

    private static int sumOfCharacters(String listOfCharacters) {
        int sum = 0;
        for (char c : listOfCharacters.toCharArray()) {
            if (Integer.valueOf(c) <= 90) {
                sum += (Integer.valueOf(c) - 38);
            } else {
                sum += (Integer.valueOf(c) - 96);
            }
        }
        return sum;
    }
}