package learn.transactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import learn.transactions.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
  
}
