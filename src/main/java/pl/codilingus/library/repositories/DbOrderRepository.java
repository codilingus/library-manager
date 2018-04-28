package pl.codilingus.library.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.codilingus.library.Order;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
@Component
public class DbOrderRepository implements OrderRepository{

    private EntityManager entityManager;

    @Autowired
    public DbOrderRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void addOrder(Order order) {
        entityManager.persist(order);
    }

    @Override
    @Transactional
    public Order updateOrder(Order order, int id) {
        order.setId(id);
        return entityManager.merge(order);
    }

    @Override
    @Transactional
    public List<Order> getAllOrders() {
        return null;
    }
}
