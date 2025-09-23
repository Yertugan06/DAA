import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.DeterministicSelect;
import java.util.*;

class DeterministicSelectTest {

    @Test
    void testSelectRandomTrials() {
        Random rand = new Random();
        for (int t = 0; t < 100; t++) {
            int[] arr = rand.ints(200, -1000, 1000).toArray();
            int[] copy = arr.clone();
            int k = rand.nextInt(arr.length);

            int result = DeterministicSelect.select(arr, k);
            Arrays.sort(copy);

            assertEquals(copy[k], result);
        }
    }

    @Test
    void testSelectSmallFixedArray() {
        int[] arr = {7, 3, 9, 1, 5};
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        for (int k = 0; k < arr.length; k++) {
            int res = DeterministicSelect.select(arr.clone(), k);
            assertEquals(sorted[k], res);
        }
    }
}

