package DayTen;

public class Cycle {
    private int additionValue = 0;
    private int totalValue;
    private boolean isNoop = false;
    private boolean isUpdateDone = false;

    public Cycle(int additionValue, int totalValue, boolean isNoop) {
        this.additionValue = additionValue;
        this.totalValue = totalValue;
        this.isNoop = isNoop;
        isUpdateDone = false;
    }

    public int getAdditionalValue() {
        return additionValue;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(int value) {
        totalValue = value;
    }

    public boolean getIsUpdateDone() {
        return isUpdateDone;
    }

    public void setIsUpdateDone(boolean isUpdated) {
        isUpdateDone = isUpdated;
    }

    public boolean isReferenceNoop() {
        return isNoop;
    }

    public void setNoop(boolean noopSetting) {
        isNoop = noopSetting;
    }

    public Cycle returnCycle() {
        Cycle temp = new Cycle(additionValue, totalValue, isNoop);
        temp.setIsUpdateDone(isUpdateDone);
        return temp;
    }

    public void updateValue() {
        totalValue += additionValue;
        isUpdateDone = true;
    }

}
