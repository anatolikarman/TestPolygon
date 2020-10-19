import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class EvenNumbersIterator implements Iterator {
    private Iterator<Integer> iterator;
    private boolean hasNextCalled;
    private Integer next;


    public EvenNumbersIterator(List<Integer> list) {
        iterator = list.iterator();
    }


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
