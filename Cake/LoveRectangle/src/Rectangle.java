public class Rectangle {

    private int leftX;
    private int bottomY;

    private int width;
    private int height;

    public Rectangle() {};

    public Rectangle(int leftX, int bottomY, int width, int height) {
        this.leftX = leftX;
        this.bottomY = bottomY;
        this.width = width;
        this.height = height;
    }

    public int getLeftX() {
        return leftX;
    }

    public int getBottomY() {
        return bottomY;
    }

    public int getUpperY() {
        return bottomY + height;
    }

    public int getRightX() {
        return leftX + width;
    }

    @Override
    public String toString() {
        if(width == 0 || height == 0) //was not set
            return "Empty rectangle";
        return "Rectangle going from (" + leftX + "," + bottomY + ") to (" + getRightX() + "," + getUpperY() + ")";
    }
}
