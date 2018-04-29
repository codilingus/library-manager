package pl.codilingus.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.codilingus.library.Order;
import pl.codilingus.library.repositories.OrderRepository;

import java.util.List;

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
}
