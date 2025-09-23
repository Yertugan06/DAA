import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.QuickSortRobust;
import java.util.*;

class QuickSortRobustTest {

    @Test
    void testQuickSortCorrectness() {
        Random rand = new Random();
        for (int n : new int[]{10, 100, 1000, 10000}) {
            int[] arr = rand.ints(n, -1000, 1000).toArray();
            int[] copy = arr.clone();

            QuickSortRobust.quickSort(arr);
            Arrays.sort(copy);

            assertArrayEquals(copy, arr);
        }
    }

    @Test
    void testQuickSortAdversarialArray() {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] copy = arr.clone();

        QuickSortRobust.quickSort(arr);
        Arrays.sort(copy);

        assertArrayEquals(copy, arr);
    }

    @Test
    void testRecursionDepthBound() {
        int n = 10000;
        int[] arr = new Random().ints(n, -1000, 1000).toArray();

        QuickSortRobust.quickSort(arr);
        int depth = QuickSortRobust.getMaxDepth(); // you must implement tracking

        int bound = 2 * (int)Math.floor(Math.log(n) / Math.log(2)) + 10;
        assertTrue(depth <= bound, "Recursion depth exceeded expected bound");
    }
}
