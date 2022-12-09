package DayThree;

import java.io.BufferedReader;
import java.io.FileReader;

public class DayThreePartTwo {

    public static void main(String[] args) {

        BufferedReader reader;
        String filePath = "C:/Users/james/Documents/GitHub/Advent of Code/2022/Advent-of-Code-2022/DayThree/Input.txt";
        int mySum = 0;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                String firstContainer = line;
                line = reader.readLine();
                String secondContainer = line;
                line = reader.readLine();
                String thirdContainer = line;

                mySum += (sumOfCharacters(foundLetters(firstContainer, secondContainer, thirdContainer)));

                line = reader.readLine();

            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println("Total Sum of Letter: " + mySum);
    }

    private static String foundLetters(String firstContainer, String secondContainer, String thirdContainer) {
        String results = "";

        char[] containerOne = firstContainer.toCharArray();
        char[] containerTwo = secondContainer.toCharArray();
        char[] containerThree = thirdContainer.toCharArray();

        for (char c : containerOne) {
            for (char d : containerTwo) {
                for (char e : containerThree)
                    if (Character.compare(c, d) == 0 && Character.compare(c, e) == 0) {
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
