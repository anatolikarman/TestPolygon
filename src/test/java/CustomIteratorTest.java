import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.*;
import java.util.stream.Collectors;


public class CustomIteratorTest {
    private List<Integer> list;
    private List<Integer> resultList;
    private Iterator<Integer> iterator;
    private EvenNumbersIterator customIterator;

    @Before
    public void initializeResultList() {
        resultList = new ArrayList<>();
    }

    @Test
    public void allEvenNumbersList() {

        list = new ArrayList<>(Arrays.asList(8, 4, 10, 12, 14));
        customIterator = new EvenNumbersIterator(list);

        while (customIterator.hasNext()) {
            resultList.add(customIterator.next());
        }
        Assert.assertArrayEquals("New iterated list is defferent " +
                        "from the original one," +
                        " even though they should match",
                list.toArray(), resultList.toArray());
    }

    @Test
    public void allOddNumbersList() {

        list = new ArrayList<>(Arrays.asList(13, 5, 99, 11, 33));
        customIterator = new EvenNumbersIterator(list);

        while (customIterator.hasNext()) {
            resultList.add(customIterator.next());
        }
        Assert.assertTrue("New list should not contain any values after iteration"
                , resultList.isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementException() {

        list = new ArrayList<>();
        iterator = list.iterator();
        customIterator = new EvenNumbersIterator(list);

        customIterator.next();
    }

    @Test
    public void hasNextTest() {

        list = new ArrayList<>();
        iterator = list.iterator();
        customIterator = new EvenNumbersIterator(list);

        Assert.assertFalse("HasNext did not return false for a null element", customIterator.hasNext());
    }

    @Test
    public void removeMethodShouldReturnOddNumberList() {

        boolean evenNumberIsPresent = false;
        list = new ArrayList<>(Arrays.asList(94, 5, 66, 12, 33));
        customIterator = new EvenNumbersIterator(list);

        while (customIterator.hasNext()) {
            customIterator.next();
            customIterator.remove();
        }

        list = list.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
        Assert.assertFalse("List is not empty after removing each iterated element", list.isEmpty());
    }

}
