import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CustomIteratorTest {
    private List<Integer> list;
    private List<Integer> resultList;

    @Test
    public void allEvenNumbersList() {
        list = new ArrayList<Integer>(Arrays.asList(8, 4, 10, 12, 14));
        resultList = new ArrayList<Integer>();
        Iterator<Integer> iterator = list.iterator();
        EvenNumbersIterator customIterator = new EvenNumbersIterator(iterator);
        while (customIterator.hasNext()) {
            resultList.add(customIterator.next());
        }

        Assert.assertArrayEquals(list.toArray(), resultList.toArray());
    }

    @Test
    public void allOddNumbers() {
        list = new ArrayList<Integer>(Arrays.asList(13, 5, 99, 11, 33));
        resultList = new ArrayList<Integer>();
        Iterator<Integer> iterator = list.iterator();
        EvenNumbersIterator customIterator = new EvenNumbersIterator(iterator);
        while (customIterator.hasNext()) {
            resultList.add(customIterator.next());
        }

        Assert.assertTrue(resultList.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorShouldThrowNoSuchElementException() {
        list = new ArrayList<Integer>();
        resultList = new ArrayList<Integer>();
        Iterator<Integer> iterator = list.iterator();
        EvenNumbersIterator customIterator = new EvenNumbersIterator(iterator);
        customIterator.hasNext();
    }
}
