package pl.codilingus.library;

import org.springframework.stereotype.Component;

import java.util.Comparator;

@Component
public class OrderComparator implements Comparator<OverdueOrder> {
    @Override
    public int compare(OverdueOrder order1, OverdueOrder order2) {
        Integer overdueDays1 = order1.getOverdueDays();
        Integer overdueDays2 = order2.getOverdueDays();
        return overdueDays1.compareTo(overdueDays2);
    }
}
