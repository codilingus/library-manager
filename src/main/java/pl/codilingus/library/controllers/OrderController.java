package pl.codilingus.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.codilingus.library.Order;
import pl.codilingus.library.OrderComparator;
import pl.codilingus.library.OrderDTO;
import pl.codilingus.library.OverdueOrder;
import pl.codilingus.library.repositories.BookRepository;
import pl.codilingus.library.repositories.DbOrderRepository;
import pl.codilingus.library.repositories.OrderRepository;
import pl.codilingus.library.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderComparator orderComparator;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/order")
    public ResponseEntity addOrder(@RequestBody OrderDTO orderDto) {
        Order order = new Order(userRepository.findUserById(orderDto.getUser()), bookRepository.findBookById(orderDto.getBorrowedBook()), orderDto.getDateOfBorrow() , orderDto.getDateToReturn());
        orderRepository.addOrder(order);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/order/{id}")
    public ResponseEntity updateOrder(@RequestBody OrderDTO orderDto, @PathVariable int id) {
        Order order = new Order(userRepository.findUserById(orderDto.getUser()), bookRepository.findBookById(orderDto.getBorrowedBook()), orderDto.getDateOfBorrow() , orderDto.getDateToReturn());
        orderRepository.updateOrder(order, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }
    @PutMapping("/order/close/{id}")
    public ResponseEntity closeOrder(@RequestBody OrderDTO orderDTO , @PathVariable int id){
        Order orderById = orderRepository.findOrderById(id);
        orderById.setDateOfReturn(orderDTO.getDateOfReturn());
        orderRepository.updateOrder(orderById, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/orders/overdue")
    public List<OverdueOrder> getOverdueOrders() {
        return orderRepository.getOverdueOrders().stream()
                .map(order -> new OverdueOrder(
                        order.getUser().getId(),
                        order.getUser().getFirstName(),
                        order.getUser().getLastName(),
                        order.getId(),
                        order.getDaysAfterDeadline()))
                .sorted(orderComparator)
                .collect(Collectors.toList());
    }

}
