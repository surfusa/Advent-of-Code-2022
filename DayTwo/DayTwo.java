
import java.nio.file.Files;
import javax.swing.text.html.parser.Parser;
import java.lang.Integer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DayTwo {
    public static void main(String[] args) {

        BufferedReader reader;
        String filePath = "C:/Users/james/Documents/GitHub/Advent of Code/2022/DayTwo/Input.txt";
        int myScore = 0;
        boolean isPart1 = false;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                String[] resultArray = line.split(" ");

                if (isPart1)
                    myScore += (outcomeScorePart1(resultArray) + scoreCalculatorPart1(resultArray[1]));
                else
                    myScore += (outcomeScorePart2(resultArray) + scoreCalculatorPart2(resultArray[1]));

                line = reader.readLine();

            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println("Final Score: " + myScore);
    }

    private static int outcomeScorePart1(String[] rspChoice) {

        switch (rspChoice[1]) {
            case "X":
                switch (rspChoice[0]) {
                    case "A":
                        return 3;
                    case "B":
                        return 0;
                    case "C":
                        return 6;
                    default:
                        System.out.println("No Input found!");
                        return 0;
                }
            case "Y":
                switch (rspChoice[0]) {
                    case "A":
                        return 6;
                    case "B":
                        return 3;
                    case "C":
                        return 0;
                    default:
                        System.out.println("No Input found!");
                        return 0;
                }
            case "Z":
                switch (rspChoice[0]) {
                    case "A":
                        return 0;
                    case "B":
                        return 6;
                    case "C":
                        return 3;
                    default:
                        System.out.println("No Input found!");
                        return 0;
                }
            default:
                System.out.println("No Input found!");
                return 0;
        }
    }

    private static int scoreCalculatorPart1(String rspChoice) {
        int score = 0;
        switch (rspChoice) {
            case "X":
                return 1;
            case "Y":
                return 2;
            case "Z":
                return 3;
            default:
                System.out.println("No Input found!");
                return 0;
        }
    }

    private static int outcomeScorePart2(String[] rspChoice) {

        switch (rspChoice[1]) {
            case "X":
                switch (rspChoice[0]) {
                    case "A":
                        return 3;
                    case "B":
                        return 1;
                    case "C":
                        return 2;
                    default:
                        System.out.println("No Input found!");
                        return 0;
                }
            case "Y":
                switch (rspChoice[0]) {
                    case "A":
                        return 1;
                    case "B":
                        return 2;
                    case "C":
                        return 3;
                    default:
                        System.out.println("No Input found!");
                        return 0;
                }
            case "Z":
                switch (rspChoice[0]) {
                    case "A":
                        return 2;
                    case "B":
                        return 3;
                    case "C":
                        return 1;
                    default:
                        System.out.println("No Input found!");
                        return 0;
                }
            default:
                System.out.println("No Input found!");
                return 0;
        }
    }

    private static int scoreCalculatorPart2(String rspChoice) {
        int score = 0;
        switch (rspChoice) {
            case "X":
                return 0;
            case "Y":
                return 3;
            case "Z":
                return 6;
            default:
                System.out.println("No Input found!");
                return 0;
        }
    }
}
