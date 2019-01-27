public class Main {

    public static void main(String[] args) {
        Rectangle a = new Rectangle(1, 1, 6, 3);
        Rectangle b = new Rectangle(5, 2, 3, 6);
        System.out.println(getRectangleOverlap(a, b));

        //test the case where one rectangle is completely inside another
        Rectangle c = new Rectangle(0, 0, 3, 3);
        Rectangle d = new Rectangle(0, 0, 1, 1);
        System.out.println(getRectangleOverlap(c, d));

        //touch but don't overlap
        Rectangle e = new Rectangle(0, 0, 1, 1);
        Rectangle f = new Rectangle(1, 1, 1, 1 );
        System.out.println(getRectangleOverlap(e, f));

        //don't overlap at all
        Rectangle g = new Rectangle(0, 0, 1, 1);
        Rectangle h = new Rectangle(2, 2, 1, 1 );
        System.out.println(getRectangleOverlap(g, h));

        //also try one with the order of the rectangles reversed
        System.out.println(getRectangleOverlap(b, a));
    }

    public static int getOverlapOneDimension(int lower1, int higher1, int lower2, int higher2) {
        int highestStartingPoint = Math.max(lower1, lower2);
        int lowestEndingPoint = Math.min(higher1, higher2);
        if(highestStartingPoint >= lowestEndingPoint)
            return 0;
        return lowestEndingPoint - highestStartingPoint;
    }

//    public static int findXOverlapImproved(Rectangle a, Rectangle b) {
//        int highestStartingPoint = Math.max(a.getLeftX(), b.getLeftX());
//        int lowestEndingPoint = Math.min(a.getRightX(), b.getRightX());
//        if(highestStartingPoint >= lowestEndingPoint) {
//            return 0;
//        }
//        return lowestEndingPoint - highestStartingPoint;
//    }

    public static int findYOverlapImproved(Rectangle a, Rectangle b) {
        return getOverlapOneDimension(a.getBottomY(), a.getUpperY(), b.getBottomY(), b.getUpperY());
    }

    public static int findXOverlapImproved(Rectangle a, Rectangle b) {
        return getOverlapOneDimension(a.getLeftX(), a.getRightX(), b.getLeftX(), b.getRightX());
    }
//    //get the location and magnitude of the overlap as a pair
//    public static int[] findXOverlap(Rectangle a, Rectangle b) {
//        //a starts to the right of where b starts
//        if(a.getLeftX() >= b.getLeftX()) {
//            //a ends to the right of where b ends.  The overlap is therefore a partial or no overlap
//            if(a.getRightX() < b.getLeftX()) { //no overlap
//                return null;
//            }
//            if(a.getRightX() >= b.getRightX()) { //partial overlap
//                return new int[] { a.getLeftX(), b.getRightX() - a.getLeftX() };
//            }
//            //a ends to the left of where b ends.  B is a super of a.  Return A's coordinates and magnitude
//            return new int[] { a.getLeftX(), a.getWidth() };
//        }
//        //a starts to the left of where b starts
//        else {
//            //no overlap
//            if(a.getLeftX() > b.getRightX()) {
//                return null;
//            }
//            //a ends to the left of where b ends.  There is a partial overlap
//            if(a.getRightX() <= b.getRightX()) {
//                return new int[] { b.getLeftX(), a.getRightX() - b.getLeftX() };
//            }
//            //a ends to the right of where b ends.  A is a super of b.  Return B's coordinates and magnitude
//            return new int[] { b.getLeftX(), b.getWidth() };
//        }
//    }

    public static Rectangle getRectangleOverlap(Rectangle a, Rectangle b) {
        int xOverlap = findXOverlapImproved(a, b);
        int yOverlap = findYOverlapImproved(a, b);
        if(xOverlap == 0 || yOverlap == 0)
            return new Rectangle();
        int highestStartingX = Math.max(a.getLeftX(), b.getLeftX());
        int highestStartingY = Math.max(a.getBottomY(), b.getBottomY());
        return new Rectangle(highestStartingX, highestStartingY, xOverlap, yOverlap);
    }
}
