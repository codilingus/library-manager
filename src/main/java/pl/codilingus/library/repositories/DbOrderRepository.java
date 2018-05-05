package pl.codilingus.library.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.codilingus.library.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
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
        Query query = entityManager.createQuery("FROM Order");
        List resultList = query.getResultList();
        return (List<Order>) resultList;
    }

    @Override
    @Transactional
    public List<Order> getOverdueOrders() {
        Query query = entityManager.createQuery("FROM Order WHERE dateOfReturn IS NULL AND dateToReturn < CURDATE()");
        List resultList = query.getResultList();
        return (List<Order>) resultList;
    }

    @Override
    @Transactional
    public Order findOrderById(int id) {
       Order order = entityManager.find(Order.class, id);
        if (order == null) {
            throw new EntityNotFoundException("Can't find Order for ID "
                    + id);
        }
        return order;
    }
}
