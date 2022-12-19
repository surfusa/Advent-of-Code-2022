package DaySix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class DaySix {
    public static void main(String[] args) {
        String filePath = "DaySix/Input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            boolean isPartOne = false;

            if (isPartOne) {
                for (int i = 4; i < (line.length()); i++) {

                    String subStringOfLetters = line.substring((i - 4), i);

                    if (checkIfNoDuplicates(subStringOfLetters)) {
                        System.out.println("Final: " + (i + 1));
                        return;
                    }
                }
            } else {
                for (int i = 14; i < (line.length()); i++) {

                    String subStringOfLetters = line.substring((i - 13), i);

                    if (checkIfNoDuplicates(subStringOfLetters)) {
                        System.out.println("Final: " + (i + 1));
                        return;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    private static boolean checkIfNoDuplicates(String mySubString) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : mySubString.toCharArray()) {
            if (map.containsKey(c))
                return false;
            else
                map.put(c, 1);
        }
        return true;
    }
}
