import java.util.*;

class Result {
    int distSq;   // squared distance
    Point p1, p2;
    Result(int distSq, Point p1, Point p2) {
        this.distSq = distSq;
        this.p1 = p1;
        this.p2 = p2;
    }
}

public class ClosestPairOfPoint2D {

    private static int dist(Point p1, Point p2) {
        int dx = p1.getX() - p2.getX();
        int dy = p1.getY() - p2.getY();
        return dx * dx + dy * dy;
    }

    private static Result better(Result a, Result b) {
        return (a.distSq < b.distSq) ? a : b;
    }

    private static Result closestPairBruteForce(Point[] pts, int l, int r) {
        Result best = new Result(Integer.MAX_VALUE, null, null);
        for (int i = l; i < r; i++) {
            for (int j = i + 1; j < r; j++) {
                int d = dist(pts[i], pts[j]);
                if (d < best.distSq) {
                    best = new Result(d, pts[i], pts[j]);
                }
            }
        }
        return best;
    }

    private static Result closestUtil(Point[] pts, Point[] tmp, int l, int r) {
        if (r - l <= 3) {
            return closestPairBruteForce(pts, l, r);
        }

        int m = (l + r) / 2;
        int midx = pts[m].getX();

        Result left = closestUtil(pts, tmp, l, m);
        Result right = closestUtil(pts, tmp, m, r);
        Result best = better(left, right);

        // Merge by Y
        int i = l, j = m, k = l;
        while (i < m && j < r) {
            if (pts[i].getY() < pts[j].getY()) tmp[k++] = pts[i++];
            else tmp[k++] = pts[j++];
        }
        while (i < m) tmp[k++] = pts[i++];
        while (j < r) tmp[k++] = pts[j++];
        System.arraycopy(tmp, l, pts, l, r - l);

        // Build strip
        List<Point> strip = new ArrayList<>();
        for (int t = l; t < r; t++) {
            if ((pts[t].getX() - midx) * (pts[t].getX() - midx) < best.distSq) {
                strip.add(pts[t]);
            }
        }

        // Check strip
        for (int p = 0; p < strip.size(); p++) {
            for (int q = p + 1; q < strip.size() &&
                    (strip.get(q).getY() - strip.get(p).getY()) *
                            (strip.get(q).getY() - strip.get(p).getY()) < best.distSq; q++) {
                int d = dist(strip.get(p), strip.get(q));
                if (d < best.distSq) {
                    best = new Result(d, strip.get(p), strip.get(q));
                }
            }
        }

        return best;
    }

    public static Result FindClosestPairs(Point[] points) {
        Arrays.sort(points, new CustomCompareSetting()::cmp_x);
        Point[] tmp = new Point[points.length];
        return closestUtil(points, tmp, 0, points.length);
    }

    public static void main(String[] args) {
        Point[] points = {
                new Point(2, 3), new Point(12, 30), new Point(40, 50),
                new Point(5, 1), new Point(12, 10), new Point(3, 4)
        };

        Result res = FindClosestPairs(points);
        System.out.println("The closest distance is " + Math.sqrt(res.distSq));
        System.out.println("Between points (" + res.p1.getX() + ", " + res.p1.getY() +
                ") and (" + res.p2.getX() + ", " + res.p2.getY() + ")");
    }
}
