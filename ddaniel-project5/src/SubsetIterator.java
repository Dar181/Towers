import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * A class representing the iterator of subsets in a list. Produces all possible subsets.
 *
 * @author Darvensky Daniel
 * @version 1.0 Build 2024.04.10
 */
public class SubsetIterator<T> implements Iterator<List<T>> {
    /**
     * The list to be iterated through.
     */
    private List<T> list;
    /**
     * The max number of subsets possible.
     */
    private long max = 0;
    /**
     * The current subset that is being looked at.
     */
    private long currSub;

    /**
     * Constructor method for the Subiterator list class.
     *
     * @param list The list to be iterated through
     */
    public SubsetIterator(List<T> list) {
        this.list = list;
        this.max = (1L << list.size()) - 1;
    }

    /**
     *Checks if there is a next value in the list.
     *
     * @return True or False if next value is in list
     */
    @Override
    public boolean hasNext() {
        return currSub < max;
    }

    /**
     * Produces subset of list and increases count to go to current sub.
     *
     * @return The next subset of a list
     */
    @Override
    public List<T> next() {
        List<T> subList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if ((currSub & (1L << i)) != 0){
                subList.add(list.get(i));
            }
        }

        currSub++;
        return subList;
    }
}
