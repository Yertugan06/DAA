import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.IntStream;

class ClosestPairofPointsTest {

    static class Point {
        double x, y;
        Point(double x, double y) { this.x = x; this.y = y; }
    }

    @Test
    void testClosestPairSmall() {
        Random rand = new Random();
        for (int n : new int[]{10, 100, 500, 2000}) {
            Point[] pts = IntStream.range(0, n)
                    .mapToObj(i -> new Point(rand.nextDouble(), rand.nextDouble()))
                    .toArray(Point[]::new);

            double fast = ClosestPairofPoints.closestPair(pts);
            double brute = ClosestPairofPoints.closestPairBruteForce(pts);

            assertEquals(brute, fast, 1e-9);
        }
    }

    @Test
    void testClosestPairLarge() {
        Random rand = new Random();
        int n = 100000;
        Point[] pts = IntStream.range(0, n)
                .mapToObj(i -> new Point(rand.nextDouble(), rand.nextDouble()))
                .toArray(Point[]::new);

        // Only fast version (brute force too slow here)
        double fast = ClosestPairofPoints.closestPair(pts);

        assertTrue(fast >= 0.0);
    }
}
