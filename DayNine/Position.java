package DayNine;

public class Position {

    private int xCoordinates;
    private int yCoordinates;

    public Position(int xCoordinates, int yCoordinates) {
        this.xCoordinates = xCoordinates;
        this.yCoordinates = yCoordinates;
    }

    public int getXCoordinates() {
        return xCoordinates;
    }

    public void setXCoordinates(int x) {
        xCoordinates = x;
    }

    public int getYCoordinates() {
        return yCoordinates;
    }

    public void setYCoordinates(int y) {
        yCoordinates = y;
    }

    public Position getPosition() {
        return new Position(xCoordinates, yCoordinates);
    }

    public String getCoordinatesAsString() {
        return (xCoordinates + "," + yCoordinates);
    }

    public Position followingPostionUpdate(Position tail) {
        Position temp = tail.getPosition();
        if ((Math.abs(xCoordinates - temp.getXCoordinates()) + Math.abs(yCoordinates - temp.getYCoordinates())) > 2) {
            if ((xCoordinates - temp.getXCoordinates()) > 0) {
                temp.setXCoordinates(temp.getXCoordinates() + 1);
            } else if ((xCoordinates - temp.getXCoordinates()) < 0) {
                temp.setXCoordinates(temp.getXCoordinates() - 1);
            }
            if ((yCoordinates - temp.getYCoordinates()) > 0) {
                temp.setYCoordinates(temp.getYCoordinates() + 1);
            } else if ((yCoordinates - temp.getYCoordinates()) < 0) {
                temp.setYCoordinates(temp.getYCoordinates() - 1);
            }
        } else if (Math.abs(xCoordinates - temp.getXCoordinates()) > 1) {
            if ((xCoordinates - temp.getXCoordinates()) > 0) {
                temp.setXCoordinates(temp.getXCoordinates() + 1);
            } else if ((xCoordinates - temp.getXCoordinates()) < 0) {
                temp.setXCoordinates(temp.getXCoordinates() - 1);
            }
        } else if (Math.abs(yCoordinates - temp.getYCoordinates()) > 1) {
            if ((yCoordinates - temp.getYCoordinates()) > 0) {
                temp.setYCoordinates(temp.getYCoordinates() + 1);
            } else if ((yCoordinates - temp.getYCoordinates()) < 0) {
                temp.setYCoordinates(temp.getYCoordinates() - 1);
            }
        }
        return temp;
    }
}
