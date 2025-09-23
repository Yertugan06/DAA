import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.MergeSort;
import java.util.*;

class MergeSortTest {

    @Test
    void testMergeSortRandomArrays() {
        Random rand = new Random();
        for (int n : new int[]{10, 100, 1000}) {
            int[] arr = rand.ints(n, -1000, 1000).toArray();
            int[] copy = arr.clone();

            MergeSort.sort(arr);
            Arrays.sort(copy);

            assertArrayEquals(copy, arr);
        }
    }

    @Test
    void testMergeSortAdversarial() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] copy = arr.clone();

        MergeSort.sort(arr);
        Arrays.sort(copy);

        assertArrayEquals(copy, arr);
    }
}
