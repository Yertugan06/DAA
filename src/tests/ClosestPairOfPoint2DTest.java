package tests;

import code.*;

import java.util.*;

public class ClosestPairOfPoint2DTest {
    public static void main(String[] args) {
        System.out.println("--- Closest Pair of Points Tests ---");

        // ✅ 1. Hardcoded example
        Point[] example = {
                new Point(2, 3), new Point(12, 30), new Point(40, 50),
                new Point(5, 1), new Point(12, 10), new Point(3, 4)
        };
        ClosestPairResult exRes = ClosestPairOfPoint2D.closestPair(example);
        System.out.println("Hardcoded Example:");
        System.out.println("Closest distance = " + exRes.dist);
        System.out.println("Between points (" + exRes.p1.x + "," + exRes.p1.y +
                ") and (" + exRes.p2.x + "," + exRes.p2.y + ")");
        System.out.println();

        // ✅ 2. Random small n: compare brute vs fast
        Random rand = new Random(123);
        boolean allGood = true;
        for (int trial = 0; trial < 5; trial++) {
            int n = rand.nextInt(50) + 10;
            Point[] pts = new Point[n];
            for (int i = 0; i < n; i++) {
                pts[i] = new Point(rand.nextInt(500), rand.nextInt(500));
            }
            ClosestPairResult brute = ClosestPairOfPoint2D.bruteForce(pts, 0, pts.length);
            ClosestPairResult fast = ClosestPairOfPoint2D.closestPair(pts);

            if (Math.abs(brute.dist - fast.dist) > 1e-9) {
                System.out.println("❌ Mismatch at trial " + trial);
                allGood = false;
            }
        }
        System.out.println("Random small n brute vs fast -> " + (allGood ? "PASSED ✅" : "FAILED ❌"));
        System.out.println();

        // ✅ 3. Large n: fast only
        int n = 20000;
        Point[] pts = new Point[n];
        for (int i = 0; i < n; i++) {
            pts[i] = new Point(rand.nextInt(1_000_000), rand.nextInt(1_000_000));
        }
        ClosestPairResult largeRes = ClosestPairOfPoint2D.closestPair(pts);
        System.out.println("Large n run completed (n=" + n + ")");
        System.out.println("Closest distance = " + largeRes.dist);
        System.out.println("Between points (" + largeRes.p1.x + "," + largeRes.p1.y +
                ") and (" + largeRes.p2.x + "," + largeRes.p2.y + ")");
    }
}
