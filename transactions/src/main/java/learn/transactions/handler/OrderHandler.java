package learn.transactions.handler;


import learn.transactions.entity.Orders;
import learn.transactions.repository.OrderRepository;

public class OrderHandler {

  private final OrderRepository orderRepository;

  public OrderHandler(OrderRepository orderRepository) {
    this.orderRepository = orderRepository;
  }

  public Orders saveOrder(Orders order) {
    return orderRepository.save(order);
  }
  
}
