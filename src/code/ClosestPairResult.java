package code;

public class ClosestPairResult {
    public Point p1, p2;
    public double dist;

    public ClosestPairResult(Point p1, Point p2, double dist) {
        this.p1 = p1;
        this.p2 = p2;
        this.dist = dist;
    }

    @Override
    public String toString() {
        return "ClosestPairResult{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", dist=" + dist +
                '}';
    }
}
