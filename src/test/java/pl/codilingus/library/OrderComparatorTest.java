package pl.codilingus.library;

import org.junit.Test;
import static org.junit.Assert.*;

public class OrderComparatorTest {

    private OrderComparator orderComparator = new OrderComparator();

    @Test
    public void shouldBeOne() {
        OverdueOrder order1 = new OverdueOrder(1, "Jan", "Kowalski", 2, 3);
        OverdueOrder order2 = new OverdueOrder(3, "Adam", "Nowak", 4, 2);
        int i = orderComparator.compare(order1, order2);
        assertEquals(1, i);
    }

    @Test
    public void shouldBeZero() {
        OverdueOrder order1 = new OverdueOrder(1, "Jan", "Kowalski", 2, 2);
        OverdueOrder order2 = new OverdueOrder(3, "Adam", "Nowak", 4, 2);
        int i = orderComparator.compare(order1, order2);
        assertEquals(0, i);
    }

    @Test
    public void shouldBeMinusOne(){
        OverdueOrder order1 = new OverdueOrder(1, "Jan", "Kowalski", 2, 3);
        OverdueOrder order2 = new OverdueOrder(3, "Adam", "Nowak", 4, 5);
        int i = orderComparator.compare(order1, order2);
        assertEquals(-1, i);
    }
}