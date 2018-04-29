package pl.codilingus.library.repositories;

import pl.codilingus.library.Order;

import java.util.List;

public interface OrderRepository {

    void addOrder(Order order);

    Order updateOrder(Order order, int id);

    List<Order> getAllOrders();



}
