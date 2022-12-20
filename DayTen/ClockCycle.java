package DayTen;

import java.util.ArrayList;
import java.util.List;

public class ClockCycle {
    private List<Cycle> cycleList;
    int totalValue;

    public ClockCycle() {
        cycleList = new ArrayList<Cycle>();
        totalValue = 1;
    }

    public void runFunction(String myCommand) {
        switch (myCommand.split(" ")[0]) {
            case "noop":
                noopFunction();
                break;
            case "addx":
                addxFunction(Integer.valueOf(myCommand.split(" ")[1]));
                break;
            default:
                System.out.println("Unexpected Command! Recieved: " + myCommand);
                break;
        }
    }

    public void noopFunction() {
        cycleList.add(new Cycle(0, totalValue, true));
    }

    public void addxFunction(int additionValue) {
        cycleList.add(new Cycle(additionValue, totalValue, false));
        Cycle temp = new Cycle(additionValue, totalValue, false);
        temp.updateValue();
        totalValue = temp.getTotalValue();
        cycleList.add(temp);
    }

    public int getTotalAtCycle(int cycleNum) {
        cycleNum--;
        if (cycleList.get(cycleNum).getIsUpdateDone() == true) {
            return cycleList.get(cycleNum - 1).getTotalValue();
        }
        return cycleList.get(cycleNum).getTotalValue();
    }

    public boolean checkCursor(int index, int rowNum) {
        int temp = index - (rowNum * 40);
        if (cycleList.get(index).getIsUpdateDone()) {
            index--;
        }
        if ((cycleList.get(index).getTotalValue() - 1) == temp || (cycleList.get(index).getTotalValue()) == temp
                || (cycleList.get(index).getTotalValue() + 1) == temp) {
            return true;
        }
        return false;
    }
}
