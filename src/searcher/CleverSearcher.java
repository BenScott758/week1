package searcher;

import java.util.Arrays;
public class CleverSearcher extends Searcher {

    /**
     * @param array
     * @param k
     */
    CleverSearcher(int[] array, int k) {
        super(array, k);
    }

    @Override
    public int findElement() throws IndexingError {
        int[] array = getArray();
        int k = getIndex();
        if (k <= 0 || k > array.length) {
            throw new IndexingError();
        }
        int[] smallArray = new int[k];
        for (int index = 0; index < k; index++) {
            smallArray[index] = array[index];
        }
        Arrays.sort(smallArray);
        for (int index = k; index < array.length; index++) {
            if (array[index] > smallArray[0]){
                smallArray[0] = array[index];
                Arrays.sort(smallArray);
            }
        }
        return 0;
    }
}
