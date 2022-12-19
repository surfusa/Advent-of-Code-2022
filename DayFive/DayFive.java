package DayFive;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DayFive {
    public static void main(String[] args) {
        BufferedReader reader;
        String filePath = "DayFive/Input.txt";
        List<Stack<Character>> containerOfStacks = new ArrayList<Stack<Character>>();
        List<Queue<Character>> containerOfQueues = new ArrayList<Queue<Character>>();
        boolean isPartOne = false;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            boolean readyToTakeInstructions = false;

            while (line != null) {

                if (line.equals("")) {

                    readyToTakeInstructions = true;
                    containerOfStacks = transformationFromQueueToStack(containerOfQueues);
                }

                else if (readyToTakeInstructions == true) {
                    // System.out.println(line);
                    instructionReader(containerOfStacks, line.split(" "), isPartOne);

                } else if (readyToTakeInstructions == false && line.charAt(1) != '1') {

                    for (int i = 1; i < line.length(); i += 4) {
                        containerOfQueues = newEntryToQueue(containerOfQueues, line.charAt(i), (i / 4));
                    }
                }

                line = reader.readLine();
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        for (int i = 0; i < containerOfStacks.size(); i++) {
            if (!containerOfStacks.get(i).isEmpty()) {
                System.out.println("Letter at " + (i + 1) + " is " + containerOfStacks.get(i).peek());
            }
        }
    }

    private static List<Stack<Character>> removeEntryFromStack(List<Stack<Character>> containerOfStacks,
            int affectedCol) {
        List<Stack<Character>> myStackContainer = containerOfStacks;
        myStackContainer.get(affectedCol).pop();

        return myStackContainer;
    }

    private static List<Stack<Character>> newEntryToStack(List<Stack<Character>> containerOfStacks, char letterAdding,
            int affectedCol) {
        List<Stack<Character>> myStackContainer = containerOfStacks;
        while (myStackContainer.size() < (affectedCol + 1)) {
            myStackContainer.add(new Stack<Character>());
        }
        if (letterAdding != ' ') {
            myStackContainer.get(affectedCol).push(letterAdding);
        }
        return myStackContainer;
    }

    private static List<Stack<Character>> newEntriesToStack(List<Stack<Character>> containerOfStacks,
            List<Character> listOfMovedCharacters,
            int affectedCol) {
        List<Stack<Character>> myStackContainer = containerOfStacks;
        List<Character> tempListOfCharacters = listOfMovedCharacters;
        while (!tempListOfCharacters.isEmpty()) {
            myStackContainer.get(affectedCol).push(tempListOfCharacters.get((tempListOfCharacters.size() - 1)));
            tempListOfCharacters.remove(tempListOfCharacters.size() - 1);
        }
        return myStackContainer;
    }

    private static List<Queue<Character>> newEntryToQueue(List<Queue<Character>> containerOfQueues, char letterAdding,
            int affectedCol) {
        List<Queue<Character>> myQueueContainer = containerOfQueues;
        if (myQueueContainer.size() < (affectedCol + 1)) {
            myQueueContainer.add(new LinkedList<Character>());
        }
        myQueueContainer.get(affectedCol).add(letterAdding);
        return myQueueContainer;
    }

    private static List<Stack<Character>> transformationFromQueueToStack(List<Queue<Character>> containerOfQueues) {
        List<Stack<Character>> myStackContainer = new ArrayList<Stack<Character>>();
        List<Character> tempCharacterArray = new ArrayList<Character>();
        for (int i = 0; i < containerOfQueues.size(); i++) {
            while (!containerOfQueues.get(i).isEmpty()) {
                tempCharacterArray.add(containerOfQueues.get(i).peek());
                containerOfQueues.get(i).remove();
            }
            for (int j = (tempCharacterArray.size() - 1); j >= 0; j--) {
                myStackContainer = newEntryToStack(myStackContainer, tempCharacterArray.get(j), i);
                tempCharacterArray.remove(j);
            }
        }

        return myStackContainer;
    }

    private static List<Stack<Character>> instructionReader(List<Stack<Character>> containerOfStacks,
            String[] instructions, boolean isPartOne) {
        List<Stack<Character>> myStackContainer = containerOfStacks;

        if (isPartOne) {
            for (int i = 0; i < Integer.valueOf(instructions[1]); i++) {

                if (!myStackContainer.get(Integer.valueOf(instructions[3]) - 1).isEmpty()) {
                    myStackContainer = newEntryToStack(myStackContainer,
                            myStackContainer.get(Integer.valueOf(instructions[3]) - 1).peek(),
                            (Integer.valueOf(instructions[5]) - 1));
                    containerOfStacks = removeEntryFromStack(containerOfStacks, (Integer.valueOf(instructions[3]) - 1));
                } else {
                    System.out.println("Warning, "
                            + Integer.valueOf(instructions[3]) + " stack is empty!");
                }
            }
        } else {
            List<Character> myListofCharacters = new ArrayList<Character>();
            for (int i = 0; i < Integer.valueOf(instructions[1]); i++) {

                if (!myStackContainer.get(Integer.valueOf(instructions[3]) - 1).isEmpty()) {
                    myListofCharacters.add(myStackContainer.get(Integer.valueOf(instructions[3]) - 1).peek());
                    containerOfStacks = removeEntryFromStack(containerOfStacks, (Integer.valueOf(instructions[3]) - 1));
                } else {
                    System.out.println("Warning, "
                            + Integer.valueOf(instructions[3]) + " stack is empty!");
                }

            }
            myStackContainer = newEntriesToStack(myStackContainer, myListofCharacters,
                    Integer.valueOf(instructions[5]) - 1);
        }

        return myStackContainer;
    }
}
