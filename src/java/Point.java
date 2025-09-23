import java.util.Comparator;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class CustomCompareSetting implements Comparator<Point> {

    public int cmp_x(Point p1, Point p2) {
        int minX = Integer.compare(p1.getX(), p2.getX());
        int minY = Integer.compare(p1.getY(), p2.getY());
        return (minX == 0) ? minY : minX;
    }

    public int cmp_y(Point p1, Point p2) {
        return Integer.compare(p1.getY(), p2.getY());
    }

    @Override
    public int compare(Point o1, Point o2) {
        // Default: compare by x then y
        return cmp_x(o1, o2);
    }
}
