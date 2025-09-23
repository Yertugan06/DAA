package code;

import java.util.*;

public class ClosestPairOfPoint2D {

    // ✅ Main API
    public static ClosestPairResult closestPair(Point[] pts) {
        Point[] px = pts.clone();
        Point[] py = pts.clone();
        Arrays.sort(px, Comparator.comparingInt(p -> p.x));
        Arrays.sort(py, Comparator.comparingInt(p -> p.y));
        return closestUtil(px, py);
    }

    // ✅ Recursive function
    private static ClosestPairResult closestUtil(Point[] px, Point[] py) {
        int n = px.length;

        // Base case: brute force
        if (n <= 3) {
            return bruteForce(px, 0, n);
        }

        // Divide
        int mid = n / 2;
        Point midPoint = px[mid];

        // Left and right halves (sorted by x)
        Point[] Qx = Arrays.copyOfRange(px, 0, mid);
        Point[] Rx = Arrays.copyOfRange(px, mid, n);

        // Partition py into Qy and Ry
        List<Point> QyList = new ArrayList<>();
        List<Point> RyList = new ArrayList<>();
        for (Point p : py) {
            if (p.x <= midPoint.x) QyList.add(p);
            else RyList.add(p);
        }
        Point[] Qy = QyList.toArray(new Point[0]);
        Point[] Ry = RyList.toArray(new Point[0]);

        // Recurse
        ClosestPairResult left = closestUtil(Qx, Qy);
        ClosestPairResult right = closestUtil(Rx, Ry);

        // Best of left/right
        ClosestPairResult best = (left.dist < right.dist) ? left : right;

        // Build strip (points close to mid line)
        List<Point> strip = new ArrayList<>();
        for (Point p : py) {
            if (Math.abs(p.x - midPoint.x) < best.dist) {
                strip.add(p);
            }
        }

        // Check strip
        ClosestPairResult stripBest = stripClosest(strip, best.dist);
        return (stripBest != null && stripBest.dist < best.dist) ? stripBest : best;
    }

    // ✅ Brute force
    public static ClosestPairResult bruteForce(Point[] pts, int l, int r) {
        double min = Double.POSITIVE_INFINITY;
        Point p1 = null, p2 = null;
        for (int i = l; i < r; i++) {
            for (int j = i + 1; j < r; j++) {
                double d = dist(pts[i], pts[j]);
                if (d < min) {
                    min = d;
                    p1 = pts[i];
                    p2 = pts[j];
                }
            }
        }
        return new ClosestPairResult(p1, p2, min);
    }

    // ✅ Check strip (7 neighbors rule)
    private static ClosestPairResult stripClosest(List<Point> strip, double d) {
        double min = d;
        Point p1 = null, p2 = null;

        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < strip.size() && (strip.get(j).y - strip.get(i).y) < min; j++) {
                double dist = dist(strip.get(i), strip.get(j));
                if (dist < min) {
                    min = dist;
                    p1 = strip.get(i);
                    p2 = strip.get(j);
                }
            }
        }
        if (p1 == null) return null;
        return new ClosestPairResult(p1, p2, min);
    }

    // ✅ Euclidean distance
    private static double dist(Point a, Point b) {
        return Math.hypot(a.x - b.x, a.y - b.y);
    }


}
