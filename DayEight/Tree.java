package DayEight;

public class Tree {

    private int treeSize = 0;
    private Tree northTree = null;
    private Tree southTree = null;
    private Tree westTree = null;
    private Tree eastTree = null;
    private int northViewScore = 0;
    private int southViewScore = 0;
    private int westViewScore = 0;
    private int eastViewScore = 0;
    private boolean isTreeVisible = false;

    public Tree(int treeSize, Tree northTree, Tree westTree) {
        this.treeSize = treeSize;
        this.northTree = northTree;
        this.westTree = westTree;
    }

    public int getTreeSize() {
        return treeSize;
    }

    public Tree getNorthTree() {
        return northTree;
    }

    public void setNorthTree(Tree input) {
        northTree = input;
    }

    public Tree getSouthTree() {
        return southTree;
    }

    public void setSouthTree(Tree input) {
        southTree = input;
    }

    public Tree getWestTree() {
        return westTree;
    }

    public void setWesthTree(Tree input) {
        westTree = input;
    }

    public Tree getEastTree() {
        return eastTree;
    }

    public void setEastTree(Tree input) {
        eastTree = input;
    }

    public int getNorthViewScore() {
        return northViewScore;
    }

    public void setNorthViewScore(int northViewScore) {
        this.northViewScore = northViewScore;
    }

    public int getSouthViewScore() {
        return southViewScore;
    }

    public void setSouthViewScore(int southViewScore) {
        this.southViewScore = southViewScore;
    }

    public int getWestViewScore() {
        return westViewScore;
    }

    public void setWestViewScore(int westViewScore) {
        this.westViewScore = westViewScore;
    }

    public int getEastViewScore() {
        return eastViewScore;
    }

    public void setEastViewScore(int eastViewScore) {
        this.eastViewScore = eastViewScore;
    }

    public void treeIsVisible() {
        isTreeVisible = true;
    }

    public boolean getCheckTreeVisible() {
        return isTreeVisible;
    }

    public Tree checkTreeVisible(Tree myTree) {
        Tree tempTree = myTree;

        if (tempTree.getNorthTree() == null || tempTree.getSouthTree() == null || tempTree.getWestTree() == null
                || tempTree.getEastTree() == null) {
            tempTree.treeIsVisible();
        } else if (findTallestNorthTree(tempTree.getNorthTree(), tempTree.getTreeSize(), true)) {
            tempTree.treeIsVisible();
        } else if (findTallestSouthTree(tempTree.getSouthTree(), tempTree.getTreeSize(), true)) {
            tempTree.treeIsVisible();
        } else if (findTallestWestTree(tempTree.getWestTree(), tempTree.getTreeSize(), true)) {
            tempTree.treeIsVisible();
        } else if (findTallestEastTree(tempTree.getEastTree(), tempTree.getTreeSize(), true)) {
            tempTree.treeIsVisible();
        }

        return tempTree;
    }

    public boolean findTallestNorthTree(Tree myTree, int testingSize, boolean result) {
        boolean currentResult = result;

        if (testingSize > myTree.getTreeSize()) {
            if (myTree.getNorthTree() != null) {
                currentResult = findTallestNorthTree(myTree.getNorthTree(), testingSize, result);
            }
        } else {
            return false;
        }

        return (result && currentResult);
    }

    public boolean findTallestSouthTree(Tree myTree, int testingSize, boolean result) {
        boolean currentResult = result;

        if (testingSize > myTree.getTreeSize()) {
            if (myTree.getSouthTree() != null) {
                currentResult = findTallestSouthTree(myTree.getSouthTree(), testingSize, result);
            }
        } else {
            return false;
        }

        return (result && currentResult);
    }

    public boolean findTallestWestTree(Tree myTree, int testingSize, boolean result) {
        boolean currentResult = result;

        if (testingSize > myTree.getTreeSize()) {
            if (myTree.getWestTree() != null) {
                currentResult = findTallestWestTree(myTree.getWestTree(), testingSize, result);
            }
        } else {
            return false;
        }

        return (result && currentResult);
    }

    public boolean findTallestEastTree(Tree myTree, int testingSize, boolean result) {
        boolean currentResult = result;

        if (testingSize > myTree.getTreeSize()) {
            if (myTree.getEastTree() != null) {
                currentResult = findTallestEastTree(myTree.getEastTree(), testingSize, result);
            }
        } else {
            return false;
        }

        return (result && currentResult);
    }

    public int calculateViewScore() {
        return (northViewScore * southViewScore * westViewScore * eastViewScore);
    }

    public Tree findViewScore(Tree myTree) {
        Tree tempTree = myTree;

        if (tempTree.getNorthTree() == null) {
            tempTree.setNorthViewScore(0);
        } else {
            tempTree.setNorthViewScore(findViewNorth(tempTree.getNorthTree(), tempTree.getTreeSize(), 0));
        }

        if (tempTree.getSouthTree() == null) {
            tempTree.setSouthViewScore(0);
        } else {
            tempTree.setSouthViewScore(findViewSouth(tempTree.getSouthTree(), tempTree.getTreeSize(), 0));
        }

        if (tempTree.getWestTree() == null) {
            tempTree.setWestViewScore(0);
        } else {
            tempTree.setWestViewScore(findViewWest(tempTree.getWestTree(), tempTree.getTreeSize(), 0));
        }

        if (tempTree.getEastTree() == null) {
            tempTree.setEastViewScore(0);
        } else {
            tempTree.setEastViewScore(findViewEast(tempTree.getEastTree(), tempTree.getTreeSize(), 0));
        }

        return tempTree;
    }

    public int findViewNorth(Tree myTree, int originalTreeSize, int viewScore) {
        int currentViewScore = viewScore;

        if (myTree.getTreeSize() < originalTreeSize) {
            if (myTree.getNorthTree() != null) {
                currentViewScore = findViewNorth(myTree.getNorthTree(), originalTreeSize, currentViewScore);
            }
            currentViewScore++;
        } else if (myTree.getTreeSize() >= originalTreeSize) {
            currentViewScore++;
        }

        return currentViewScore;
    }

    public int findViewSouth(Tree myTree, int originalTreeSize, int viewScore) {
        int currentViewScore = viewScore;

        if (myTree.getTreeSize() < originalTreeSize) {
            if (myTree.getSouthTree() != null) {
                currentViewScore = findViewSouth(myTree.getSouthTree(), originalTreeSize, currentViewScore);
            }
            currentViewScore++;
        } else if (myTree.getTreeSize() >= originalTreeSize) {
            currentViewScore++;
        }

        return currentViewScore;
    }

    public int findViewWest(Tree myTree, int originalTreeSize, int viewScore) {
        int currentViewScore = viewScore;

        if (myTree.getTreeSize() < originalTreeSize) {
            if (myTree.getWestTree() != null) {
                currentViewScore = findViewWest(myTree.getWestTree(), originalTreeSize, currentViewScore);
            }
            currentViewScore++;
        } else if (myTree.getTreeSize() >= originalTreeSize) {
            currentViewScore++;
        }

        return currentViewScore;
    }

    public int findViewEast(Tree myTree, int originalTreeSize, int viewScore) {
        int currentViewScore = viewScore;

        if (myTree.getTreeSize() < originalTreeSize) {
            if (myTree.getEastTree() != null) {
                currentViewScore = findViewEast(myTree.getEastTree(), originalTreeSize, currentViewScore);
            }
            currentViewScore++;
        } else if (myTree.getTreeSize() >= originalTreeSize) {
            currentViewScore++;
        }

        return currentViewScore;
    }
}
