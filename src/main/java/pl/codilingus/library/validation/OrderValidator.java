package pl.codilingus.library.validation;
import org.springframework.beans.factory.annotation.Autowired;
import pl.codilingus.library.Book;
import pl.codilingus.library.Order;
import pl.codilingus.library.controllers.OrderController;
import pl.codilingus.library.repositories.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

public class OrderValidator {

    @Autowired
    private OrderRepository orderRepository;

    private boolean validateOrderingMonth(Order newOrder, List<Order> listOfOrders){
        return listOfOrders.stream()
                .filter(order -> order.getUser().getId() == newOrder.getUser().getId())
                .filter(order -> order.getBorrowedBook().getId() == newOrder.getBorrowedBook().getId())
                .filter(order -> order.getDateOfBorrow().getMonthValue() == newOrder.getDateOfBorrow().getMonthValue())
                .collect(Collectors.toList()).isEmpty();
    }

    private boolean validateBorrowedBook(Order newOrder, List<Order> listOfOrders){
        return listOfOrders.stream()
                .filter(order -> order.getBorrowedBook().getId() == newOrder.getBorrowedBook().getId())
                .filter(order -> order.getDateOfReturn() == null)
                .collect(Collectors.toList()).isEmpty();
    }

    private boolean validateAuthor(Order newOrder, List<Order> listOfOrders){
        return listOfOrders.stream()
                .filter(order -> order.getBorrowedBook().getAuthor().equals(newOrder.getBorrowedBook().getAuthor()))
                .collect(Collectors.toList()).isEmpty();
    }

    public boolean validationMechanism(Order newOrder){
        List<Order> listOfOrders = orderRepository.getAllOrders();
        return validateOrderingMonth(newOrder, listOfOrders)
                && validateBorrowedBook(newOrder, listOfOrders)
                && validateAuthor(newOrder, listOfOrders);
    }

}
