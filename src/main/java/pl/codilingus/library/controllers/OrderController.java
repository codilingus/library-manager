package pl.codilingus.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.codilingus.library.Order;
import pl.codilingus.library.OrderComparator;
import pl.codilingus.library.OverdueOrder;
import pl.codilingus.library.repositories.OrderRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/order")
    public ResponseEntity addOrder(@RequestBody Order order){
        orderRepository.addOrder(order);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/order/{id}")
    public ResponseEntity updateOrder(@RequestBody Order order , @PathVariable int id){
        orderRepository.updateOrder(order , id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Autowired
    private Comparator<OverdueOrder> orderComparator = new OrderComparator();

    @GetMapping("/orders/overdue")
    public List<OverdueOrder> getOverdueOrders(){
        return orderRepository.getOverdueOrders().stream()
                .map(order -> new OverdueOrder(
                        order.getUser().getId(),
                        order.getUser().getFirstName(),
                        order.getUser().getLastName(),
                        order.getId(),
                        order.daysAfterDeadline()))
                .sorted(orderComparator)
                .collect(Collectors.toList());
    }
}
