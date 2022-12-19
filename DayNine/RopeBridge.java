package DayNine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RopeBridge {
    public static void main(String[] args) {
        String filePath = "DayNine/Input.txt";
        Position[] rope = new Position[10];
        for (int i = 0; i < rope.length; i++) {
            rope[i] = new Position(0, 0);
        }
        List<HashSet<String>> previousTailCoordinates = new ArrayList<HashSet<String>>();
        for (int i = 0; i < rope.length; i++) {
            previousTailCoordinates.add(new HashSet<String>());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();

            while (line != null) {
                switch (line.charAt(0)) {
                    case 'U':
                        for (int i = 0; i < Integer.valueOf(line.split(" ")[1]); i++) {
                            rope[0].setYCoordinates(rope[0].getYCoordinates() + 1);
                            for (int j = 1; j < rope.length; j++) {
                                rope[j] = rope[j - 1].followingPostionUpdate(rope[j]);
                                previousTailCoordinates.get(j).add(rope[j].getCoordinatesAsString());
                            }
                        }
                        break;
                    case 'D':
                        for (int i = 0; i < Integer.valueOf(line.split(" ")[1]); i++) {
                            rope[0].setYCoordinates(rope[0].getYCoordinates() - 1);
                            for (int j = 1; j < rope.length; j++) {
                                rope[j] = rope[j - 1].followingPostionUpdate(rope[j]);
                                previousTailCoordinates.get(j).add(rope[j].getCoordinatesAsString());
                            }
                        }
                        break;
                    case 'R':
                        for (int i = 0; i < Integer.valueOf(line.split(" ")[1]); i++) {
                            rope[0].setXCoordinates(rope[0].getXCoordinates() + 1);
                            for (int j = 1; j < rope.length; j++) {
                                rope[j] = rope[j - 1].followingPostionUpdate(rope[j]);
                                previousTailCoordinates.get(j).add(rope[j].getCoordinatesAsString());
                            }

                        }
                        break;
                    case 'L':
                        for (int i = 0; i < Integer.valueOf(line.split(" ")[1]); i++) {
                            rope[0].setXCoordinates(rope[0].getXCoordinates() - 1);
                            for (int j = 1; j < rope.length; j++) {
                                rope[j] = rope[j - 1].followingPostionUpdate(rope[j]);
                                previousTailCoordinates.get(j).add(rope[j].getCoordinatesAsString());
                            }
                        }
                        break;

                    default:
                        System.out.println("Direction not found!");
                        return;
                }
                line = reader.readLine();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        for (int i = 1; i < previousTailCoordinates.size(); i++) {
            System.out.println("Number of positions for Tail " + i + ": " + previousTailCoordinates.get(i).size());
        }
    }
}
