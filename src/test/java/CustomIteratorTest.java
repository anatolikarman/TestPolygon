import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class CustomIteratorTest {
    private List<Integer> list;
    private List<Integer> resultList;
    private Iterator<Integer> iterator;
    private EvenNumbersIterator customIterator;

    @Before
    public void initializeIteratorAndResultList() {
        resultList = new ArrayList<Integer>();
    }

    @Test
    public void allEvenNumbersList() {
        list = new ArrayList<Integer>(Arrays.asList(8, 4, 10, 12, 14));
        iterator = list.iterator();
        customIterator = new EvenNumbersIterator(iterator);
        while (customIterator.hasNext()) {
            resultList.add(customIterator.next());
        }
        Assert.assertArrayEquals(list.toArray(), resultList.toArray());
    }

    @Test
    public void allOddNumbers() {
        list = new ArrayList<Integer>(Arrays.asList(13, 5, 99, 11, 33));
        iterator = list.iterator();
        customIterator = new EvenNumbersIterator(iterator);
        while (customIterator.hasNext()) {
            resultList.add(customIterator.next());
        }
        Assert.assertTrue(resultList.isEmpty());
    }

}
