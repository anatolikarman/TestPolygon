import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;

/**
 * This iterator implementation takes in an iterator of integers.
 * <p>
 * This implementation will iterate over even integers only.
 */
public class EvenNumbersIterator implements Iterator {
    private Iterator<Integer> iterator;

    private boolean hasNextCalled;

    private Integer next;
    private boolean hasNextValue;

    /**
     * Constructor which takes in an Iterator of Integers.
     *
     * @param iterator - Iterator of integers.
     * @throws RuntimeException - Throws runtime exception if the iterator being passed is null.
     */
    public EvenNumbersIterator(Iterator<Integer> iterator) {
        if (iterator == null) {
            throw new RuntimeException("Iterator cannot be null.");
        }

        this.iterator = iterator;
    }

    /**
     * This returns if the iterator has the next element.
     *
     * @return boolean
     */
    public boolean hasNext()
    {
        boolean hasNext = false;

        hasNextCalled = true;

        while (hasNext = iterator.hasNext())
        {
            Integer number = iterator.next();

            if (number != null && number % 2 == 0)
            {
                next = number;
                break;
            }
        }

        return hasNext;
    }

    /**
     * Returns the next element of the iterator. Throws NoSuchElementException if there is no more elements.
     *
     * @return Object
     */
    public Integer next() {
        Integer returnValue = null;

        if (hasNextCalled) {
            hasNextCalled = false;
            returnValue = next;

            if (returnValue == null) {
                throw new NoSuchElementException();
            }
        } else {
            while (iterator.hasNext()) {
                returnValue = iterator.next();

                if (returnValue != null && returnValue % 2 == 0) {
                    break;
                }
            }

            if (returnValue == null) {
                throw new NoSuchElementException();
            }
        }

        return returnValue;
    }

    public void remove() {

    }
}
