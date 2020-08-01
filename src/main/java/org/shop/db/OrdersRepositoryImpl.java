package org.shop.db;

import org.shop.db.entity.OrderEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Here you need to specify
 * all methods which you think will be useful to complete your task
 */
@Repository
public class OrdersRepositoryImpl implements OrdersRepository {

    private final EntityManagerFactory entityManagerFactory;

    public OrdersRepositoryImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    public List<OrderEntity> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("FROM OrderEntity", OrderEntity.class).getResultList();
    }

    public OrderEntity update(long orderId, String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        OrderEntity orderEntity = entityManager.find(OrderEntity.class, orderId);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        orderEntity.setName(name);
        transaction.commit();
        return orderEntity;
    }

    public void deleteOrder(long orderId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.createQuery("delete from OrderEntity o where o.id=:id")
                .setParameter("id", orderId)
                .executeUpdate();
        transaction.commit();
    }


    public OrderEntity findOrderBy(long orderId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(OrderEntity.class, orderId);
    }

    public void saveOrder(OrderEntity orderEntity){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(orderEntity);
        transaction.commit();
    }
}
