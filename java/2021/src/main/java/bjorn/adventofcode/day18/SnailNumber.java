package bjorn.adventofcode.day18;

public class SnailNumber implements SnailPart{
    private SnailPart leftSide;
    private SnailPart rightSide;
    private SnailNumber parent;

    public SnailNumber(SnailNumber parent, String number) {
        this.parent = parent;
        String content = number.substring(1,number.length()-1);
        int split = findSplit(content);
        leftSide = parseSide(content.substring(0, split));
        rightSide = parseSide(content.substring(split+1));
    }

    public SnailNumber(SnailNumber parent, SnailPart leftHand, SnailPart rightHand) {
        this.parent = parent;
        leftSide = leftHand;
        leftHand.setParent(this);
        rightSide = rightHand;
        rightHand.setParent(this);
    }

    private int findSplit(String number) {
        int subLevels = 0;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if(c == '[') {
                subLevels++;
            } else if(c == ']') {
                subLevels--;
            } else if(subLevels == 0 && c == ',') {
                return i;
            }
        }

        // Leaf
        return -1;
    }

    private SnailPart parseSide(String part) {
        try {
            return new SnailLeaf(Integer.parseInt(part));
        } catch (NumberFormatException ex) {
            return new SnailNumber(this, part);
        }
    }

    public boolean explode() {
        return doExplode(0);
    }

    public boolean doExplode(int level) {
        if (level > 3) {
            parent.increaseRight(this, getRight());
            parent.increaseLeft(this, getLeft());
            parent.remove(this);
            return true;
        }
        return leftSide.doExplode(level+1) || rightSide.doExplode(level+1);
    }

    private void remove(SnailNumber toRemove) {
        if(rightSide == toRemove) {
            rightSide = new SnailLeaf(0);
        } else {
            leftSide = new SnailLeaf(0);
        }
    }


    private void increaseRight(SnailNumber child, int value) {
        if (rightSide != child) {
            rightSide.setLeft(rightSide.getLeft() + value);
        } else if (parent != null) {
            parent.increaseRight(this, value);
        }
    }

    private void increaseLeft(SnailNumber child, int value) {
        if (leftSide != child) {
            leftSide.setRight(leftSide.getRight() + value);
        } else if (parent != null) {
            parent.increaseLeft(this, value);
        }
    }

    public String toString() {
        return "[" + leftSide + "," + rightSide + "]";
    }

    @Override
    public int getLeft() {
        return leftSide.getLeft();
    }

    @Override
    public int getRight() {
        return rightSide.getRight();
    }

    @Override
    public void setLeft(int newValue) {
        leftSide.setLeft(newValue);
    }

    @Override
    public void setRight(int newValue) {
        rightSide.setRight(newValue);
    }

    public boolean split() {
        if(leftSide instanceof SnailLeaf && getLeft() >= 10) {
            int left = getLeft();
            leftSide = new SnailNumber( this, new SnailLeaf(left/2), new SnailLeaf(left - (left/2)));
            return true;
        }
        if (leftSide.split()) {
            return true;
        }
        if(rightSide instanceof  SnailLeaf && getRight() >= 10) {
            int right = getRight();
            rightSide = new SnailNumber( this, new SnailLeaf(right/2), new SnailLeaf(right - (right/2)));
            return true;
        }
        if (rightSide.split()) {
            return true;
        }
        return false;
    }

    @Override
    public void setParent(SnailNumber parent) {
        this.parent = parent;
    }

    public int getMagnitude() {
        return leftSide.getMagnitude() * 3 + rightSide.getMagnitude() * 2;
    }

    private class SnailLeaf implements SnailPart {
        private int value;

        public SnailLeaf(int input) {
            value = input;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }

        @Override
        public int getLeft() {
            return value;
        }

        @Override
        public int getRight() {
            return value;
        }

        @Override
        public void setLeft(int newValue) {
            value = newValue;
        }

        @Override
        public void setRight(int newValue) {
            value = newValue;
        }

        @Override
        public boolean doExplode(int level) {
            //No explosion in SnailLeafs
            return false;
        }

        @Override
        public boolean split() {
            // No explosion found
            return false;
        }

        @Override
        public void setParent(SnailNumber parent) {
            // Do nothing
        }

        @Override
        public int getMagnitude() {
            return value;
        }
    }
}

interface SnailPart {
    int getLeft();

    int getRight();

    void setLeft(int newValue);

    void setRight(int newValue);

    boolean doExplode(int level);

    boolean split();

    void setParent(SnailNumber parent);

    int getMagnitude();
}