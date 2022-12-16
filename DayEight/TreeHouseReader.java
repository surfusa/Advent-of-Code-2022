package DayEight;

import java.io.BufferedReader;
import java.io.FileReader;

public class TreeHouseReader {

    public static void main(String[] args) {
        String filePath = "DayEight/Input.txt";
        Tree[][] treeGrid = new Tree[99][99];
        int visibleTrees = 0;
        int totalViewScore = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            int sizeOfTree;
            int rowCounter = 0;
            while (line != null) {
                for (int columnCounter = 0; columnCounter < line.length(); columnCounter++) {
                    sizeOfTree = (Integer.valueOf(line.charAt(columnCounter)) - 48);
                    Tree northTree = null;
                    Tree westTree = null;
                    Tree newTree = null;

                    if (columnCounter > 0) {
                        westTree = treeGrid[rowCounter][columnCounter - 1];
                    }
                    if (rowCounter > 0) {
                        northTree = treeGrid[rowCounter - 1][columnCounter];
                    }

                    treeGrid[rowCounter][columnCounter] = new Tree(sizeOfTree, northTree, westTree);
                    newTree = treeGrid[rowCounter][columnCounter];

                    if (columnCounter > 0) {

                        treeGrid[rowCounter][columnCounter - 1].setEastTree(newTree);
                    }
                    if (rowCounter > 0) {
                        treeGrid[rowCounter - 1][columnCounter].setSouthTree(newTree);
                    }
                }
                line = reader.readLine();
                rowCounter++;
            }

            for (int i = 0; i < 99; i++) {
                for (int j = 0; j < 99; j++) {
                    treeGrid[i][j] = treeGrid[i][j].checkTreeVisible(treeGrid[i][j]);
                    if (treeGrid[i][j].getCheckTreeVisible()) {
                        visibleTrees++;
                    }
                }
            }

            for (int i = 0; i < 99; i++) {
                for (int j = 0; j < 99; j++) {
                    treeGrid[i][j] = treeGrid[i][j].findViewScore(treeGrid[i][j]);
                    if (treeGrid[i][j].calculateViewScore() > totalViewScore) {
                        totalViewScore = treeGrid[i][j].calculateViewScore();
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        System.out.println("Total Visible Trees: " + visibleTrees);

        System.out.println("Best View Score: " + totalViewScore);
    }
}
