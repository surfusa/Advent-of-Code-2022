import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.lang.Integer;
import java.io.IOException;

public class DayOne {
    public static void main(String[] args) {
        Path filePath = Paths.get("C:/Users/james/Documents/GitHub/Advent of Code/2022/DayOne/Input.txt");
        List<String> entries = null;
        try {
            entries = Files.readAllLines(filePath);
        } catch (IOException ioe) {
            System.out.println(ioe);
            return;
        }

        Integer[] totals = new Integer[entries.size()];
        totals[0] = Integer.parseInt(entries.get(0));

        Integer index = 0;
        while (entries.size() != 1) {
            if (entries.get(0).replace("\n", "").replace("\r", "").compareTo("") == 0) {
                index++;
                totals[index] = 0;
            } else {
                totals[index] = totals[index] + Integer.parseInt(
                        entries.get(0).replaceAll("\n", "")
                                .replaceAll("\r", ""));
            }
            entries.remove(0);
        }
        System.out.println(largestCount(totals));
    }

    private static Integer largestCount(Integer[] totals) {

        int biggestCount = 0;
        int secondBiggestCount = 0;
        int thirdBiggestCount = totals[0];

        if (thirdBiggestCount > totals[1]) {
            secondBiggestCount = thirdBiggestCount;
            thirdBiggestCount = totals[1];
        } else {
            secondBiggestCount = totals[1];
        }
        if (thirdBiggestCount > totals[2]) {
            biggestCount = secondBiggestCount;
            secondBiggestCount = thirdBiggestCount;
            thirdBiggestCount = totals[2];
        } else if (secondBiggestCount > totals[2]) {
            biggestCount = secondBiggestCount;
            secondBiggestCount = totals[2];
        } else {
            biggestCount = totals[2];
        }

        for (int i = 3; i < (totals.length - 1) && totals[i] != null; i++) {
            if (biggestCount < totals[i]) {
                thirdBiggestCount = secondBiggestCount;
                secondBiggestCount = biggestCount;
                biggestCount = totals[i];
            } else if (secondBiggestCount < totals[i]) {
                thirdBiggestCount = secondBiggestCount;
                secondBiggestCount = totals[i];
            } else if (thirdBiggestCount < totals[i]) {
                thirdBiggestCount = totals[i];
            }
        }
        System.out.println("1st: " + biggestCount);
        System.out.println("2nd: " + secondBiggestCount);
        System.out.println("3rd: " + thirdBiggestCount);
        System.out.println("Sum: " + (biggestCount + secondBiggestCount + thirdBiggestCount));
        return biggestCount;
    }
}
