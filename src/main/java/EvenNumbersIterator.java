import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This iterator implementation takes in an iterator of integers.
 * <p>
 * This implementation will iterate over even integers only.
 */
public class EvenNumbersIterator implements Iterator {
    private Iterator<Integer> iterator;
    private boolean hasNextCalled;
    private Integer next;


    /**
     * Constructor which takes in an Iterator of Integers.
     *
     * @param iterator - Iterator of integers.
     * @throws RuntimeException - Throws runtime exception if the iterator being passed is null.
     */
    public EvenNumbersIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    /**
     * This returns if the iterator has the next element.
     *
     * @return boolean
     */
    @Override
    public boolean hasNext() {
        hasNextCalled = false;
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next % 2 == 0) {
                hasNextCalled = true;
                break;
            }

        }
        return hasNextCalled;
    }

    @Override
    public Integer next() {
        Integer returnValue = null;
        if (hasNextCalled) {
            return next;
        }
        while (iterator.hasNext()) {
            returnValue = iterator.next();
            if (returnValue % 2 == 0) {
                break;
            }
        }
        if (returnValue == null
        ) {
            throw new NoSuchElementException();
        }
        return returnValue;
    }

    public void remove() {
        iterator.remove();
    }
}
